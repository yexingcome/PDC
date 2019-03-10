package io.renren.modules.dds.entity.v2.request;

public class QuerySubscription {
	private String userId;
	private String startIndex;
	private String endIndex;

	public String getUserId() {
		return userId;
	}

	public String getStartIndex() {
		return startIndex;
	}

	public String getEndIndex() {
		return endIndex;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setStartIndex(String startIndex) {
		this.startIndex = startIndex;
	}

	public void setEndIndex(String endIndex) {
		this.endIndex = endIndex;
	}

}
