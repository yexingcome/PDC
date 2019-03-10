package io.renren.modules.dds.entity.v1.request.queryUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "queryUser")
public class QueryUser {

	@XmlElement
	private String keyNO;
	@XmlElement
	private String userId;

	public String getKeyNO() {
		return keyNO;
	}

	public String getUserId() {
		return userId;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
