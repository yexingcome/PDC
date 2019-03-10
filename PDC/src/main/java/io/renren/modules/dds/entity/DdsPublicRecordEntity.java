package io.renren.modules.dds.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 发布记录
 * 
 * @author yexing
 * @email 745235790@qq.com
 * @date 2018-12-12 17:06:30
 */
public class DdsPublicRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//工单号
	private String id;
	//
	private Integer routeId;
	//1.商品维护；
	//2.商品删除；
	//3.开户；
	//4.修改用户状态；
	//5.销户；
	//6.维护用户商品授权；
	//7.删除用户商品授权；
	//8.刷新用户及授权
	private String businessType;
	//工单详细
	private String message;
	//-1：未发布，0:发布中，1：发布失败；2：发布成功
	private Integer status;
	//创建时间
	private String createTime;
	//发布时间
	private Date publicTime;
	//回复时间
	private Date replayTime;

	private String sourceName;

	private String targetName;

	private String replayMess;

	public String getReplayMess() {
		return replayMess;
	}

	public void setReplayMess(String replayMess) {
		this.replayMess = replayMess;
	}

	/**
	 * 设置：工单号
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取：工单号
	 */
	public String getId() {
		return id;
	}

	/**
	 * 设置：
	 */
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}

	/**
	 * 获取：
	 */
	public Integer getRouteId() {
		return routeId;
	}

	/**
	 * 设置：1.商品维护；
	2.商品删除；
	3.开户；
	4.修改用户状态；
	5.销户；
	6.维护用户商品授权；
	7.删除用户商品授权；
	8.刷新用户及授权
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 获取：1.商品维护；
	2.商品删除；
	3.开户；
	4.修改用户状态；
	5.销户；
	6.维护用户商品授权；
	7.删除用户商品授权；
	8.刷新用户及授权
	 */
	public String getBusinessType() {
		return businessType;
	}

	/**
	 * 设置：工单详细
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 获取：工单详细
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置：-1：未发布，0:发布中，1：发布失败；2：发布成功
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：-1：未发布，0:发布中，1：发布失败；2：发布成功
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：发布时间
	 */
	public void setPublicTime(Date publicTime) {
		this.publicTime = publicTime;
	}

	/**
	 * 获取：发布时间
	 */
	public Date getPublicTime() {
		return publicTime;
	}

	/**
	 * 设置：回复时间
	 */
	public void setReplayTime(Date replayTime) {
		this.replayTime = replayTime;
	}

	/**
	 * 获取：回复时间
	 */
	public Date getReplayTime() {
		return replayTime;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getTargetName() {
		return targetName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

}
