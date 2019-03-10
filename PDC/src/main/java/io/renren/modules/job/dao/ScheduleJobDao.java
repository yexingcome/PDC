package io.renren.modules.job.dao;

import io.renren.modules.job.entity.ScheduleJobEntity;
import io.renren.modules.sys.dao.BaseDao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2016年12月1日 下午10:29:57
 */
@Mapper
public interface ScheduleJobDao extends BaseDao<ScheduleJobEntity> {

	/**
	 * 批量更新状态
	 */
	int updateBatch(Map<String, Object> map);
}
