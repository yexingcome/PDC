package io.renren.modules.dds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import io.renren.modules.dds.dao.DdsGoodsServiceDao;
import io.renren.modules.dds.entity.DdsGoodsServiceEntity;
import io.renren.modules.dds.service.DdsGoodsServiceService;



@Service("ddsGoodsServiceService")
public class DdsGoodsServiceServiceImpl implements DdsGoodsServiceService {
	@Autowired
	private DdsGoodsServiceDao ddsGoodsServiceDao;
	
	@Transactional(readOnly = true)
	@Override
	public DdsGoodsServiceEntity queryObject(String id){
		return ddsGoodsServiceDao.queryObject(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<DdsGoodsServiceEntity> queryList(Map<String, Object> map){
		return ddsGoodsServiceDao.queryList(map);
	}
	
	@Transactional(readOnly = true)
	@Override
	public int queryTotal(Map<String, Object> map){
		return ddsGoodsServiceDao.queryTotal(map);
	}
	
	@Override
	public void save(DdsGoodsServiceEntity ddsGoodsService){
		ddsGoodsServiceDao.save(ddsGoodsService);
	}
	
	@Override
	public void update(DdsGoodsServiceEntity ddsGoodsService){
		ddsGoodsServiceDao.update(ddsGoodsService);
	}
	
	@Override
	public void delete(Integer id){
		ddsGoodsServiceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		ddsGoodsServiceDao.deleteBatch(ids);
	}
	
}
