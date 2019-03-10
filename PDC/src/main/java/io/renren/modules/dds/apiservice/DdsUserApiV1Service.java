package io.renren.modules.dds.apiservice;


/**
 * 关于用户信息类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
public interface DdsUserApiV1Service {

	void maintainUserInfo(String value);

	void chgStatus(String value);

	void closeUser(String value);

	void addUserGroups(String value);

	void chgCredit(String value);

}
