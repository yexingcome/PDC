package io.renren.modules.dds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import io.renren.modules.dds.dao.DdsUserServiceDao;
import io.renren.modules.dds.entity.DdsUserServiceEntity;
import io.renren.modules.dds.service.DdsUserServiceService;



@Service("ddsUserServiceService")
public class DdsUserServiceServiceImpl implements DdsUserServiceService {
	@Autowired
	private DdsUserServiceDao ddsUserServiceDao;
	
	@Transactional(readOnly = true)
	@Override
	public DdsUserServiceEntity queryObject(String id){
		return ddsUserServiceDao.queryObject(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<DdsUserServiceEntity> queryList(Map<String, Object> map){
		return ddsUserServiceDao.queryList(map);
	}
	
	@Transactional(readOnly = true)
	@Override
	public int queryTotal(Map<String, Object> map){
		return ddsUserServiceDao.queryTotal(map);
	}
	
	@Override
	public void save(DdsUserServiceEntity ddsUserService){
		ddsUserServiceDao.save(ddsUserService);
	}
	
	@Override
	public void update(DdsUserServiceEntity ddsUserService){
		ddsUserServiceDao.update(ddsUserService);
	}
	
	@Override
	public void delete(Integer id){
		ddsUserServiceDao.delete(id);
	}
	
	@Override
	public void deleteBatch(String[] ids){
		ddsUserServiceDao.deleteBatch(ids);
	}
	
}
