package io.renren.modules.dds.entity.v1.response.queryUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ns2:queryUserResponse")
public class ResponseQueryUser {
	@XmlAttribute(name = "xmlns:ns2")
	private final String eapp = "http://service.cms.coship.com/";

	@XmlElement(required = true, name = "return")
	private ResponseQueryUserBaseObj responseObj = new ResponseQueryUserBaseObj();

	public ResponseQueryUserBaseObj getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(ResponseQueryUserBaseObj responseObj) {
		this.responseObj = responseObj;
	}
}
