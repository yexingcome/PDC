package io.renren.modules.dds.entity.v2.request;

public class CloseUser {
	private String userId;
	private String keyNO;

	public String getUserId() {
		return userId;
	}

	public String getKeyNO() {
		return keyNO;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setKeyNO(String keyNO) {
		this.keyNO = keyNO;
	}

}
