package io.renren.modules.dds.service.impl;

import io.renren.modules.api.service.HttpAPIService;
import io.renren.modules.dds.dao.DdsAreaDao;
import io.renren.modules.dds.entity.DdsAreaEntity;
import io.renren.modules.dds.entity.v1.request.addUserGroups.AddUserGroups;
import io.renren.modules.dds.entity.v1.request.addUserGroups.AddUserGroupsEntity;
import io.renren.modules.dds.entity.v1.request.addUserGroups.AddUserGroupsInfo;
import io.renren.modules.dds.entity.v1.request.authorization.Authorization;
import io.renren.modules.dds.entity.v1.request.authorization.AuthorizationInfo;
import io.renren.modules.dds.entity.v1.request.authorization.AuthorizationInfoEntity;
import io.renren.modules.dds.entity.v1.request.chgStatus.ChgStatus;
import io.renren.modules.dds.entity.v1.request.chgStatus.ChgStatusEntity;
import io.renren.modules.dds.entity.v1.request.closeUser.CloseUser;
import io.renren.modules.dds.entity.v1.request.closeUser.CloseUserEntity;
import io.renren.modules.dds.entity.v1.request.delGoods.DelGoods;
import io.renren.modules.dds.entity.v1.request.delGoods.DelGoodsEntity;
import io.renren.modules.dds.entity.v1.request.deleteAuthorization.DeleteAuthorization;
import io.renren.modules.dds.entity.v1.request.deleteAuthorization.DeleteAuthorizationEntity;
import io.renren.modules.dds.entity.v1.request.maintainUserInfo.MaintainUser;
import io.renren.modules.dds.entity.v1.request.maintainUserInfo.MaintainUserInfo;
import io.renren.modules.dds.entity.v1.request.maintainUserInfo.MaintainUserInfoEntity;
import io.renren.modules.dds.entity.v1.request.modifyGoodsPackage.ModifyGoodsPackage;
import io.renren.modules.dds.entity.v1.request.modifyGoodsPackage.ModifyGoodsPackageEntity;
import io.renren.modules.dds.entity.v1.request.modifyGoodsPackage.ModifyGoodsPackageInfo;
import io.renren.modules.dds.entity.v1.request.modifyGoodsPackage.RequestBody;
import io.renren.modules.dds.entity.v1.request.queryUser.QueryUser;
import io.renren.modules.dds.entity.v1.request.queryUser.QueryUserEntity;
import io.renren.modules.dds.entity.v1.request.queryUserGoods.QueryUserGoods;
import io.renren.modules.dds.entity.v1.request.queryUserGoods.QueryUserGoodsEntity;
import io.renren.modules.dds.entity.v1.response.queryUser.QueryUserResult;
import io.renren.modules.dds.entity.v1.response.queryUser.ResponseQueryUserEntity;
import io.renren.modules.dds.entity.v2.request.FreshUserInfoAuth;
import io.renren.modules.dds.entity.v2.request.ModifyGoods;
import io.renren.modules.dds.service.PlatChangeService;
import io.renren.modules.dds.utils.DDSConfigUtils;
import io.renren.modules.dds.utils.JaxbXmlUtil;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("platChangeService")
public class PlatChangeServiceImpl implements PlatChangeService {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private HttpAPIService httpAPIService;

	@Autowired
	private DDSConfigUtils ddsConfigUtils;

	@Autowired
	private DdsAreaDao ddsAreaDao;

	@Override
	public String[] V1TOV2(String sourceContent, String type) {
		String res[] = new String[] { "", "" };

		try {
			if (type.equals("1")) {
				ModifyGoodsPackageInfo info = JaxbXmlUtil
						.convertToJavaBean(sourceContent, ModifyGoodsPackageEntity.class).getBody()
						.getModifyGoodsPackage().getInfo();

				ModifyGoods modifyGoods = new ModifyGoods();
				modifyGoods.setBillCycle(info.getBillCycle());
				modifyGoods.setDetailParams(info.getDetailParams());
				modifyGoods.setGoodsId(info.getGoodsId());
				modifyGoods.setGoodsName(info.getGoodsName());
				modifyGoods.setGoodsPrice(info.getGoodsPrice());

				if (StringUtils.isNotBlank(info.getGoodsType()) && info.getGoodsType().equals("2")) {
					modifyGoods.setGoodsType("0");
				} else {
					modifyGoods.setGoodsType(info.getGoodsType());
				}

				String productIds = info.getProductIds();

				if (StringUtils.isNotBlank(productIds)) {
					String[] prodList = productIds.split(";");
					modifyGoods.setProdList(prodList);
				}

				modifyGoods.setVodAreaId(info.getVodAreaId());

				res[0] = JSONObject.fromObject(modifyGoods).toString();
			} else if (type.equals("2")) {
				DelGoods delGoods = JaxbXmlUtil.convertToJavaBean(sourceContent, DelGoodsEntity.class).getBody()
						.getDelGoods();

				io.renren.modules.dds.entity.v2.request.DelGoods JsonDelGoods = new io.renren.modules.dds.entity.v2.request.DelGoods();
				JsonDelGoods.setGoodsId(delGoods.getGoodsId());
				JsonDelGoods.setVodAreaId(delGoods.getVodAreaId());

				res[0] = JSONObject.fromObject(JsonDelGoods).toString();
			} else if (type.equals("3")) {
				MaintainUserInfo maintainUserInfo = JaxbXmlUtil
						.convertToJavaBean(sourceContent, MaintainUserInfoEntity.class).getBody().getMaintainUser()
						.getUserInfo();
				io.renren.modules.dds.entity.v2.request.MaintainUserInfo JsonMaintainUserInfo = new io.renren.modules.dds.entity.v2.request.MaintainUserInfo();
				JsonMaintainUserInfo.setAmount(maintainUserInfo.getAmount());
				JsonMaintainUserInfo.setBranchName(maintainUserInfo.getBranchName());
				JsonMaintainUserInfo.setBranchNO(maintainUserInfo.getBranchNO());
				JsonMaintainUserInfo.setFeeKind(maintainUserInfo.getFeeKind());
				JsonMaintainUserInfo.setKeyNO(maintainUserInfo.getKeyNO());
				JsonMaintainUserInfo.setMac(maintainUserInfo.getMac());
				JsonMaintainUserInfo.setPatchName(maintainUserInfo.getPanchName());
				JsonMaintainUserInfo.setPatchNO(maintainUserInfo.getPatchNO());
				JsonMaintainUserInfo.setStbId(maintainUserInfo.getStbId());
				JsonMaintainUserInfo.setUserAddress(maintainUserInfo.getUserAddress());
				JsonMaintainUserInfo.setUserId(maintainUserInfo.getUserId());
				JsonMaintainUserInfo.setUserName(maintainUserInfo.getUserName());
				JsonMaintainUserInfo.setUserPassword(maintainUserInfo.getUserPassword());
				String userType = "1";
				if (!StringUtils.isBlank(maintainUserInfo.getUserType()) && maintainUserInfo.getUserType().equals("2")) {
					userType = "2";
				}
				JsonMaintainUserInfo.setUserType(userType);
				JsonMaintainUserInfo.setVodAreaId(maintainUserInfo.getVodAreaId());

				res[0] = JSONObject.fromObject(JsonMaintainUserInfo).toString();
			} else if (type.equals("4")) {

				ChgStatus chgStatus = JaxbXmlUtil.convertToJavaBean(sourceContent, ChgStatusEntity.class).getBody()
						.getChgStatus();

				if (chgStatus.getStatus().equalsIgnoreCase("3")) {
					io.renren.modules.dds.entity.v2.request.CloseUser jsonCloseUser = new io.renren.modules.dds.entity.v2.request.CloseUser();
					jsonCloseUser.setUserId(chgStatus.getUserId());

					res[0] = JSONObject.fromObject(jsonCloseUser).toString();

					type = "5";

					res[1] = type;
					return res;
				} else {
					io.renren.modules.dds.entity.v2.request.ChgStatus jsonChgStatus = new io.renren.modules.dds.entity.v2.request.ChgStatus();

					jsonChgStatus.setStatus(chgStatus.getStatus());
					jsonChgStatus.setUserId(chgStatus.getUserId());
					res[0] = JSONObject.fromObject(jsonChgStatus).toString();
				}

			} else if (type.equals("5")) {
				CloseUser closeUser = JaxbXmlUtil.convertToJavaBean(sourceContent, CloseUserEntity.class).getBody()
						.getCloseUser();

				io.renren.modules.dds.entity.v2.request.CloseUser jsonCloseUser = new io.renren.modules.dds.entity.v2.request.CloseUser();
				jsonCloseUser.setUserId(closeUser.getUserId());

				res[0] = JSONObject.fromObject(jsonCloseUser).toString();
			} else if (type.equals("6")) {
				AuthorizationInfo authorizationInfo = JaxbXmlUtil
						.convertToJavaBean(sourceContent, AuthorizationInfoEntity.class).getBody().getAuthorization()
						.getAuthorizationInfo();

				io.renren.modules.dds.entity.v2.request.Authorization authorization = new io.renren.modules.dds.entity.v2.request.Authorization();
				String goodsId = authorizationInfo.getGoodsId();
				if (StringUtils.isNotBlank(goodsId)) {
					String[] goodsList = goodsId.split(";");
					authorization.setGoodsList(goodsList);
				}
				authorization.setUserId(authorizationInfo.getUserId());

				res[0] = JSONObject.fromObject(authorization).toString();

			} else if (type.equals("7")) {

				DeleteAuthorization deleteAuthorization = JaxbXmlUtil
						.convertToJavaBean(sourceContent, DeleteAuthorizationEntity.class).getBody()
						.getDeleteAuthorization();
				io.renren.modules.dds.entity.v2.request.DeleteAuthorization jsonDeleteAuthorization = new io.renren.modules.dds.entity.v2.request.DeleteAuthorization();

				String goodIds = deleteAuthorization.getGoodsId();
				if (StringUtils.isNotBlank(goodIds)) {

					String[] goodsList = goodIds.split(";");

					jsonDeleteAuthorization.setGoodsList(goodsList);
				}
				jsonDeleteAuthorization.setUserId(deleteAuthorization.getUserId());

				res[0] = JSONObject.fromObject(jsonDeleteAuthorization).toString();
			} else if (type.equals("8")) {

				//				res[0] = sourceContent;
			} else if (type.equals("9")) {
				AddUserGroupsInfo addUserGroupsInfo = JaxbXmlUtil
						.convertToJavaBean(sourceContent, AddUserGroupsEntity.class).getBody().getAddUserGroups()
						.getAddUserGroupsInfo();

				io.renren.modules.dds.entity.v2.request.AddUserGroups addUserGroups = new io.renren.modules.dds.entity.v2.request.AddUserGroups();
				addUserGroups.setDescription(addUserGroupsInfo.getDescription());
				addUserGroups.setGroupNo(addUserGroupsInfo.getGroupNo());
				addUserGroups.setUserId(addUserGroupsInfo.getUserId());
				res[0] = JSONObject.fromObject(addUserGroups).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		res[1] = type;
		return res;
	}

	@Override
	public Map V2TOV1(String sourceContent, String type) {
		Map resMap = new HashMap<>();

		String res = "";

		try {
			if (type.equals("1")) {

				ModifyGoods modifyGoods = (ModifyGoods) JSONObject.toBean(JSONObject.fromObject(sourceContent),
						ModifyGoods.class);

				ModifyGoodsPackageEntity entity = new ModifyGoodsPackageEntity();
				RequestBody body = new RequestBody();
				ModifyGoodsPackage modifyGoodsPackage = new ModifyGoodsPackage();

				ModifyGoodsPackageInfo info = new ModifyGoodsPackageInfo();
				info.setBillCycle(modifyGoods.getBillCycle());
				info.setDetailParams(modifyGoods.getDetailParams());
				info.setGoodsId(modifyGoods.getGoodsId());
				info.setGoodsName(modifyGoods.getGoodsName());
				info.setGoodsPrice(modifyGoods.getGoodsPrice());
				info.setGoodsType(modifyGoods.getGoodsType());
				info.setGoodsStatus("3");
				info.setFeeKind("0");
				info.setBranchNO("GD");
				info.setBranchName("广东");

				String[] prodList = modifyGoods.getProdList();
				if (prodList != null && prodList.length > 0) {
					String prodIds = "";
					for (String prodid : prodList) {
						prodIds += prodid + ";";
					}
					info.setProductIds(prodIds.substring(0, prodIds.length() - 1));
				}

				info.setVodAreaId(modifyGoods.getVodAreaId());

				modifyGoodsPackage.setInfo(info);
				body.setModifyGoodsPackage(modifyGoodsPackage);
				entity.setBody(body);

				res = JaxbXmlUtil.convertToXml(entity);
				modifyGoodsPackage = null;
				body = null;
				entity = null;

			} else if (type.equals("2")) {

				DelGoods JsonDelGoods = (DelGoods) JSONObject.toBean(JSONObject.fromObject(sourceContent),
						DelGoods.class);

				DelGoodsEntity entity = new DelGoodsEntity();
				io.renren.modules.dds.entity.v1.request.delGoods.RequestBody body = new io.renren.modules.dds.entity.v1.request.delGoods.RequestBody();
				DelGoods delGoods = new DelGoods();
				delGoods.setGoodsId(JsonDelGoods.getGoodsId());
				delGoods.setVodAreaId(JsonDelGoods.getVodAreaId());

				body.setDelGoods(delGoods);
				entity.setBody(body);
				res = JaxbXmlUtil.convertToXml(entity);

				delGoods = null;
				body = null;
				entity = null;

			} else if (type.equals("3")) {
				io.renren.modules.dds.entity.v2.request.MaintainUserInfo JsonMaintainUserInfo = (io.renren.modules.dds.entity.v2.request.MaintainUserInfo) JSONObject
						.toBean(JSONObject.fromObject(sourceContent),
								io.renren.modules.dds.entity.v2.request.MaintainUserInfo.class);

				MaintainUserInfoEntity entity = new MaintainUserInfoEntity();
				io.renren.modules.dds.entity.v1.request.maintainUserInfo.RequestBody body = new io.renren.modules.dds.entity.v1.request.maintainUserInfo.RequestBody();
				MaintainUser maintainUser = new MaintainUser();

				MaintainUserInfo maintainUserInfo = new MaintainUserInfo();
				maintainUserInfo.setAmount(JsonMaintainUserInfo.getAmount());
				maintainUserInfo.setBranchName(JsonMaintainUserInfo.getBranchName());
				maintainUserInfo.setBranchNO(JsonMaintainUserInfo.getBranchNO());
				maintainUserInfo.setFeeKind(JsonMaintainUserInfo.getFeeKind());
				maintainUserInfo.setKeyNO(JsonMaintainUserInfo.getKeyNO());
				maintainUserInfo.setMac(JsonMaintainUserInfo.getMac());
				maintainUserInfo.setPanchName(JsonMaintainUserInfo.getPatchName());
				maintainUserInfo.setPatchNO(JsonMaintainUserInfo.getPatchNO());
				maintainUserInfo.setStbId(JsonMaintainUserInfo.getStbId());
				maintainUserInfo.setUserAddress(JsonMaintainUserInfo.getUserAddress());
				maintainUserInfo.setUserId(JsonMaintainUserInfo.getUserId());
				maintainUserInfo.setUserName(JsonMaintainUserInfo.getUserName());
				maintainUserInfo.setUserPassword(JsonMaintainUserInfo.getUserPassword());
				maintainUserInfo.setUserType(JsonMaintainUserInfo.getUserType());
				maintainUserInfo.setVodAreaId(JsonMaintainUserInfo.getVodAreaId());

				maintainUser.setUserInfo(maintainUserInfo);
				body.setMaintainUser(maintainUser);
				entity.setBody(body);
				res = JaxbXmlUtil.convertToXml(entity);

				maintainUserInfo = null;
				maintainUser = null;
				body = null;
				entity = null;
			} else if (type.equals("4")) {
				ChgStatus jsonChgStatus = (ChgStatus) JSONObject.toBean(JSONObject.fromObject(sourceContent),
						ChgStatus.class);

				ChgStatusEntity entity = new ChgStatusEntity();
				io.renren.modules.dds.entity.v1.request.chgStatus.RequestBody body = new io.renren.modules.dds.entity.v1.request.chgStatus.RequestBody();

				ChgStatus chgStatus = new ChgStatus();
				chgStatus.setStatus(jsonChgStatus.getStatus());
				chgStatus.setUserId(jsonChgStatus.getUserId());

				QueryUser queryUser = new QueryUser();
				queryUser.setUserId(jsonChgStatus.getUserId());
				QueryUserResult queryUserResult = QurayUser(queryUser);

				DdsAreaEntity ddsAreaEntity = getddsAreaEntity(queryUserResult.getVodAreaId());

				if (ddsAreaEntity != null && StringUtils.isNotBlank(ddsAreaEntity.getBranchNo())) {
					chgStatus.setBranchNO(ddsAreaEntity.getBranchNo());
					chgStatus.setKeyNO(queryUserResult.getKeyNO());
					chgStatus.setVodAreaId(queryUserResult.getVodAreaId());
				}

				body.setChgStatus(chgStatus);
				entity.setBody(body);
				res = JaxbXmlUtil.convertToXml(entity);

				chgStatus = null;
				body = null;
				entity = null;

			} else if (type.equals("5")) {

				CloseUser jsonCloseUser = (CloseUser) JSONObject.toBean(JSONObject.fromObject(sourceContent),
						CloseUser.class);

				ChgStatusEntity entity = new ChgStatusEntity();
				io.renren.modules.dds.entity.v1.request.chgStatus.RequestBody body = new io.renren.modules.dds.entity.v1.request.chgStatus.RequestBody();

				QueryUser queryUser = new QueryUser();
				queryUser.setUserId(jsonCloseUser.getUserId());
				QueryUserResult queryUserResult = QurayUser(queryUser);

				DdsAreaEntity ddsAreaEntity = getddsAreaEntity(queryUserResult.getVodAreaId());

				ChgStatus chgStatus = new ChgStatus();
				chgStatus.setStatus("3");
				chgStatus.setUserId(jsonCloseUser.getUserId());

				if (ddsAreaEntity != null && StringUtils.isNotBlank(ddsAreaEntity.getBranchNo())) {
					chgStatus.setBranchNO(ddsAreaEntity.getBranchNo());
					chgStatus.setKeyNO(queryUserResult.getKeyNO());
					chgStatus.setVodAreaId(queryUserResult.getVodAreaId());
				}

				body.setChgStatus(chgStatus);
				entity.setBody(body);
				res = JaxbXmlUtil.convertToXml(entity);

				resMap.put("4", res);

				return resMap;

			} else if (type.equals("6")) {

				io.renren.modules.dds.entity.v2.request.Authorization authorization = (io.renren.modules.dds.entity.v2.request.Authorization) JSONObject
						.toBean(JSONObject.fromObject(sourceContent),
								io.renren.modules.dds.entity.v2.request.Authorization.class);

				QueryUser queryUser = new QueryUser();
				queryUser.setUserId(authorization.getUserId());
				QueryUserResult queryUserResult = QurayUser(queryUser);

				AuthorizationInfoEntity entity = new AuthorizationInfoEntity();
				io.renren.modules.dds.entity.v1.request.authorization.RequestBody body = new io.renren.modules.dds.entity.v1.request.authorization.RequestBody();
				Authorization auth = new Authorization();

				AuthorizationInfo authorizationInfo = new AuthorizationInfo();

				String[] goodsList = authorization.getGoodsList();
				if (goodsList != null && goodsList.length > 0) {
					String goodsId = "";
					for (String goodId : goodsList) {
						goodsId += goodId + ";";
					}
					authorizationInfo.setGoodsId(goodsId.substring(0, goodsId.length() - 1));
				}

				DdsAreaEntity ddsAreaEntity = getddsAreaEntity(queryUserResult.getVodAreaId());

				if (ddsAreaEntity != null && StringUtils.isNotBlank(ddsAreaEntity.getBranchNo())) {

					authorizationInfo.setUserId(authorization.getUserId());
					authorizationInfo.setVodAreaId(queryUserResult.getVodAreaId());
					authorizationInfo.setBranchNO(ddsAreaEntity.getBranchNo());
					authorizationInfo.setKeyNO(queryUserResult.getKeyNO());

					auth.setAuthorizationInfo(authorizationInfo);
					body.setAuthorization(auth);
					entity.setBody(body);
					res = JaxbXmlUtil.convertToXml(entity);
				} else {
					logger.error("根据区域id：{}未找到对应的业务区！", queryUserResult.getVodAreaId());
				}

				authorizationInfo = null;
				auth = null;
				body = null;
				entity = null;

			} else if (type.equals("7")) {
				io.renren.modules.dds.entity.v2.request.DeleteAuthorization jsonDeleteAuthorization = (io.renren.modules.dds.entity.v2.request.DeleteAuthorization) JSONObject
						.toBean(JSONObject.fromObject(sourceContent),
								io.renren.modules.dds.entity.v2.request.DeleteAuthorization.class);

				DeleteAuthorizationEntity entity = new DeleteAuthorizationEntity();
				io.renren.modules.dds.entity.v1.request.deleteAuthorization.RequestBody body = new io.renren.modules.dds.entity.v1.request.deleteAuthorization.RequestBody();

				DeleteAuthorization deleteAuthorization = new DeleteAuthorization();

				String[] goodsList = jsonDeleteAuthorization.getGoodsList();
				if (goodsList != null && goodsList.length > 0) {
					String goodsId = "";
					for (String goodId : goodsList) {
						goodsId += goodId + ";";
					}
					deleteAuthorization.setGoodsId(goodsId.substring(0, goodsId.length() - 1));
				}

				deleteAuthorization.setUserId(jsonDeleteAuthorization.getUserId());

				body.setDeleteAuthorization(deleteAuthorization);
				entity.setBody(body);
				res = JaxbXmlUtil.convertToXml(entity);

				deleteAuthorization = null;
				body = null;
				entity = null;
			} else if (type.equals("8")) {

				//				res = sourceContent;
				//v2转v1时，将刷新用户授权，转化成开户接口、删除用户商品授权、维护用户商品授权
				FreshUserInfoAuth freshUserInfoAuth = (FreshUserInfoAuth) JSONObject.toBean(
						JSONObject.fromObject(sourceContent), FreshUserInfoAuth.class);

				//开户接口
				MaintainUserInfoEntity maintainUserInfoEntity = new MaintainUserInfoEntity();
				io.renren.modules.dds.entity.v1.request.maintainUserInfo.RequestBody maintainUserInfobody = new io.renren.modules.dds.entity.v1.request.maintainUserInfo.RequestBody();
				MaintainUser maintainUser = new MaintainUser();

				MaintainUserInfo maintainUserInfo = new MaintainUserInfo();
				maintainUserInfo.setAmount(freshUserInfoAuth.getAmount());
				maintainUserInfo.setBranchName(freshUserInfoAuth.getBranchName());
				maintainUserInfo.setBranchNO(freshUserInfoAuth.getBranchNO());
				maintainUserInfo.setFeeKind(freshUserInfoAuth.getFeeKind());
				maintainUserInfo.setKeyNO(freshUserInfoAuth.getKeyNO());
				maintainUserInfo.setMac(freshUserInfoAuth.getMac());
				maintainUserInfo.setPanchName(freshUserInfoAuth.getPatchName());
				maintainUserInfo.setPatchNO(freshUserInfoAuth.getPatchNO());
				maintainUserInfo.setStbId(freshUserInfoAuth.getStbId());
				maintainUserInfo.setUserAddress(freshUserInfoAuth.getUserAddress());
				maintainUserInfo.setUserId(freshUserInfoAuth.getUserId());
				maintainUserInfo.setUserName(freshUserInfoAuth.getUserName());
				maintainUserInfo.setUserPassword(freshUserInfoAuth.getUserPassword());
				maintainUserInfo.setUserType(freshUserInfoAuth.getUserType());
				maintainUserInfo.setVodAreaId(freshUserInfoAuth.getVodAreaId());

				maintainUser.setUserInfo(maintainUserInfo);
				maintainUserInfobody.setMaintainUser(maintainUser);
				maintainUserInfoEntity.setBody(maintainUserInfobody);
				res = JaxbXmlUtil.convertToXml(maintainUserInfoEntity);

				maintainUserInfo = null;
				maintainUser = null;
				maintainUserInfobody = null;
				maintainUserInfoEntity = null;

				resMap.put("3", res);

				res = "";

				//删除用户商品授权
				DeleteAuthorizationEntity deleteAuthorizationEntity = new DeleteAuthorizationEntity();
				io.renren.modules.dds.entity.v1.request.deleteAuthorization.RequestBody deleteAuthorizationbody = new io.renren.modules.dds.entity.v1.request.deleteAuthorization.RequestBody();

				DeleteAuthorization deleteAuthorization = new DeleteAuthorization();

				String[] goodsList = freshUserInfoAuth.getGoodsList();
				if (goodsList != null && goodsList.length > 0) {
					String goodsId = "";
					for (String goodId : goodsList) {
						goodsId += goodId + ";";
					}
					deleteAuthorization.setGoodsId(goodsId.substring(0, goodsId.length() - 1));
				}

				deleteAuthorization.setUserId(freshUserInfoAuth.getUserId());

				deleteAuthorizationbody.setDeleteAuthorization(deleteAuthorization);
				deleteAuthorizationEntity.setBody(deleteAuthorizationbody);
				res = JaxbXmlUtil.convertToXml(deleteAuthorizationEntity);

				deleteAuthorization = null;
				deleteAuthorizationbody = null;
				deleteAuthorizationEntity = null;

				resMap.put("7", res);
				res = "";

				//维护用户商品授权

				AuthorizationInfoEntity authorizationInfoEntity = new AuthorizationInfoEntity();
				io.renren.modules.dds.entity.v1.request.authorization.RequestBody authorizationInfobody = new io.renren.modules.dds.entity.v1.request.authorization.RequestBody();
				Authorization auth = new Authorization();

				AuthorizationInfo authorizationInfo = new AuthorizationInfo();
				String[] authorizationInfogoodsList = freshUserInfoAuth.getGoodsList();
				if (authorizationInfogoodsList != null && authorizationInfogoodsList.length > 0) {
					String goodsId = "";
					for (String goodId : authorizationInfogoodsList) {
						goodsId += goodId + ";";
					}
					authorizationInfo.setGoodsId(goodsId.substring(0, goodsId.length() - 1));
				}
				authorizationInfo.setUserId(freshUserInfoAuth.getUserId());

				DdsAreaEntity ddsAreaEntity = getddsAreaEntity(freshUserInfoAuth.getVodAreaId());

				if (ddsAreaEntity != null && StringUtils.isNotBlank(ddsAreaEntity.getBranchNo())) {

					authorizationInfo.setVodAreaId(freshUserInfoAuth.getVodAreaId());
					authorizationInfo.setKeyNO(freshUserInfoAuth.getKeyNO());
					authorizationInfo.setBranchNO(ddsAreaEntity.getBranchNo());

					auth.setAuthorizationInfo(authorizationInfo);
					authorizationInfobody.setAuthorization(auth);
					authorizationInfoEntity.setBody(authorizationInfobody);
					res = JaxbXmlUtil.convertToXml(authorizationInfoEntity);

					authorizationInfo = null;
					auth = null;
					authorizationInfobody = null;
					authorizationInfoEntity = null;
					resMap.put("6", res);
				} else {
					logger.error("根据区域id：{}未找到对应的业务区！", freshUserInfoAuth.getVodAreaId());
				}

				res = "";

				return resMap;
			} else if (type.equals("9")) {
				io.renren.modules.dds.entity.v2.request.AddUserGroups addUserGroups = (io.renren.modules.dds.entity.v2.request.AddUserGroups) JSONObject
						.toBean(JSONObject.fromObject(sourceContent),
								io.renren.modules.dds.entity.v2.request.AddUserGroups.class);

				AddUserGroupsEntity entity = new AddUserGroupsEntity();
				io.renren.modules.dds.entity.v1.request.addUserGroups.RequestBody body = new io.renren.modules.dds.entity.v1.request.addUserGroups.RequestBody();
				AddUserGroups userGroups = new AddUserGroups();

				AddUserGroupsInfo addUserGroupsInfo = new AddUserGroupsInfo();
				addUserGroupsInfo.setDescription(addUserGroups.getDescription());
				addUserGroupsInfo.setGroupNo(addUserGroups.getGroupNo());
				addUserGroupsInfo.setUserId(addUserGroups.getUserId());

				userGroups.setAddUserGroupsInfo(addUserGroupsInfo);
				body.setAddUserGroups(userGroups);
				entity.setBody(body);

				res = JaxbXmlUtil.convertToXml(entity);

				addUserGroupsInfo = null;
				userGroups = null;
				body = null;
				entity = null;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resMap.put(type, res);
		return resMap;
	}

	private QueryUserResult QurayUser(QueryUser queryUser) {
		QueryUserEntity entity = new QueryUserEntity();
		io.renren.modules.dds.entity.v1.request.queryUser.RequestBody body = new io.renren.modules.dds.entity.v1.request.queryUser.RequestBody();
		body.setQueryUser(queryUser);
		entity.setBody(body);

		QueryUserResult queryUserResult = null;
		String value = "";
		try {
			value = JaxbXmlUtil.convertToXml(entity);
			String responseres = httpAPIService.doPostXml(ddsConfigUtils.getForBossQueryClassInterfaceUrl(), value)
					.getBody();

			queryUserResult = JaxbXmlUtil.convertToJavaBean(responseres, ResponseQueryUserEntity.class).getBody()
					.getResponseQueryUser().getResponseObj().getQueryUserResult();
		} catch (Exception e) {
			logger.error("处理查询用户失败！，请求平台{}，请求参数{}", ddsConfigUtils.getForBossQueryClassInterfaceUrl(), value);
			e.printStackTrace();
		} finally {
			body = null;
			entity = null;
		}

		return queryUserResult;
	}

	private QueryUserResult QueryUserGoods(QueryUserGoods queryUserGoods) {
		QueryUserGoodsEntity entity = new QueryUserGoodsEntity();
		io.renren.modules.dds.entity.v1.request.queryUserGoods.RequestBody body = new io.renren.modules.dds.entity.v1.request.queryUserGoods.RequestBody();
		body.setQueryUserGoods(queryUserGoods);
		entity.setBody(body);

		QueryUserResult queryUserResult = null;
		String value = "";
		try {
			value = JaxbXmlUtil.convertToXml(entity);
			String responseres = httpAPIService.doPostXml(ddsConfigUtils.getForBossQueryClassInterfaceUrl(), value)
					.getBody();

			queryUserResult = JaxbXmlUtil.convertToJavaBean(responseres, ResponseQueryUserEntity.class).getBody()
					.getResponseQueryUser().getResponseObj().getQueryUserResult();
		} catch (Exception e) {
			logger.error("处理查询用户商品失败！，请求平台{}，请求参数{}", ddsConfigUtils.getForBossQueryClassInterfaceUrl(), value);
			e.printStackTrace();
		} finally {
			body = null;
			entity = null;
		}

		return queryUserResult;
	}

	@Cacheable(value = "ddsarea", key = "areaCode +#p0")
	public DdsAreaEntity getddsAreaEntity(String area) {
		return ddsAreaDao.findByAreacode(area);
	}
}
