package io.renren.modules.dds.service;

import io.renren.modules.dds.entity.DdsGoodsServiceEntity;

import java.util.List;
import java.util.Map;

/**
 * 关于商品类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
public interface DdsGoodsServiceService {
	
	DdsGoodsServiceEntity queryObject(String id);
	
	List<DdsGoodsServiceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DdsGoodsServiceEntity ddsGoodsService);
	
	void update(DdsGoodsServiceEntity ddsGoodsService);
	
	void delete(Integer id);
	
	void deleteBatch(String[] ids);
}
