package io.renren.modules.dds.apiservice.impl;

import io.renren.modules.dds.apiservice.DdsGoodsAipService;
import io.renren.modules.dds.dao.DdsGoodsServiceDao;
import io.renren.modules.dds.entity.DdsGoodsServiceEntity;
import io.renren.modules.dds.service.PublicFactoryService;
import io.renren.modules.dds.utils.DdsServiceTypes;
import io.renren.modules.dds.utils.FromInterfacePros;
import io.renren.modules.dds.utils.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ddsGoodsAipService")
public class DdsGoodsApiServiceImpl implements DdsGoodsAipService {

	@Autowired
	private DdsGoodsServiceDao ddsGoodsServiceDao;
	@Autowired
	private PublicFactoryService publicFactoryService;

	@Override
	public void modifyGoods(String value) {
		DdsGoodsServiceEntity entity = new DdsGoodsServiceEntity();
		entity.setServiceType(DdsServiceTypes.modifyGoods_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	@Override
	public void delGoods(String value) {
		DdsGoodsServiceEntity entity = new DdsGoodsServiceEntity();
		entity.setServiceType(DdsServiceTypes.delGoods_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	private void save(DdsGoodsServiceEntity entity) {
		String uuid = UUID.getUUID();
		entity.setId(uuid);
		entity.setFrominterfacepro(FromInterfacePros.BOSSBOV2);
		ddsGoodsServiceDao.save(entity);
		queue(entity);
	}

	private void queue(DdsGoodsServiceEntity entity) {
		new Thread(new Queue(entity)).start();
	}
	
	class Queue implements Runnable {
		DdsGoodsServiceEntity entity;
		public Queue(DdsGoodsServiceEntity entity) {
			this.entity = entity;
		}
		@Override
		public void run() {
			publicFactoryService.accpetRequest(entity.getId(), entity.getServiceType().toString(), "BOSS", entity.getFrominterfacepro());
		}
	}

}
