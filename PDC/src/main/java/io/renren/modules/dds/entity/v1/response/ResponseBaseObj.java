package io.renren.modules.dds.entity.v1.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "return")
public class ResponseBaseObj {

	@XmlElement
	private String message;
	@XmlElement
	private String returnCode;

	public String getMessage() {
		return message;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

}
