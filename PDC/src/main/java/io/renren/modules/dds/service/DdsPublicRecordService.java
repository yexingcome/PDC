package io.renren.modules.dds.service;

import io.renren.modules.dds.entity.DdsPublicRecordEntity;

import java.util.List;
import java.util.Map;

/**
 * 发布记录
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
public interface DdsPublicRecordService {

	DdsPublicRecordEntity queryObject(String id);

	List<DdsPublicRecordEntity> queryList(Map<String, Object> map);

	int queryTotal(Map<String, Object> map);

	void save(DdsPublicRecordEntity ddsPublicRecord);

	void update(DdsPublicRecordEntity ddsPublicRecord);

	void delete(String id);

	void deleteBatch(String[] ids);

	void republish(String[] ids);
}
