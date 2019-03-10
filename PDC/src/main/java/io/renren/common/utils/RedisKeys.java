package io.renren.common.utils;

/**
 * Redis所有Keys
 *
 * @author yexing
 * @email 745235790@qq.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

	public static String getSysConfigKey(String key) {
		return "sys:config:" + key;
	}
}
