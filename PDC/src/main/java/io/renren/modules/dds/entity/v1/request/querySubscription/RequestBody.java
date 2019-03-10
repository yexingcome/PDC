package io.renren.modules.dds.entity.v1.request.querySubscription;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:querySubscription")
	private QuerySubscription querySubscription = new QuerySubscription();

	public QuerySubscription getQuerySubscription() {
		return querySubscription;
	}

	public void setQuerySubscription(QuerySubscription querySubscription) {
		this.querySubscription = querySubscription;
	}

}
