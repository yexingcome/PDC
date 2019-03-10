package io.renren.modules.dds.entity.v1.response.QueryUserGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class QueryUserGoodsResult {
	@XmlElement
	private String amount;
	@XmlElement
	private String keyNO;
	@XmlElement
	private String mac;
	@XmlElement
	private String phoneNumber;
	@XmlElement
	private String status;
	@XmlElement
	private String stbId;
	@XmlElement
	private String userId;
	@XmlElement
	private String userName;
	@XmlElement
	private String vodAreaId;
	@XmlElement
	private String vodAreaName;

	public String getAmount() {
		return amount;
	}

	public String getKeyNO() {
		return keyNO;
	}

	public String getMac() {
		return mac;
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

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
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

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setMac(String mac) {
		this.mac = mac;
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

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

	public void setVodAreaName(String vodAreaName) {
		this.vodAreaName = vodAreaName;
	}

}
