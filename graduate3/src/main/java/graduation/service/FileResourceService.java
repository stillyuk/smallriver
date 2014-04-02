package graduation.service;

import graduation.dao.FileResourceDao;
import graduation.domain.FileResource;
import graduation.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiangyukun
 * @since 2014-03-30 22:57
 */
@Service
@Transactional
public class FileResourceService {
	@Autowired
	private FileResourceDao fileResourceDao;

	public Object add(FileResource fileResource) {
		return fileResourceDao.add(fileResource);
	}

	public void update(final FileResource fileResource) {
		fileResourceDao.update(fileResource);
	}

	public FileResource queryByUserAndFileName(User user, String fileName) {
		List<FileResource> fileResources = fileResourceDao.queryByUserAndFileName(user, fileName);
		if (fileResources == null || fileResources.size() == 0) {
			return null;
		}
		return fileResources.get(0);
	}

	public List<FileResource> getAll() {
		List<FileResource> fileResources = fileResourceDao.getAll();
		return fileResources;
	}
}
