package io.renren.modules.dds.service.impl;

import io.renren.modules.dds.dao.DdsPlatConfigDao;
import io.renren.modules.dds.entity.DdsPlatConfigEntity;
import io.renren.modules.dds.service.DdsPlatConfigService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ddsPlatConfigService")
public class DdsPlatConfigServiceImpl implements DdsPlatConfigService {
	@Autowired
	private DdsPlatConfigDao platConfigDao;

	@Override
	public DdsPlatConfigEntity queryObject(Integer id) {
		return platConfigDao.queryObject(id);
	}

	@Override
	public List<DdsPlatConfigEntity> queryList(Map<String, Object> map) {
		return platConfigDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return platConfigDao.queryTotal(map);
	}

	@Override
	public void save(DdsPlatConfigEntity ddsPlatConfig) {
		platConfigDao.save(ddsPlatConfig);
	}

	@Override
	public void update(DdsPlatConfigEntity ddsPlatConfig) {
		platConfigDao.update(ddsPlatConfig);
	}

	@Override
	public void delete(Integer id) {
		platConfigDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		platConfigDao.deleteBatch(ids);
	}

	@Override
	public List<DdsPlatConfigEntity> queryListAll() {
		return platConfigDao.queryListAll();
	}

}
