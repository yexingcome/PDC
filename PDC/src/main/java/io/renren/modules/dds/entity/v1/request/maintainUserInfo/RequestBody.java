package io.renren.modules.dds.entity.v1.request.maintainUserInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:maintainUserInfo")
	private MaintainUser maintainUser = new MaintainUser();

	public MaintainUser getMaintainUser() {
		return maintainUser;
	}

	public void setMaintainUser(MaintainUser maintainUser) {
		this.maintainUser = maintainUser;
	}

}
