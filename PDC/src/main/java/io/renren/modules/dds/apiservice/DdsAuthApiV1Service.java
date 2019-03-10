package io.renren.modules.dds.apiservice;


/**
 * 关于授权类接口api V1
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
public interface DdsAuthApiV1Service {

	void authorization(String value);

	void deleteAuthorization(String value);

	void freshUserInfoAuth(String value);

}
