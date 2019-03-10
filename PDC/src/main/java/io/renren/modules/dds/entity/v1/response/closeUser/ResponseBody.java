package io.renren.modules.dds.entity.v1.response.closeUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:closeUserResponse")
	private ResponseCloseUser responseCloseUser = new ResponseCloseUser();

	public ResponseCloseUser getResponseCloseUser() {
		return responseCloseUser;
	}

	public void setResponseCloseUser(ResponseCloseUser responseCloseUser) {
		this.responseCloseUser = responseCloseUser;
	}

}
