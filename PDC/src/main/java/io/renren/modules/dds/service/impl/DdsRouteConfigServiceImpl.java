package io.renren.modules.dds.service.impl;

import io.renren.modules.dds.dao.DdsRouteConfigDao;
import io.renren.modules.dds.entity.DdsRouteConfigEntity;
import io.renren.modules.dds.service.DdsRouteConfigService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ddsRouteConfigService")
public class DdsRouteConfigServiceImpl implements DdsRouteConfigService {
	@Autowired
	private DdsRouteConfigDao routeConfigDao;

	@Override
	public DdsRouteConfigEntity queryObject(Integer id) {
		return routeConfigDao.queryObject(id);
	}

	@Override
	public List<DdsRouteConfigEntity> queryList(Map<String, Object> map) {
		return routeConfigDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return routeConfigDao.queryTotal(map);
	}

	@Override
	public void save(DdsRouteConfigEntity ddsRouteConfig) {
		routeConfigDao.save(ddsRouteConfig);
	}

	@Override
	public void update(DdsRouteConfigEntity ddsRouteConfig) {
		routeConfigDao.update(ddsRouteConfig);
	}

	@Override
	public void delete(Integer id) {
		routeConfigDao.delete(id);
	}

	@Override
	public void deleteBatch(Integer[] ids) {
		routeConfigDao.deleteBatch(ids);
	}

}
