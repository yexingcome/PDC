package io.renren.modules.dds.entity.v1.request.chgCredit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "chgCredit")
public class ChgCredit {

	@XmlElement
	private String keyNO;
	@XmlElement
	private String serial;
	@XmlElement
	private String amount;
	@XmlElement
	private String userId;

	public String getKeyNO() {
		return keyNO;
	}

	public String getSerial() {
		return serial;
	}

	public String getAmount() {
		return amount;
	}

	public String getUserId() {
		return userId;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
