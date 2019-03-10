package io.renren.modules.dds.apiservice.impl;

import io.renren.modules.dds.apiservice.DdsUserApiV1Service;
import io.renren.modules.dds.dao.DdsUserServiceDao;
import io.renren.modules.dds.entity.DdsUserServiceEntity;
import io.renren.modules.dds.service.PublicFactoryService;
import io.renren.modules.dds.utils.DdsServiceTypes;
import io.renren.modules.dds.utils.FromInterfacePros;
import io.renren.modules.dds.utils.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ddsUserApiV1Service")
public class DdsUserApiV1ServiceImpl implements DdsUserApiV1Service {

	@Autowired
	private DdsUserServiceDao ddsUserServiceDao;
	@Autowired
	private PublicFactoryService publicFactoryService;

	@Override
	public void maintainUserInfo(String value) {
		DdsUserServiceEntity entity = new DdsUserServiceEntity();
		entity.setServiceType(DdsServiceTypes.maintainUserInfo_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	@Override
	public void chgStatus(String value) {
		DdsUserServiceEntity entity = new DdsUserServiceEntity();
		entity.setServiceType(DdsServiceTypes.chgStatus_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	@Override
	public void closeUser(String value) {
		DdsUserServiceEntity entity = new DdsUserServiceEntity();
		entity.setServiceType(DdsServiceTypes.closeUser_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	@Override
	public void addUserGroups(String value) {
		DdsUserServiceEntity entity = new DdsUserServiceEntity();
		entity.setServiceType(DdsServiceTypes.addUserGroups_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	@Override
	public void chgCredit(String value) {
		DdsUserServiceEntity entity = new DdsUserServiceEntity();
		entity.setServiceType(DdsServiceTypes.chgCredit_Type);
		entity.setJsonvalue(value);
		save(entity);
	}

	private void save(DdsUserServiceEntity entity) {
		String uuid = UUID.getUUID();
		entity.setId(uuid);
		entity.setFrominterfacepro(FromInterfacePros.BOSSBOV1);
		ddsUserServiceDao.save(entity);
		queue(entity);
	}

	private void queue(DdsUserServiceEntity entity) {
		new Thread(new Queue(entity)).start();
	}

	class Queue implements Runnable {
		DdsUserServiceEntity entity;

		public Queue(DdsUserServiceEntity entity) {
			this.entity = entity;
		}

		@Override
		public void run() {
			publicFactoryService.accpetRequest(entity.getId(), entity.getServiceType().toString(), "BOSS", entity.getFrominterfacepro());
		}
	}
}
