package io.renren.modules.dds.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2019-01-03 10:08:55
 */
public class DdsAreaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private String id;
	//名称
	private String name;
	//开始区域码
	private String startArea;
	//结束区域码
	private String endArea;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//父级区域ID
	private String parentId;
	//
	private String idsFullPath;
	//业务区标识
	private String branchNo;
	//业务区名称
	private String branchName;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：开始区域码
	 */
	public void setStartArea(String startArea) {
		this.startArea = startArea;
	}

	/**
	 * 获取：开始区域码
	 */
	public String getStartArea() {
		return startArea;
	}

	/**
	 * 设置：结束区域码
	 */
	public void setEndArea(String endArea) {
		this.endArea = endArea;
	}

	/**
	 * 获取：结束区域码
	 */
	public String getEndArea() {
		return endArea;
	}

	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 获取：
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * 设置：父级区域ID
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取：父级区域ID
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * 设置：
	 */
	public void setIdsFullPath(String idsFullPath) {
		this.idsFullPath = idsFullPath;
	}

	/**
	 * 获取：
	 */
	public String getIdsFullPath() {
		return idsFullPath;
	}

	/**
	 * 设置：业务区标识
	 */
	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	/**
	 * 获取：业务区标识
	 */
	public String getBranchNo() {
		return branchNo;
	}

	/**
	 * 设置：业务区名称
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * 获取：业务区名称
	 */
	public String getBranchName() {
		return branchName;
	}
}
