package io.renren.modules.dds.api;

import io.renren.modules.dds.apiservice.DdsUserApiService;
import io.renren.modules.dds.utils.BR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 关于用户信息类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
@RestController
@RequestMapping("/ddsapi")
public class DdsUserApiController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DdsUserApiService ddsUserApiService;

	/**
	 *开户接口(maintainUserInfo)
	 */
	@PostMapping("/maintainUserInfo")
	public BR maintainUserInfo(@RequestBody String value) {
		try {
			ddsUserApiService.maintainUserInfo(value);
			return BR.ok();
		} catch (Exception e) {
			logger.error("开户接口: ", e);
			return BR.error();
		}
	}

	/**
	 * 修改用户状态接口(chgStatus)
	 */
	@PostMapping("/chgStatus")
	public BR chgStatus(@RequestBody String value) {
		try {
			ddsUserApiService.chgStatus(value);
			return BR.ok();
		} catch (Exception e) {
			logger.error("修改用户状态接口 : ", e);
			return BR.error();
		}
	}
	
	/**
	 * 销户接口(closeUser)
	 */
	@PostMapping("/closeUser")
	public BR closeUser(@RequestBody String value) {
		try {
			ddsUserApiService.closeUser(value);
			return BR.ok();
		} catch (Exception e) {
			logger.error("销户接口 : ", e);
			return BR.error();
		}
	}
	
	/**
	 *  互动用户分组新增接口(addUserGroups)
	 */
	@PostMapping("/addUserGroups")
	public BR addUserGroups(@RequestBody String value) {
		try {
			ddsUserApiService.addUserGroups(value);
			return BR.ok();
		} catch (Exception e) {
			logger.error("互动用户分组新增接口 : ", e);
			return BR.error();
		}
	}

}
