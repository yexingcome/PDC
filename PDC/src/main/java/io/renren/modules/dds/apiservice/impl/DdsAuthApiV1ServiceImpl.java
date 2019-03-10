package io.renren.modules.dds.apiservice.impl;

import io.renren.modules.dds.apiservice.DdsAuthApiV1Service;
import io.renren.modules.dds.dao.DdsAuthServiceDao;
import io.renren.modules.dds.entity.DdsAuthServiceEntity;
import io.renren.modules.dds.service.PublicFactoryService;
import io.renren.modules.dds.utils.DdsServiceTypes;
import io.renren.modules.dds.utils.FromInterfacePros;
import io.renren.modules.dds.utils.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ddsAuthApiV1Service")
public class DdsAuthApiV1ServiceImpl implements DdsAuthApiV1Service {

	@Autowired
	private DdsAuthServiceDao ddsAuthServiceDao;
	@Autowired
	private PublicFactoryService publicFactoryService;

	@Override
	public void authorization(String value) {
		DdsAuthServiceEntity entity = new DdsAuthServiceEntity();
		entity.setServiceType(DdsServiceTypes.authorization_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	@Override
	public void deleteAuthorization(String value) {
		DdsAuthServiceEntity entity = new DdsAuthServiceEntity();
		entity.setServiceType(DdsServiceTypes.deleteAuthorization_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	@Override
	public void freshUserInfoAuth(String value) {
		DdsAuthServiceEntity entity = new DdsAuthServiceEntity();
		entity.setServiceType(DdsServiceTypes.freshUserInfoAuth_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	private void save(DdsAuthServiceEntity entity) {
		String uuid = UUID.getUUID();
		entity.setId(uuid);
		entity.setFrominterfacepro(FromInterfacePros.BOSSBOV1);
		ddsAuthServiceDao.save(entity);
		queue(entity);
	}

	private void queue(DdsAuthServiceEntity entity) {
		new Thread(new Queue(entity)).start();
	}
	
	class Queue implements Runnable {
		DdsAuthServiceEntity entity;
		public Queue(DdsAuthServiceEntity entity) {
			this.entity = entity;
		}
		@Override
		public void run() {
			publicFactoryService.accpetRequest(entity.getId(), entity.getServiceType().toString(), "BOSS", entity.getFrominterfacepro());
		}
	}
}

