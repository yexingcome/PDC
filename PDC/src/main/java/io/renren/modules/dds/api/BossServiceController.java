package io.renren.modules.dds.api;

import io.renren.modules.api.service.HttpAPIService;
import io.renren.modules.dds.apiservice.DdsAuthApiV1Service;
import io.renren.modules.dds.apiservice.DdsGoodsAipV1Service;
import io.renren.modules.dds.apiservice.DdsUserApiV1Service;
import io.renren.modules.dds.utils.BRXml;
import io.renren.modules.dds.utils.DDSConfigUtils;
import io.renren.modules.dds.utils.RfmUtils;
import io.renren.modules.dds.utils.v1.AuthorizationHandler;
import io.renren.modules.dds.utils.v1.V1SAXParserUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author kugii
 * 
 */
@RestController
@RequestMapping("/ddsapi")
public class BossServiceController {

	protected Logger logger = LoggerFactory.getLogger(BossServiceController.class);

	@Autowired
	private DdsAuthApiV1Service ddsAuthApiV1Service;
	@Autowired
	private DdsGoodsAipV1Service ddsGoodsAipV1Service;
	@Autowired
	private DdsUserApiV1Service ddsUserApiV1Service;
	@Autowired
	private HttpAPIService httpAPIService;
	@Autowired
	private DDSConfigUtils ddsConfigUtils;
	
	@PostMapping(value = "/BossService", consumes = "text/xml; charset=utf-8", produces = "text/xml; charset=UTF-8")
	public String BossService(@RequestBody String value) {
		logger.info("BossService 接口收到请求：" + value);
		String result = doBossService(value);
		logger.info("BossService 接口返回结果：" + result);
		return result;
	}

	public String doBossService(String value) {
		
		// 查询类接口(queryGoodsInfo、queryGoodsProducts、querySubscription、queryUser、queryUserGoods)
		if (value.lastIndexOf("queryGoodsInfo>") > 0 || value.lastIndexOf("queryGoodsProducts>") > 0 || value.lastIndexOf("querySubscription>") > 0
				|| value.lastIndexOf("queryUser>") > 0 || value.lastIndexOf("queryUserGoods>") > 0) {
			return queryAll(value);
		}
		// 商品维护接口(modifyGoodsPackage)
		if (value.lastIndexOf("modifyGoodsPackage>") > 0) {
			return modifyGoodsPackage(value);
		}
		// 商品删除接口(delGoods)
		if (value.lastIndexOf("delGoods>") > 0) {
			return delGoods(value);
		}
		// 开户接口(maintainUserInfo)
		if (value.lastIndexOf("maintainUserInfo>") > 0) {
			return maintainUserInfo(value);
		}
		// 修改用户状态接口(chgStatus)
		if (value.lastIndexOf("chgStatus>") > 0) {
			return chgStatus(value);
		}
		// 销户接口(closeUser)
		if (value.lastIndexOf("closeUser>") > 0) {
			return closeUser(value);
		}
		// 互动用户分组新增(addUserGroups)
		if (value.lastIndexOf("addUserGroups>") > 0) {
			return addUserGroups(value);
		}
		// 维护用户商品授权接口(authorization)
		if (value.lastIndexOf("authorization>") > 0) {
			return authorization(value);
		}
		// 删除用户商品授权接口(deleteAuthorization)
		if (value.lastIndexOf("deleteAuthorization>") > 0) {
			return deleteAuthorization(value);
		}
		// 刷新用户及授权接口(freshUserInfoAuth)
		if (value.lastIndexOf("freshUserInfoAuth>") > 0) {
			return freshUserInfoAuth(value);
		}
		// (chgCredit)
		if (value.lastIndexOf("chgCredit>") > 0) {
			return chgCredit(value);
		}
		logger.info("BossService 接口没有匹配到处理方法!!");
		return "";
	}
	

	private String queryAll(String value){
		try {
			return httpAPIService.doPostXml(ddsConfigUtils.getForBossQueryClassInterfaceUrl(), value).getBody();
		} catch (Exception e) {
			logger.debug("Boss 查询类接口 queryAll 方法：", e);
		}
		return null;
	}
	
	private String chgCredit(String value) {
		try {
			ddsUserApiV1Service.chgCredit(value);
			return BRXml.ok().toXml(RfmUtils.chgCredit_fm);
		} catch (Exception e) {
			logger.error("chgCredit : ", e);
			return BRXml.error().toXml(RfmUtils.chgCredit_fm);
		}
	}

	private String addUserGroups(String value) {
		try {
			ddsUserApiV1Service.addUserGroups(value);
			return BRXml.ok().toXml(RfmUtils.addUserGroups_fm);
		} catch (Exception e) {
			logger.error("互动用户分组新增 : ", e);
			return BRXml.error().toXml(RfmUtils.addUserGroups_fm);
		}
	}

	private String freshUserInfoAuth(String value) {
		logger.error("调用了 freshUserInfoAuth 接口：", value);
		return null;
	}

	private String deleteAuthorization(String value) {
		try {
			AuthorizationHandler dh = new AuthorizationHandler();
			V1SAXParserUtils.parser(value, dh);
			String goodsId = dh.getGoodsId();
			ddsAuthApiV1Service.deleteAuthorization(value);
			return BRXml.ok(String.format("success[%s],error[]", goodsId.replaceAll(";", ", "))).toXml(RfmUtils.deleteAuthorization_fm);
		} catch (Exception e) {
			logger.error("删除用户商品授权接口 : ", e);
			return BRXml.error().toXml(RfmUtils.deleteAuthorization_fm);
		}
	}

	private String authorization(String value) {
		try {
			AuthorizationHandler dh = new AuthorizationHandler();
			V1SAXParserUtils.parser(value, dh);
			String goodsId = dh.getGoodsId();
			ddsAuthApiV1Service.authorization(value);
			return BRXml.ok(String.format("success[%s],error[]", goodsId.replaceAll(";", ", "))).toXml(RfmUtils.authorization_fm);
		} catch (Exception e) {
			logger.error("维护用户商品授权接口 : ", e);
			return BRXml.error().toXml(RfmUtils.authorization_fm);
		}
	}

	private String closeUser(String value) {
		try {
			ddsUserApiV1Service.closeUser(value);
			return BRXml.ok().toXml(RfmUtils.closeUser_fm);
		} catch (Exception e) {
			logger.error("销户接口 : ", e);
			return BRXml.error().toXml(RfmUtils.closeUser_fm);
		}
	}

	private String delGoods(String value) {
		try {
			ddsGoodsAipV1Service.delGoods(value);
			return BRXml.ok().toXml(RfmUtils.delGoods_fm);
		} catch (Exception e) {
			logger.error("商品删除接口 : ", e);
			return BRXml.error().toXml(RfmUtils.delGoods_fm);
		}
	}

	private String modifyGoodsPackage(String value) {
		try {
			ddsGoodsAipV1Service.modifyGoods(value);
			return BRXml.ok().toXml(RfmUtils.modifyGoodsPackage_fm);
		} catch (Exception e) {
			logger.error("商品维护接口 : ", e);
			return BRXml.error().toXml(RfmUtils.modifyGoodsPackage_fm);
		}
	}

	private String maintainUserInfo(String value) {
		try {
			ddsUserApiV1Service.maintainUserInfo(value);
			return BRXml.ok().toXml(RfmUtils.maintainUserInfo_fm);
		} catch (Exception e) {
			logger.error("开户接口 : ", e);
			return BRXml.error().toXml(RfmUtils.maintainUserInfo_fm);
		}
	}

	private String chgStatus(String value) {
		try {
			ddsUserApiV1Service.chgStatus(value);
			return BRXml.ok().toXml(RfmUtils.chgStatus_fm);
		} catch (Exception e) {
			logger.error("修改用户状态接口 : ", e);
			return BRXml.error().toXml(RfmUtils.chgStatus_fm);
		}
	}

}
