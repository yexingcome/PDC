package io.renren.modules.dds.dao;

import io.renren.modules.dds.entity.DdsRouteConfigEntity;
import io.renren.modules.sys.dao.BaseDao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 路由配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
@Mapper
public interface DdsRouteConfigDao extends BaseDao<DdsRouteConfigEntity> {

	DdsRouteConfigEntity findRouteByPlatFlags(@Param("sourcePlatFlag") String sourcePlatFlag,
			@Param("soruceInterfacepro") String soruceInterfacepro, @Param("targetPlatFlag") String targetPlatFlag,
			@Param("targetInterfacepro") String targetInterfacepro);

}
