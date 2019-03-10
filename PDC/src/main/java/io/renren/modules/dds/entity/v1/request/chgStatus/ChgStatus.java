package io.renren.modules.dds.entity.v1.request.chgStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "chgCredit")
public class ChgStatus {

	@XmlElement
	private String userId;
	@XmlElement
	private String keyNO;
	@XmlElement
	private String branchNO;
	@XmlElement
	private String patchNO;
	@XmlElement
	private String vodAreaId;
	@XmlElement
	private String status;

	public String getUserId() {
		return userId;
	}

	public String getKeyNO() {
		return keyNO;
	}

	public String getBranchNO() {
		return branchNO;
	}

	public String getPatchNO() {
		return patchNO;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public String getStatus() {
		return status;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setBranchNO(String branchNO) {
		this.branchNO = branchNO;
	}

	public void setPatchNO(String patchNO) {
		this.patchNO = patchNO;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
