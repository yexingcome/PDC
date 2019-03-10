package io.renren.modules.dds.entity.v1.request.queryUserGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:queryUserGoods")
	private QueryUserGoods queryUserGoods = new QueryUserGoods();

	public QueryUserGoods getQueryUserGoods() {
		return queryUserGoods;
	}

	public void setQueryUserGoods(QueryUserGoods queryUserGoods) {
		this.queryUserGoods = queryUserGoods;
	}

}
