package io.renren.modules.dds.entity.v1.request.authorization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "authorizationInfo")
public class AuthorizationInfo {

	@XmlElement
	private String availDateTime;
	@XmlElement
	private String beginTime;
	@NotBlank
	@XmlElement
	private String branchNO;
	@XmlElement
	private String endTime;
	@NotBlank
	@XmlElement
	private String goodsId;
	@XmlElement
	private String goodsName;
	@XmlElement
	private String goodsType;
	@XmlElement
	private String invalidationTime;
	@NotBlank
	@XmlElement
	private String keyNO;
	@NotBlank
	@XmlElement
	private String userId;
	@NotBlank
	@XmlElement
	private String vodAreaId;

	public String getAvailDateTime() {
		return availDateTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public String getBranchNO() {
		return branchNO;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public String getInvalidationTime() {
		return invalidationTime;
	}

	public String getKeyNO() {
		return keyNO;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public void setAvailDateTime(String availDateTime) {
		this.availDateTime = availDateTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public void setBranchNO(String branchNO) {
		this.branchNO = branchNO;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public void setInvalidationTime(String invalidationTime) {
		this.invalidationTime = invalidationTime;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

}
