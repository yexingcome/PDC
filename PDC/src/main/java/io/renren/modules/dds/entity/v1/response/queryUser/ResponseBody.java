package io.renren.modules.dds.entity.v1.response.queryUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:queryUserResponse")
	private ResponseQueryUser responseQueryUser = new ResponseQueryUser();

	public ResponseQueryUser getResponseQueryUser() {
		return responseQueryUser;
	}

	public void setResponseQueryUser(ResponseQueryUser responseQueryUser) {
		this.responseQueryUser = responseQueryUser;
	}

}
