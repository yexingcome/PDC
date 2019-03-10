package io.renren.modules.dds.service;

import java.util.Map;

/**
 * 平台接口转化总类
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018年12月13日17:32:03
 */
public interface PlatChangeService {

	/**
	 * BOSS-BO-V1转化成BOSS-BO-V2；
	 * 
	 * sourceContent  数据请求内容
	 * type           数据类型判断接口
	 * */
	public String[] V1TOV2(String sourceContent, String type);

	/**
	 * BOSS-BO-V2转化成BOSS-BO-V1；
	 * 
	 * sourceContent  数据请求内容
	 * type           数据类型判断接口
	 * */
	public Map V2TOV1(String sourceContent, String type);
}
