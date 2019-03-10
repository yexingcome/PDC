package io.renren.modules.dds.entity.v1.request.addUserGroups;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "addUserGroups")
public class AddUserGroups {
	@XmlElement(required = true, name = "addUserGroups")
	private AddUserGroupsInfo addUserGroupsInfo = new AddUserGroupsInfo();

	public AddUserGroupsInfo getAddUserGroupsInfo() {
		return addUserGroupsInfo;
	}

	public void setAddUserGroupsInfo(AddUserGroupsInfo addUserGroupsInfo) {
		this.addUserGroupsInfo = addUserGroupsInfo;
	}

}
