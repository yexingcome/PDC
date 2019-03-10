package io.renren.modules.dds.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 平台配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 12:00:28
 */
public class DdsPlatConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//平台标识
	private String identity;
	//平台名称
	private String name;
	//平台服务地址
	private String serviceUrl;

	private String interfacepro;
	//内容分发阈值
	private String maxaccept;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：平台标识
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * 获取：平台标识
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * 设置：平台名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：平台名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：接口协议
	 */
	public void setInterfacepro(String interfacepro) {
		this.interfacepro = interfacepro;
	}

	/**
	 * 获取：接口协议
	 */
	public String getInterfacepro() {
		return interfacepro;
	}

	/**
	 * 设置：内容分发阈值
	 */
	public void setMaxaccept(String maxaccept) {
		this.maxaccept = maxaccept;
	}

	/**
	 * 获取：内容分发阈值
	 */
	public String getMaxaccept() {
		return maxaccept;
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
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
