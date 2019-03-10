package io.renren.modules.dds.entity.v1.response.addUserGroups;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:addUserGroupsResponse")
	private ResponseAddUserGroups responseAddUserGroups = new ResponseAddUserGroups();

	public ResponseAddUserGroups getResponseAddUserGroups() {
		return responseAddUserGroups;
	}

	public void setResponseAddUserGroups(ResponseAddUserGroups responseAddUserGroups) {
		this.responseAddUserGroups = responseAddUserGroups;
	}

}
