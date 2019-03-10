package io.renren.modules.dds.dao;

import io.renren.modules.dds.entity.DdsPlatConfigEntity;
import io.renren.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 平台配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 12:00:28
 */
@Mapper
public interface DdsPlatConfigDao extends BaseDao<DdsPlatConfigEntity> {
	List<DdsPlatConfigEntity> findPlatBySourceId(@Param("sourcePlatFlag") String sourcePlatFlag,
			@Param("sourceInterfacepro") String sourceInterfacepro);

	DdsPlatConfigEntity findTargetPlatByRouteId(@Param("routeId") Integer routeId);
}
