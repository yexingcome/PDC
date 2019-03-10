package io.renren.modules.dds.entity.v1.request.queryGoodsInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:queryGoodsInfo")
	private QueryGoodsInfo queryGoodsInfo = new QueryGoodsInfo();

	public QueryGoodsInfo getQueryGoodsInfo() {
		return queryGoodsInfo;
	}

	public void setQueryGoodsInfo(QueryGoodsInfo queryGoodsInfo) {
		this.queryGoodsInfo = queryGoodsInfo;
	}

}
