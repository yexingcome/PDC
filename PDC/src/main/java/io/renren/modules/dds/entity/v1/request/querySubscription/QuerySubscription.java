package io.renren.modules.dds.entity.v1.request.querySubscription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "querySubscription")
public class QuerySubscription {
	@XmlElement(required = true, name = "queryInfo")
	private QuerySubscriptionInfo queryInfo = new QuerySubscriptionInfo();

	public QuerySubscriptionInfo getQueryInfo() {
		return queryInfo;
	}

	public void setQueryInfo(QuerySubscriptionInfo queryInfo) {
		this.queryInfo = queryInfo;
	}

}
