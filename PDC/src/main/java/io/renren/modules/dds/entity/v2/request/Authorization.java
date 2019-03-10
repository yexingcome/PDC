package io.renren.modules.dds.entity.v2.request;

public class Authorization {
	private String userId;
	private String[] goodsList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String[] getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(String[] goodsList) {
		this.goodsList = goodsList;
	}

}
