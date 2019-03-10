package io.renren.modules.dds.entity.v2.request;

public class AddUserGroups {
	private String userId;
	private String groupNo;
	private String description;

	public String getUserId() {
		return userId;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public String getDescription() {
		return description;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
