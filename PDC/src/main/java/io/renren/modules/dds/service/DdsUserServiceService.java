package io.renren.modules.dds.service;

import io.renren.modules.dds.entity.DdsUserServiceEntity;

import java.util.List;
import java.util.Map;

/**
 * 关于用户信息类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
public interface DdsUserServiceService {
	
	DdsUserServiceEntity queryObject(String id);
	
	List<DdsUserServiceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DdsUserServiceEntity ddsUserService);
	
	void update(DdsUserServiceEntity ddsUserService);
	
	void delete(Integer id);
	
	void deleteBatch(String[] ids);
}
