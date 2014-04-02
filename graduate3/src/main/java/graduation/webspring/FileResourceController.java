package graduation.webspring;

import graduation.core.FileUtil;
import graduation.domain.FileResource;
import graduation.dto.FileResourceDTO;
import graduation.service.FileResourceService;
import graduation.service.SystemPropertyService;
import graduation.service.UserService;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jiangyukun
 * @since 2014-03-14 18:25
 */
@Controller
@RequestMapping("/{username}/file")
@SessionAttributes({ "username" })
public class FileResourceController {
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserService userService;

	@Autowired
	private SystemPropertyService systemPropertyService;

	@Autowired
	private FileResourceService fileResourceService;

	@RequestMapping("/upload")
	public ModelAndView upload() {
		return new ModelAndView("/file/upload");
	}

	@RequestMapping("/doUpload")
	public ModelAndView doUpload(MultipartFile file, @ModelAttribute("username") String username) throws Exception {
		String DIR = FileUtil.FILE_UPLOAD_PATH + File.separatorChar + username;
		File path = new File(DIR);
		if (!path.exists()) {
			path.mkdirs();
		}
		file.transferTo(new File(DIR + File.separatorChar + file.getOriginalFilename()));
		FileResource fileResource = new FileResource();
		fileResource.setUser(userService.queryByUsername(username));
		fileResource.setFileName(file.getOriginalFilename());
		fileResource.setPath(DIR + File.separatorChar + file.getOriginalFilename());
		fileResource.setUploadDate(new Date());
		fileResourceService.add(fileResource);
		return new ModelAndView("/file/uploadResult");
	}

	@RequestMapping("/download")
	public ModelAndView download() {
		List<FileResource> fileResources = fileResourceService.getAll();
		return new ModelAndView("/file/download", "allFiles", FileResourceDTO.transform(fileResources));
	}

	@RequestMapping("/doDownload")
	public ResponseEntity<byte[]> download(@ModelAttribute("username") String username, String fileName) throws Exception {
		if (fileName == null) {
			return null;
		}
		FileResource fileResource = fileResourceService.queryByUserAndFileName(userService.queryByUsername(username), fileName);
		if (fileResource == null) {
			return null;
		}
		fileResource.setDownloadTimes(fileResource.getDownloadTimes() + 1);
		fileResourceService.update(fileResource);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", fileName);
		String filePath = fileResource.getPath();
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)), headers, HttpStatus.CREATED);
	}

	@RequestMapping("/showAllFiles")
	public ModelAndView showAllFiles(@ModelAttribute("username") String username) {
		File file = new File(FileUtil.FILE_DOWNLOAD_PATH + File.separatorChar + username);
		return new ModelAndView("/file/showAllFiles", "allFiles", file.exists() ? file.listFiles() : null);
	}

	@RequestMapping("/publicFiles")
	public ResponseEntity<FileResourceDTO[]> publicFiles() {
		File file = new File(FileUtil.PUBLIC_RESOURCE);
		return new ResponseEntity<FileResourceDTO[]>(FileResourceDTO.transform(file.exists() ? file.listFiles() : null), HttpStatus.OK);
	}

	@RequestMapping("/fileDetail")
	public ModelAndView fileDetail(String fileName, @ModelAttribute("username") String username) {
		FileResource fileResource = fileResourceService.queryByUserAndFileName(userService.queryByUsername(username), fileName);
		return new ModelAndView("/file/fileDetail", "fileDto", FileResourceDTO.transform(fileResource));
	}
}
