package io.renren.modules.sys.service;

import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysUserTokenEntity;

/**
 * 用户Token
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenService {

	SysUserTokenEntity queryByUserId(Long userId);

	void save(SysUserTokenEntity token);

	void update(SysUserTokenEntity token);

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	R createToken(long userId);

	/**
	 * 退出，修改token值
	 * @param userId  用户ID
	 */
	void logout(long userId);

}
