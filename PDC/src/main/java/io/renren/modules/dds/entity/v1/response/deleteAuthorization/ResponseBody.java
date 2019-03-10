package io.renren.modules.dds.entity.v1.response.deleteAuthorization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:deleteAuthorizationResponse")
	private ResponseDeleteAuthorization responseDeleteAuthorization = new ResponseDeleteAuthorization();

	public ResponseDeleteAuthorization getResponseDeleteAuthorization() {
		return responseDeleteAuthorization;
	}

	public void setResponseDeleteAuthorization(ResponseDeleteAuthorization responseDeleteAuthorization) {
		this.responseDeleteAuthorization = responseDeleteAuthorization;
	}

}
