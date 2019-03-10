package io.renren.modules.dds.dao;

import io.renren.modules.dds.entity.DdsPublicRecordEntity;
import io.renren.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 发布记录
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
@Mapper
public interface DdsPublicRecordDao extends BaseDao<DdsPublicRecordEntity> {
	public void republish(String[] ids);

	public List<DdsPublicRecordEntity> getWaitPublish();

	public List<DdsPublicRecordEntity> queryObjectBatch(String[] ids);
}
