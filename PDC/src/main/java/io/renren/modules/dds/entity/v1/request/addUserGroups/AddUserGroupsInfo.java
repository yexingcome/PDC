package io.renren.modules.dds.entity.v1.request.addUserGroups;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "addUserGroups")
public class AddUserGroupsInfo {

	@XmlElement
	private String description;
	@XmlElement
	private String groupNo;
	@XmlElement
	private String userId;

	public String getDescription() {
		return description;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
