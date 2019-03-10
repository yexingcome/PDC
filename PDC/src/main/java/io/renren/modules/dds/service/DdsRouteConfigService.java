package io.renren.modules.dds.service;

import io.renren.modules.dds.entity.DdsRouteConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 路由配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
public interface DdsRouteConfigService {

	DdsRouteConfigEntity queryObject(Integer id);

	List<DdsRouteConfigEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(DdsRouteConfigEntity ddsRouteConfig);

	void update(DdsRouteConfigEntity ddsRouteConfig);

	void delete(Integer id);

	void deleteBatch(Integer[] ids);
}
