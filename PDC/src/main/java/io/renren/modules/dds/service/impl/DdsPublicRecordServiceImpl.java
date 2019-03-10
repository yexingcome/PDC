package io.renren.modules.dds.service.impl;

import io.renren.modules.dds.dao.DdsPublicRecordDao;
import io.renren.modules.dds.entity.DdsPublicRecordEntity;
import io.renren.modules.dds.service.DdsPublicRecordService;
import io.renren.modules.dds.service.PublicFactoryService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ddsPublicRecordService")
public class DdsPublicRecordServiceImpl implements DdsPublicRecordService {
	@Autowired
	private DdsPublicRecordDao publicRecordDao;

	@Autowired
	private PublicFactoryService publicFactoryService;

	@Override
	public DdsPublicRecordEntity queryObject(String id) {
		return publicRecordDao.queryObject(id);
	}

	@Override
	public List<DdsPublicRecordEntity> queryList(Map<String, Object> map) {
		return publicRecordDao.queryList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map) {
		return publicRecordDao.queryTotal(map);
	}

	@Override
	public void save(DdsPublicRecordEntity ddsPublicRecord) {
		publicRecordDao.save(ddsPublicRecord);
	}

	@Override
	public void update(DdsPublicRecordEntity ddsPublicRecord) {
		publicRecordDao.update(ddsPublicRecord);
	}

	@Override
	public void delete(String id) {
		publicRecordDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids) {
		publicRecordDao.deleteBatch(ids);
	}

	@Override
	public void republish(String[] ids) {
		publicRecordDao.republish(ids);

		List<DdsPublicRecordEntity> list = publicRecordDao.queryObjectBatch(ids);
		for (DdsPublicRecordEntity ddsPublicRecordEntity : list) {
			publicFactoryService.repulishRecord(ddsPublicRecordEntity.getId());
		}
	}
}
