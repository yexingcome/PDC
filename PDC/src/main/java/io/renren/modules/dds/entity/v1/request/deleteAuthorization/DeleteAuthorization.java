package io.renren.modules.dds.entity.v1.request.deleteAuthorization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "deleteAuthorization")
public class DeleteAuthorization {

	@XmlElement
	private String userId;
	@XmlElement
	private String keyNO;
	@XmlElement
	private String goodsId;
	@XmlElement
	private String branchNO;
	@XmlElement
	private String vodAreaId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getKeyNO() {
		return keyNO;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public String getBranchNO() {
		return branchNO;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setBranchNO(String branchNO) {
		this.branchNO = branchNO;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

}
