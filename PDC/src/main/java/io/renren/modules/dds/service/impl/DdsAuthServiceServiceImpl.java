package io.renren.modules.dds.service.impl;

import io.renren.modules.dds.dao.DdsAuthServiceDao;
import io.renren.modules.dds.entity.DdsAuthServiceEntity;
import io.renren.modules.dds.service.DdsAuthServiceService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ddsAuthServiceService")
public class DdsAuthServiceServiceImpl implements DdsAuthServiceService {
	@Autowired
	private DdsAuthServiceDao ddsAuthServiceDao;

	@Transactional(readOnly = true)
	@Override
	public DdsAuthServiceEntity queryObject(String id) {
		return ddsAuthServiceDao.queryObject(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DdsAuthServiceEntity> queryList(Map<String, Object> map) {
		return ddsAuthServiceDao.queryList(map);
	}

	@Transactional(readOnly = true)
	@Override
	public int queryTotal(Map<String, Object> map) {
		return ddsAuthServiceDao.queryTotal(map);
	}

	@Override
	public void save(DdsAuthServiceEntity ddsAuthService) {
		ddsAuthServiceDao.save(ddsAuthService);
	}

	@Override
	public void update(DdsAuthServiceEntity ddsAuthService) {
		ddsAuthServiceDao.update(ddsAuthService);
	}

	@Override
	public void delete(Integer id) {
		ddsAuthServiceDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids) {
		ddsAuthServiceDao.deleteBatch(ids);
	}

}
