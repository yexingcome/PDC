package io.renren.modules.dds.entity.v1.response.maintainUserInfo;

import io.renren.modules.dds.entity.v1.response.ResponseBaseObj;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ns2:maintainUserInfoResponse")
public class ResponseMaintainUserInfo {
	@XmlAttribute(name = "xmlns:ns2")
	private final String eapp = "http://service.cms.coship.com/";

	@XmlElement(required = true, name = "return")
	private ResponseBaseObj responseObj = new ResponseBaseObj();

	public String getEapp() {
		return eapp;
	}

	public ResponseBaseObj getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(ResponseBaseObj responseObj) {
		this.responseObj = responseObj;
	}

}
