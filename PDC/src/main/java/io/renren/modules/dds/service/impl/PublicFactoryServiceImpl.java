package io.renren.modules.dds.service.impl;

import io.renren.common.utils.RedisUtils;
import io.renren.modules.api.entity.HttpResult;
import io.renren.modules.api.service.HttpAPIService;
import io.renren.modules.dds.dao.DdsAuthServiceDao;
import io.renren.modules.dds.dao.DdsGoodsServiceDao;
import io.renren.modules.dds.dao.DdsPlatConfigDao;
import io.renren.modules.dds.dao.DdsPublicRecordDao;
import io.renren.modules.dds.dao.DdsRouteConfigDao;
import io.renren.modules.dds.dao.DdsUserServiceDao;
import io.renren.modules.dds.entity.DdsAuthServiceEntity;
import io.renren.modules.dds.entity.DdsGoodsServiceEntity;
import io.renren.modules.dds.entity.DdsPlatConfigEntity;
import io.renren.modules.dds.entity.DdsPublicRecordEntity;
import io.renren.modules.dds.entity.DdsRouteConfigEntity;
import io.renren.modules.dds.entity.DdsUserServiceEntity;
import io.renren.modules.dds.entity.v1.response.ResponseBaseObj;
import io.renren.modules.dds.entity.v1.response.addUserGroups.ResponseAddUserGroupsEntity;
import io.renren.modules.dds.entity.v1.response.authorization.ResponseAuthorizationEntity;
import io.renren.modules.dds.entity.v1.response.chgStatus.ResponseChgStatusEntity;
import io.renren.modules.dds.entity.v1.response.closeUser.ResponseCloseUserEntity;
import io.renren.modules.dds.entity.v1.response.delGoods.ResponseDelGoodsEntity;
import io.renren.modules.dds.entity.v1.response.deleteAuthorization.ResponseDeleteAuthorizationEntity;
import io.renren.modules.dds.entity.v1.response.maintainUserInfo.ResponseMaintainUserInfoEntity;
import io.renren.modules.dds.entity.v1.response.modifyGoodsPackage.ResponseModifyGoodsPackageEntity;
import io.renren.modules.dds.entity.v2.response.HttpResponse;
import io.renren.modules.dds.service.PlatChangeService;
import io.renren.modules.dds.service.PublicFactoryService;
import io.renren.modules.dds.utils.JaxbXmlUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicFactoryServiceImpl implements PublicFactoryService {

	ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1000);
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private DdsPlatConfigDao platConfigDao;

	@Autowired
	private PlatChangeService platChangeService;

	@Autowired
	private HttpAPIService httpAPIService;

	@Autowired
	private DdsRouteConfigDao routeConfigDao;

	@Autowired
	private DdsPublicRecordDao publicRecordDao;

	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	private DdsUserServiceDao userServiceDao;

	@Autowired
	private DdsAuthServiceDao authServiceDao;

	@Autowired
	private DdsGoodsServiceDao goodsServiceDao;

	private static Map map = null;
	static {
		map = new HashMap();

		/*1.商品维护；
		2.商品删除；
		3.开户；
		4.修改用户状态；
		5.销户；
		6.维护用户商品授权；
		7.删除用户商品授权；
		8.刷新用户及授权;
		9.互动用户分组
		*/
		map.put("1", "商品维护");
		map.put("2", "商品删除");
		map.put("3", "开户");
		map.put("4", "修改用户状态");
		map.put("5", "销户");
		map.put("6", "维护用户商品授权");
		map.put("7", "删除用户商品授权");
		map.put("8", "刷新用户及授权");
		map.put("9", "互动用户分组");
	}

	/**
	 * @see 调用请求，用来将原始工单转化为目标工单并发布
	 * @param businessid  待转化工单ID；Type 业务类型，sourcePlatFlag 数据来源平台标识,soruceInterfacepro 数据来源协议
	 * */
	@Override
	public void accpetRequest(String businessid, String type, String sourcePlatFlag, String soruceInterfacepro) {
		/**
		 * 0.根据type类型，判断是哪个来源接口；
		 * 1.根据businessid，type类型获取原始平台发送的工单内容
		 * 2.根据sourcePlatFlag soruceInterfacepro 进行判断能发往那些目标平台
		 * 3.根据目标平台的协议，将来源接口转化为目标接口格式；
		 * 4.转化完成后先放入数据库形成工单；
		 * 5.根据目标平台的最大接收阈值，控制发送请求速度，考虑到需要集群部署，
		 * 	  关于性能问题使用redis来记录发布数量；
		 */

		List<DdsPlatConfigEntity> targetPlats = platConfigDao.findPlatBySourceId(sourcePlatFlag, soruceInterfacepro);
		if (targetPlats != null && targetPlats.size() > 0) {
			String sourceContent = getSourceContent(businessid, type);//从数据库获取

			if (StringUtils.isNotBlank(sourceContent)) {

				for (DdsPlatConfigEntity ddsPlatConfigEntity : targetPlats) {
					String targetPlatFlag = ddsPlatConfigEntity.getIdentity();
					String targetInterfacePro = ddsPlatConfigEntity.getInterfacepro();//目标平台协议

					String targetContent = "";
					if (soruceInterfacepro.equalsIgnoreCase(targetInterfacePro)) {

						targetContent = sourceContent;//協議相同不需要轉化，直接傳

						//保存未发布工单至数据库
						if (StringUtils.isBlank(targetContent)) {
							logger.info("不支持源协议：{}到目标协议{}类型为《{}》的接口转化", soruceInterfacepro, targetInterfacePro,
									map.get(type));
							continue;
						}
						saveRecodrd(sourcePlatFlag, soruceInterfacepro, targetPlatFlag, targetInterfacePro, type, UUID
								.randomUUID().toString(), targetContent);

					} else if (soruceInterfacepro.equalsIgnoreCase("BOSS-BO-V1")
							&& targetInterfacePro.equalsIgnoreCase("BOSS-BO-V2")) {

						//协议转化，已知V1-V2
						String[] res = platChangeService.V1TOV2(sourceContent, type);//协议转化

						targetContent = res[0];
						type = res[1];

						//保存未发布工单至数据库
						if (StringUtils.isBlank(targetContent)) {
							logger.info("不支持源协议：{}到目标协议{}类型为《{}》的接口转化", soruceInterfacepro, targetInterfacePro,
									map.get(type));
							continue;
						}
						saveRecodrd(sourcePlatFlag, soruceInterfacepro, targetPlatFlag, targetInterfacePro, type, UUID
								.randomUUID().toString(), targetContent);

					} else if (soruceInterfacepro.equalsIgnoreCase("BOSS-BO-V2")
							&& targetInterfacePro.equalsIgnoreCase("BOSS-BO-V1")) {

						//协议转化，已知V2-V1
						Map map = platChangeService.V2TOV1(sourceContent, type);//协议转化

						//存在刷新接口时，有多个接口要调用
						for (Object key : map.keySet()) {
							targetContent = (String) map.get(key);
							if (StringUtils.isBlank(targetContent)) {
								logger.info("不支持源协议：{}到目标协议{}类型为《{}》的接口转化,接口内容{}", soruceInterfacepro,
										targetInterfacePro, key, targetContent);
								continue;
							}

							saveRecodrd(sourcePlatFlag, soruceInterfacepro, targetPlatFlag, targetInterfacePro,
									key.toString(), UUID.randomUUID().toString(), targetContent);

						}

					}
				}
			} else {
				logger.warn("businessid:{}, type:{}获取数据库中保存原始工单记录为空！", businessid, type);
			}
		} else {
			logger.warn("{}未路由到其他平台！", sourcePlatFlag);
		}
	}

	/**
	 * 针对页面管理的内容重新发布
	 * */
	@Override
	public void repulishRecord(String recordId) {
		DdsPublicRecordEntity entity = publicRecordDao.queryObject(recordId);

		DdsPlatConfigEntity targetPlat = platConfigDao.findTargetPlatByRouteId(entity.getRouteId());

		Long platRequestLength = redisUtils.Inc(targetPlat.getIdentity());
		if (platRequestLength <= Long.valueOf(targetPlat.getMaxaccept())) {
			try {
				fixedThreadPool.execute(new MyThread(targetPlat, entity, recordId, redisUtils, httpAPIService,
						publicRecordDao));
				Thread.sleep(1l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			redisUtils.Dec(targetPlat.getIdentity());
		}
	}

	/**
	 * 从数据库获取原始工单
	 * */
	private String getSourceContent(String businessid, String type) {
		String sourceContent = "";//从数据库获取

		/*1.商品维护；
		2.商品删除；
		3.开户；
		4.修改用户状态；
		5.销户；
		6.维护用户商品授权；
		7.删除用户商品授权；
		8.刷新用户及授权;
		9.互动用户分组
		*/
		if (type.equals("1") || type.equals("2")) {
			DdsGoodsServiceEntity entity = goodsServiceDao.queryObject(businessid);
			sourceContent = entity.getJsonvalue();
		} else if (type.equals("3") || type.equals("4") || type.equals("5") || type.equals("9")) {
			DdsUserServiceEntity entity = userServiceDao.queryObject(businessid);
			sourceContent = entity.getJsonvalue();
		} else if (type.equals("6") || type.equals("7") || type.equals("8")) {
			DdsAuthServiceEntity entity = authServiceDao.queryObject(businessid);
			sourceContent = entity.getJsonvalue();
		}

		return sourceContent;
	}

	/**
	 * 保存未发布工单至数据库
	 * */
	private void saveRecodrd(String sourcePlatFlag, String soruceInterfacepro, String targetPlatFlag,
			String targetInterfacepro, String type, String uuid, String targetContent) {
		DdsRouteConfigEntity routeConfigEntity = routeConfigDao.findRouteByPlatFlags(sourcePlatFlag,
				soruceInterfacepro, targetPlatFlag, targetInterfacepro);

		DdsPublicRecordEntity obj = new DdsPublicRecordEntity();
		obj.setBusinessType(type);
		obj.setId(uuid);
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		obj.setCreateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(date));
		obj.setMessage(targetContent);
		obj.setRouteId(routeConfigEntity.getId());
		obj.setStatus(-1);

		publicRecordDao.save(obj);
	}

}

class MyThread extends Thread {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final DdsPlatConfigEntity targetPlat;
	private final DdsPublicRecordEntity entity;
	private final String recordId;
	private final RedisUtils redisUtils;
	private final HttpAPIService httpAPIService;
	private final DdsPublicRecordDao publicRecordDao;

	public MyThread(DdsPlatConfigEntity targetPlat, DdsPublicRecordEntity entity, String recordId,
			RedisUtils redisUtils, HttpAPIService httpAPIService, DdsPublicRecordDao publicRecordDao) {
		this.targetPlat = targetPlat;
		this.entity = entity;
		this.recordId = recordId;
		this.redisUtils = redisUtils;
		this.httpAPIService = httpAPIService;
		this.publicRecordDao = publicRecordDao;
	}

	@Override
	public void run() {
		try {
			SendHttp(getTargetUrl(targetPlat.getServiceUrl(), entity.getBusinessType(), targetPlat.getInterfacepro()),
					entity.getMessage(), recordId, targetPlat.getInterfacepro(), entity.getBusinessType());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//发送完成就要恢复
			redisUtils.Dec(targetPlat.getIdentity());
		}
	}

	/**
	 * 组装原始请求发往目标平台的接口地址
	 * */
	private String getTargetUrl(String url, String type, String proversion) {
		/*1.商品维护；
		2.商品删除；
		3.开户；
		4.修改用户状态；
		5.销户；
		6.维护用户商品授权；
		7.删除用户商品授权；
		8.刷新用户及授权;
		9.互动用户分组
		 */

		if (("BOSS-BO-V1").equalsIgnoreCase(proversion)) {
			return url;
		} else if (("BOSS-BO-V2").equalsIgnoreCase(proversion)) {
			if (StringUtils.isNotBlank(url) && !url.endsWith("/")) {
				url += "/";
			}

			if (type.equals("1")) {
				url += "modifyGoods";

			} else if (type.equals("2")) {
				url += "delGoods";

			} else if (type.equals("3")) {
				url += "maintainUserInfo";

			} else if (type.equals("4")) {
				url += "chgStatus";

			} else if (type.equals("5")) {
				url += "closeUser";

			} else if (type.equals("6")) {
				url += "authorization";

			} else if (type.equals("7")) {
				url += "deleteAuthorization";

			} else if (type.equals("8")) {
				url += "freshUserInfoAuth";

			} else if (type.equals("9")) {
				url += "addUserGroups";
			}
		}

		return url;
	}

	/**
	 * 发布http请求，并跟新数据库成功或者失败
	 * */
	/**
	 * @param url
	 * @param targetContent
	 * @param uuid
	 */
	private void SendHttp(String url, String targetContent, String uuid, String targetInterfacepro, String businessType) {
		//这里进行发送

		DdsPublicRecordEntity replyObj = new DdsPublicRecordEntity();

		replyObj.setPublicTime(new Date());
		replyObj.setId(uuid);
		replyObj.setStatus(0);

		publicRecordDao.update(replyObj);

		int status = 1;
		String replayMess = "";

		try {
			logger.info("请求平台地址{},请求内容{}", url, targetContent);
			if (("BOSS-BO-V1").equalsIgnoreCase(targetInterfacepro)) {
				HttpResult response = httpAPIService.doPostXml(url, targetContent);

				if (response.getCode() == HttpStatus.SC_OK) {
					String body = response.getBody();
					logger.info("请求协议BOSS-BO-V1平台地址{}响应内容{}", url, body);
					if (StringUtils.isNotBlank(body)) {

						//返回对象转化成xml

						/**
						 * 1.商品维护；2.商品删除；3.开户；4.修改用户状态；5.销户；6.维护用户商品授权；
						 * 7.删除用户商品授权；8.刷新用户及授权;9.互动用户分组;
						 * 
						 * */
						ResponseBaseObj result = null;
						if (businessType.equalsIgnoreCase("1")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseModifyGoodsPackageEntity.class)
									.getBody().getResponseModifyGoodsPackage().getResponseObj();
						} else if (businessType.equalsIgnoreCase("2")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseDelGoodsEntity.class).getBody()
									.getResponseDelGoods().getResponseObj();
						} else if (businessType.equalsIgnoreCase("3")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseMaintainUserInfoEntity.class)
									.getBody().getResponseMaintainUserInfo().getResponseObj();
						} else if (businessType.equalsIgnoreCase("4")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseChgStatusEntity.class).getBody()
									.getResponseChgStatus().getResponseObj();
						} else if (businessType.equalsIgnoreCase("5")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseCloseUserEntity.class).getBody()
									.getResponseCloseUser().getResponseObj();
						} else if (businessType.equalsIgnoreCase("6")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseAuthorizationEntity.class).getBody()
									.getResponseAuthorization().getResponseObj();
						} else if (businessType.equalsIgnoreCase("7")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseDeleteAuthorizationEntity.class)
									.getBody().getResponseDeleteAuthorization().getResponseObj();
						} else if (businessType.equalsIgnoreCase("8")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseDelGoodsEntity.class).getBody()
									.getResponseDelGoods().getResponseObj();
						} else if (businessType.equalsIgnoreCase("9")) {
							result = JaxbXmlUtil.convertToJavaBean(body, ResponseAddUserGroupsEntity.class).getBody()
									.getResponseAddUserGroups().getResponseObj();
						}

						if (result.getReturnCode().equals("0000")) {
							status = 2;
							if (StringUtils.isNotBlank(result.getMessage())) {
								if (result.getMessage().contains("error")) {
									if (!result.getMessage().contains("error[]")) {
										status = 1;
									}
								}
							}
						}
						replayMess = body;
					}
				} else {
					logger.info("请求平台交互地址{}失败", url);
					replayMess = "请求平台交互地址失败,请验证地址是否正常";
				}
			} else if (("BOSS-BO-V2").equalsIgnoreCase(targetInterfacepro)) {
				HttpResult response = httpAPIService.doPostJson(url, targetContent);
				if (response.getCode() == HttpStatus.SC_OK) {
					String body = response.getBody();
					logger.info("请求协议BOSS-BO-V2平台地址{}响应内容{}", url, body);
					if (StringUtils.isNotBlank(body)) {
						HttpResponse resultBo = (HttpResponse) JSONObject.toBean(JSONObject.fromObject(body),
								HttpResponse.class);
						if (resultBo.getStatus().equals("0000")
								&& (resultBo.getError() == null || resultBo.getError().length <= 0)) {
							status = 2;
						}
						replayMess = body;
					}
				} else {
					logger.info("请求平台交互地址{}失败", url);
					replayMess = "请求平台交互地址失败,请验证地址是否正常";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			replayMess = "请求平台交互地址失败,请验证地址是否正常";
		} finally {

			replyObj = new DdsPublicRecordEntity();
			replyObj.setReplayTime(new Date());
			replyObj.setId(uuid);
			replyObj.setStatus(status);
			replyObj.setReplayMess(replayMess);

			publicRecordDao.update(replyObj);
		}
	}

}
