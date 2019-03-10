package io.renren.modules.dds.service;

import io.renren.modules.dds.entity.DdsPlatConfigEntity;

import java.util.List;
import java.util.Map;

/**
 * 平台配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 12:00:28
 */
public interface DdsPlatConfigService {

	DdsPlatConfigEntity queryObject(Integer id);

	List<DdsPlatConfigEntity> queryList(Map<String, Object> map);

	List<DdsPlatConfigEntity> queryListAll();

	int queryTotal(Map<String, Object> map);

	void save(DdsPlatConfigEntity ddsPlatConfig);

	void update(DdsPlatConfigEntity ddsPlatConfig);

	void delete(Integer id);

	void deleteBatch(Integer[] ids);
}
