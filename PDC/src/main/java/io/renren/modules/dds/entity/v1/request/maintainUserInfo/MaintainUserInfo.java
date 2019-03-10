package io.renren.modules.dds.entity.v1.request.maintainUserInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "userInfo")
public class MaintainUserInfo {

	@XmlElement
	private String amount;
	@XmlElement
	private String branchNO;
	@XmlElement
	private String branchName;
	@XmlElement
	private String description;
	@XmlElement
	private String feeKind;
	@XmlElement
	private String ip;
	@XmlElement
	private String keyNO;
	@XmlElement
	private String mac;
	@XmlElement
	private String panchName;
	@XmlElement
	private String patchNO;
	@XmlElement
	private String phoneNumber;
	@XmlElement
	private String status;
	@XmlElement
	private String stbId;
	@XmlElement
	private String userAddress;
	@XmlElement
	private String userId;
	@XmlElement
	private String userName;
	@XmlElement
	private String userPassword;
	@XmlElement
	private String userType;
	@XmlElement
	private String vodAreaId;
	@XmlElement
	private String vodAreaName;

	public String getAmount() {
		return amount;
	}

	public String getBranchNO() {
		return branchNO;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getDescription() {
		return description;
	}

	public String getFeeKind() {
		return feeKind;
	}

	public String getIp() {
		return ip;
	}

	public String getKeyNO() {
		return keyNO;
	}

	public String getMac() {
		return mac;
	}

	public String getPanchName() {
		return panchName;
	}

	public String getPatchNO() {
		return patchNO;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public String getStbId() {
		return stbId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserType() {
		return userType;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public String getVodAreaName() {
		return vodAreaName;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setBranchNO(String branchNO) {
		this.branchNO = branchNO;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public void setPanchName(String panchName) {
		this.panchName = panchName;
	}

	public void setPatchNO(String patchNO) {
		this.patchNO = patchNO;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStbId(String stbId) {
		this.stbId = stbId;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

	public void setVodAreaName(String vodAreaName) {
		this.vodAreaName = vodAreaName;
	}

}
