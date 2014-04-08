package cn.zucc.graduation.service.resource;

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
}
