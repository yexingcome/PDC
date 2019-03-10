package io.renren.modules.dds.dao;

import io.renren.modules.dds.entity.DdsAreaEntity;
import io.renren.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 区域
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2019-01-03 10:08:55
 */
@Mapper
public interface DdsAreaDao extends BaseDao<DdsAreaEntity> {

	public DdsAreaEntity findByAreacode(@Param("areaCode") String areaCode);
}
