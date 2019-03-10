package io.renren.modules.dds.service;

import io.renren.modules.dds.entity.DdsAreaEntity;

import java.util.List;
import java.util.Map;

/**
 * 区域
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2019-01-03 10:08:55
 */
public interface DdsAreaService {

	DdsAreaEntity queryObject(String id);

	List<DdsAreaEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(DdsAreaEntity ddsArea);

	void update(DdsAreaEntity ddsArea);

	void delete(String id);

	void deleteBatch(String[] ids);
}
