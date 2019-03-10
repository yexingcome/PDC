package io.renren.modules.dds.entity.v1.request.querySubscription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "queryInfo")
public class QuerySubscriptionInfo {

	@XmlElement
	private String chargeType;
	@XmlElement
	private String endIndex;
	@XmlElement
	private String startIndex;
	@XmlElement
	private String subType;
	@XmlElement
	private String userId;

	public String getChargeType() {
		return chargeType;
	}

	public String getEndIndex() {
		return endIndex;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public String getSubType() {
		return subType;
	}

	public String getUserId() {
		return userId;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public void setEndIndex(String endIndex) {
		this.endIndex = endIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
