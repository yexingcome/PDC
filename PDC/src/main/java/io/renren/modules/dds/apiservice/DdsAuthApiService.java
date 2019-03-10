package io.renren.modules.dds.apiservice;


/**
 * 关于授权类接口api
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
public interface DdsAuthApiService {

	void authorization(String value);

	void deleteAuthorization(String value);

	void freshUserInfoAuth(String value);

}
