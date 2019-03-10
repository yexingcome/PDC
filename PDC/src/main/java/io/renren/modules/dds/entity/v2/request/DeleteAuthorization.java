package io.renren.modules.dds.entity.v2.request;


public class DeleteAuthorization {
	private String userId;
	private String[] goodsList;

	public String getUserId() {
		return userId;
	}

	public String[] getGoodsList() {
		return goodsList;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setGoodsList(String[] goodsList) {
		this.goodsList = goodsList;
	}

}
