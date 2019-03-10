package io.renren.modules.dds.utils;

/**
 * DdsServiceTypes
 * 
 * @author kugii 业务类型； 1 维护商品接口 2 删除商品接口 3 开户接口 4 修改用户状态接口 5 销户接口 6 维护用户商品授权接口 7
 *         删除用户商品授权接口 8 刷新用户及授权接口
 */

public interface DdsServiceTypes {
	/**
	 * 1 维护商品接口
	 */
	public final static int modifyGoods_Type = 1;
	/**
	 * 2 删除商品接口
	 */
	public final static int delGoods_Type = 2;
	/**
	 * 3 开户接口
	 */
	public final static int maintainUserInfo_Type = 3;
	/**
	 * 4 修改用户状态接口
	 */
	public final static int chgStatus_Type = 4;
	/**
	 * 5 销户接口
	 */
	public final static int closeUser_Type = 5;
	/**
	 * 6 维护用户商品授权接口
	 */
	public final static int authorization_Type = 6;
	/**
	 * 7 删除用户商品授权接口
	 */
	public final static int deleteAuthorization_Type = 7;
	/**
	 * 8 刷新用户及授权接口
	 */
	public final static int freshUserInfoAuth_Type = 8;
	/**
	 * 9 互动用户分组新增接口
	 */
	public final static int addUserGroups_Type = 9;
	/**
	 * 10 chgCredit接口 信息额度维护接口，没用
	 */
	public final static int chgCredit_Type = 10;
}
