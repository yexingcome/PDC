package io.renren.modules.dds.service.impl;

import io.renren.modules.dds.dao.DdsAreaDao;
import io.renren.modules.dds.entity.DdsAreaEntity;
import io.renren.modules.dds.service.DdsAreaService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ddsAreaService")
public class DdsAreaServiceImpl implements DdsAreaService {
	@Autowired
	private DdsAreaDao ddsAreaDao;

	@Override
	public DdsAreaEntity queryObject(String id) {
		return ddsAreaDao.queryObject(id);
	}

	@Override
	public List<DdsAreaEntity> queryList(Map<String, Object> map) {
		return ddsAreaDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return ddsAreaDao.queryTotal(map);
	}

	@Override
	public void save(DdsAreaEntity ddsArea) {
		ddsAreaDao.save(ddsArea);
	}

	@Override
	public void update(DdsAreaEntity ddsArea) {
		ddsAreaDao.update(ddsArea);
	}

	@Override
	public void delete(String id) {
		ddsAreaDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids) {
		ddsAreaDao.deleteBatch(ids);
	}

}
