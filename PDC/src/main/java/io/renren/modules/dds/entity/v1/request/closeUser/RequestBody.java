package io.renren.modules.dds.entity.v1.request.closeUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:closeUser")
	private CloseUser closeUser = new CloseUser();

	public CloseUser getCloseUser() {
		return closeUser;
	}

	public void setCloseUser(CloseUser closeUser) {
		this.closeUser = closeUser;
	}

}
