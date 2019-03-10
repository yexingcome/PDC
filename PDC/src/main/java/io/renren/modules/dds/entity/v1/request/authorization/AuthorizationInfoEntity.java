package io.renren.modules.dds.entity.v1.request.authorization;

import io.renren.modules.dds.entity.v1.request.RequestBaseHeader;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "header", "body" })
@XmlRootElement(name = "SOAP-ENV:Envelope")
public class AuthorizationInfoEntity {

	@XmlAttribute(name = "xmlns:SOAP-ENV")
	private final String env = "http://schemas.xmlsoap.org/soap/envelope/";
	@XmlAttribute(name = "xmlns:SOAP-ENC")
	private final String enc = "http://schemas.xmlsoap.org/soap/encoding/";
	@XmlAttribute(name = "xmlns:xsi")
	private final String xsi = "http://www.w3.org/2001/XMLSchema-instance";
	@XmlAttribute(name = "xmlns:xsd")
	private final String xsd = "http://www.w3.org/2001/XMLSchema";
	@XmlAttribute(name = "xmlns:ns1")
	private final String ns1 = "http://service.cms.coship.com/";

	@XmlElement(required = true, name = "SOAP-ENV:Header")
	private RequestBaseHeader header = new RequestBaseHeader();

	@XmlElement(required = true, name = "SOAP-ENV:Body")
	private RequestBody body = new RequestBody();

	public RequestBaseHeader getHeader() {
		return header;
	}

	public RequestBody getBody() {
		return body;
	}

	public void setHeader(RequestBaseHeader header) {
		this.header = header;
	}

	public void setBody(RequestBody body) {
		this.body = body;
	}

}
