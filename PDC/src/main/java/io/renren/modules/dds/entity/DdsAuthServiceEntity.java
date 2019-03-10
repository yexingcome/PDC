package io.renren.modules.dds.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 关于授权类接口
 * 
 * @author cxq
 * @email kugiic@qq.com
 * @date 2018-12-12 17:54:36
 */
public class DdsAuthServiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	// 唯一标识，UUID
	private String id;
	// 原始json数据
	private String jsonvalue;
	// 业务类型； 6 维护用户商品授权接口 7 删除用户商品授权接口 8 刷新用户及授权接口
	private Integer serviceType;
	// 创建时间
	private Date createTime;
	// 来自那个平台版本
	private String frominterfacepro;

	/**
	 * 设置：唯一标识，UUID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取：唯一标识，UUID
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置：原始json、xml数据
	 */
	public void setJsonvalue(String value) {
		this.jsonvalue = value;
	}

	/**
	 * 获取：原始json、xml数据
	 */
	public String getJsonvalue() {
		return jsonvalue;
	}

	/**
	 * 设置：业务类型； 6 维护用户商品授权接口 7 删除用户商品授权接口 8 刷新用户及授权接口
	 */
	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	/**
	 * 获取：业务类型； 6 维护用户商品授权接口 7 删除用户商品授权接口 8 刷新用户及授权接口
	 */
	public Integer getServiceType() {
		return serviceType;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 来自那个平台版本
	 */
	public String getFrominterfacepro() {
		return frominterfacepro;
	}

	/**
	 * 来自那个平台版本
	 */
	public void setFrominterfacepro(String frominterfacepro) {
		this.frominterfacepro = frominterfacepro;
	}
}
