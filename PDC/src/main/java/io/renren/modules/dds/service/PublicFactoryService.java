package io.renren.modules.dds.service;

/**
 * 调用分发接口
 * */
public interface PublicFactoryService {
	/**
	 * @see 调用请求，用来将原始工单转化为目标工单并发布
	 * @param businessid  待转化工单ID；Type 业务类型，sourcePlatFlag 数据来源平台标识
	 * */
	public void accpetRequest(String businessid, String type, String sourcePlatFlag, String soruceInterfacepro);

	/**
	 * 针对页面管理的内容重新发布
	 * */
	public void repulishRecord(String recordId);
}
