package io.renren.modules.dds.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 路由配置
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
public class DdsRouteConfigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//源平台
	private Integer sourcePlatId;
	//源平台名称
	private String sourcePlatName;
	//
	private Integer targetPlatId;
	//目标平台名称
	private String targetPlatName;

	private String soruceInterfacepro;

	private String targetInterfacepro;

	//1.启用；0，禁用
	private Integer status;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	public String getSoruceInterfacepro() {
		return soruceInterfacepro;
	}

	public void setSoruceInterfacepro(String soruceInterfacepro) {
		this.soruceInterfacepro = soruceInterfacepro;
	}

	public String getTargetInterfacepro() {
		return targetInterfacepro;
	}

	public void setTargetInterfacepro(String targetInterfacepro) {
		this.targetInterfacepro = targetInterfacepro;
	}

	public String getSourcePlatName() {
		return sourcePlatName;
	}

	public String getTargetPlatName() {
		return targetPlatName;
	}

	public void setSourcePlatName(String sourcePlatName) {
		this.sourcePlatName = sourcePlatName;
	}

	public void setTargetPlatName(String targetPlatName) {
		this.targetPlatName = targetPlatName;
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
	 * 设置：源平台
	 */
	public void setSourcePlatId(Integer sourcePlatId) {
		this.sourcePlatId = sourcePlatId;
	}

	/**
	 * 获取：源平台
	 */
	public Integer getSourcePlatId() {
		return sourcePlatId;
	}

	/**
	 * 设置：
	 */
	public void setTargetPlatId(Integer targetPlatId) {
		this.targetPlatId = targetPlatId;
	}

	/**
	 * 获取：
	 */
	public Integer getTargetPlatId() {
		return targetPlatId;
	}

	/**
	 * 设置：1.启用；
	0，禁用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：1.启用；
	0，禁用
	 */
	public Integer getStatus() {
		return status;
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
