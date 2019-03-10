package io.renren.modules.dds.service;

import io.renren.modules.dds.entity.DdsAuthServiceEntity;

import java.util.List;
import java.util.Map;

/**
 * 关于授权类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
public interface DdsAuthServiceService {
	
	DdsAuthServiceEntity queryObject(String id);
	
	List<DdsAuthServiceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DdsAuthServiceEntity ddsAuthService);
	
	void update(DdsAuthServiceEntity ddsAuthService);
	
	void delete(Integer id);
	
	void deleteBatch(String[] ids);
}
