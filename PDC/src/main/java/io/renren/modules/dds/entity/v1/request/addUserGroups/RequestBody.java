package io.renren.modules.dds.entity.v1.request.addUserGroups;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:addUserGroups")
	private AddUserGroups addUserGroups = new AddUserGroups();

	public AddUserGroups getAddUserGroups() {
		return addUserGroups;
	}

	public void setAddUserGroups(AddUserGroups addUserGroups) {
		this.addUserGroups = addUserGroups;
	}

}
