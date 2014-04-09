package cn.zucc.graduation.service.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zucc.graduation.entity.Resource;
import cn.zucc.graduation.repository.ResourceDao;

@Service
@Transactional
public class ResouceService {

	@Autowired
	private ResourceDao resourceDao;

	public Resource saveResource(Resource resource) {
		return resourceDao.save(resource);
	}

	public List<Resource> getResourceByUserId(Long userId) {
		return resourceDao.queryResourceByUserId(userId);
	}

	public Resource getResource(Long resourceId) {
		return resourceDao.findOne(resourceId);
	}

	public Resource getResourceByResourceIdAndUserId(Long userId, Long resouceId) {
		return resourceDao.getResourceByIdAndUserId(resouceId, userId);
	}

	public List<Resource> getAllResource() {
		return (List<Resource>) resourceDao.findAll();
	}
}
