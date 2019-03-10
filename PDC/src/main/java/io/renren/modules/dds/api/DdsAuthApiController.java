package io.renren.modules.dds.api;

import io.renren.modules.dds.apiservice.DdsAuthApiService;
import io.renren.modules.dds.utils.BR;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于授权类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
@RestController
@RequestMapping("/ddsapi")
public class DdsAuthApiController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DdsAuthApiService ddsAuthApiService;

	/**
	 * 维护用户商品授权接口(authorization)
	 */
	@PostMapping("/authorization")
	public BR authorization(@RequestBody String value) {
		try {
			JSONObject fromObject = JSONObject.fromObject(value);
			JSONArray goodsList = fromObject.getJSONArray("goodsList");
			ddsAuthApiService.authorization(value);
			return BR.ok().put("success", goodsList).put("error", new String[] {});
		} catch (Exception e) {
			logger.error("维护用户商品授权接口 : ", e);
			return BR.error();
		}
	}

	/**
	 * 删除用户商品授权接口(deleteAuthorization)
	 */
	@PostMapping("/deleteAuthorization")
	public BR deleteAuthorization(@RequestBody String value) {
		try {
			JSONObject fromObject = JSONObject.fromObject(value);
			JSONArray goodsList = fromObject.getJSONArray("goodsList");
			ddsAuthApiService.deleteAuthorization(value);
			return BR.ok().put("success", goodsList).put("error", new String[] {});
		} catch (Exception e) {
			logger.error("删除用户商品授权接口 : ", e);
			return BR.error();
		}
	}

	/**
	 * 刷新用户及授权接口(freshUserInfoAuth)
	 */
	@PostMapping("/freshUserInfoAuth")
	public BR freshUserInfoAuth(@RequestBody String value) {
		try {
			JSONObject fromObject = JSONObject.fromObject(value);
			JSONArray goodsList = fromObject.getJSONArray("goodsList");
			ddsAuthApiService.freshUserInfoAuth(value);
			return BR.ok().put("success", goodsList).put("error", new String[] {});
		} catch (Exception e) {
			logger.error("刷新用户及授权接口 : ", e);
			return BR.error();
		}
	}

}
