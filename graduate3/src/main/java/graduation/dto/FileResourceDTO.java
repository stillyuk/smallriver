package graduation.dto;

import graduation.domain.FileResource;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author jiangyukun
 * @since 2014-03-30 16:13
 */
public class FileResourceDTO {
	private String name = "public";
	private String uploadDate = "";
	private String uploadUser = "system";
	private int downloadTimes;
	private boolean directory;

	public static FileResourceDTO[] transform(File[] files) {
		FileResourceDTO[] fileResourceDtos = new FileResourceDTO[files.length];
		for (int i = 0; i < files.length; i++) {
			fileResourceDtos[i] = new FileResourceDTO();
			fileResourceDtos[i].setName(files[i].getName());
			fileResourceDtos[i].setDirectory(files[i].isDirectory());
			fileResourceDtos[i].setUploadDate(new Date(files[i].lastModified()).toString());
		}
		return fileResourceDtos;
	}

	public static FileResourceDTO transform(File file) {
		FileResourceDTO fileResourceDto = new FileResourceDTO();
		fileResourceDto.setName(file.getName());
		fileResourceDto.setDirectory(file.isDirectory());
		fileResourceDto.setUploadDate(new Date(file.lastModified()).toString());
		return fileResourceDto;
	}

	public static FileResourceDTO transform(FileResource fileResource) {
		FileResourceDTO fileResourceDto = new FileResourceDTO();
		fileResourceDto.setName(fileResource.getFileName());
		fileResourceDto.setDownloadTimes(fileResource.getDownloadTimes());
		fileResourceDto.setUploadDate(fileResource.getUploadDate().toString());
		return fileResourceDto;
	}

	public static FileResourceDTO[] transform(List<FileResource> fileResources) {
		FileResourceDTO[] FileResourceDTO = new FileResourceDTO[fileResources.size()];
		for (int i = 0; i < fileResources.size(); i++) {
			FileResourceDTO[i] = new FileResourceDTO();
			FileResourceDTO[i].setName(fileResources.get(i).getFileName());
		}
		return FileResourceDTO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadUser() {
		return uploadUser;
	}

	public void setUploadUser(String uploadUser) {
		this.uploadUser = uploadUser;
	}

	public int getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}

	public boolean isDirectory() {
		return directory;
	}

	public void setDirectory(boolean directory) {
		this.directory = directory;
	}

}
