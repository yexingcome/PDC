package io.renren.modules.dds.entity.v1.request.queryUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:queryUser")
	private QueryUser queryUser = new QueryUser();

	public QueryUser getQueryUser() {
		return queryUser;
	}

	public void setQueryUser(QueryUser queryUser) {
		this.queryUser = queryUser;
	}

}
