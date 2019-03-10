package io.renren.modules.dds.entity.v1.response.authorization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:authorizationResponse")
	private ResponseAuthorization responseAuthorization = new ResponseAuthorization();

	public ResponseAuthorization getResponseAuthorization() {
		return responseAuthorization;
	}

	public void setResponseAuthorization(ResponseAuthorization responseAuthorization) {
		this.responseAuthorization = responseAuthorization;
	}

}
