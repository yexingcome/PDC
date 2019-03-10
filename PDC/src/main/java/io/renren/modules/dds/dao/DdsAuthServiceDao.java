package io.renren.modules.dds.dao;

import io.renren.modules.dds.entity.DdsAuthServiceEntity;
import io.renren.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 关于授权类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
@Mapper
public interface DdsAuthServiceDao extends BaseDao<DdsAuthServiceEntity> {
	
}
