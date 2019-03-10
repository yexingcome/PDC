package io.renren.modules.dds.entity.v1.response.QueryUserGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ns2:queryUserResponse")
public class ResponseQueryUserGoods {
	@XmlAttribute(name = "xmlns:ns2")
	private final String eapp = "http://service.cms.coship.com/";

	@XmlElement(required = true, name = "return")
	private ResponseQueryUserGoodsBaseObj responseObj = new ResponseQueryUserGoodsBaseObj();

	public ResponseQueryUserGoodsBaseObj getResponseObj() {
		return responseObj;
	}

	public void setResponseObj(ResponseQueryUserGoodsBaseObj responseObj) {
		this.responseObj = responseObj;
	}
}
