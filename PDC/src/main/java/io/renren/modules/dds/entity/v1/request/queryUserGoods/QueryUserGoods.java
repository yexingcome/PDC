package io.renren.modules.dds.entity.v1.request.queryUserGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "queryUserGoods")
public class QueryUserGoods {

	@XmlElement
	private String keyNO;
	@XmlElement
	private String endIndex;
	@XmlElement
	private String startIndex;
	@XmlElement
	private String vodAreaId;
	@XmlElement
	private String userId;

	public String getKeyNO() {
		return keyNO;
	}

	public String getEndIndex() {
		return endIndex;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public String getUserId() {
		return userId;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setEndIndex(String endIndex) {
		this.endIndex = endIndex;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
