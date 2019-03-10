package io.renren.modules.dds.entity.v1.response.delGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Envelope")
public class ResponseDelGoodsEntity {

	@XmlAttribute(name = "xmlns:S")
	private String eapp = "http://schemas.xmlsoap.org/soap/envelope/";

	@XmlElement(required = true, name = "S:Body")
	private ResponseBody body = new ResponseBody();

	public String getEapp() {
		return eapp;
	}

	public ResponseBody getBody() {
		return body;
	}

	public void setEapp(String eapp) {
		this.eapp = eapp;
	}

	public void setBody(ResponseBody body) {
		this.body = body;
	}

}
