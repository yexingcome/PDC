package io.renren.modules.dds.entity.v1.request.queryGoodsProducts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:queryGoodsProducts")
	private QueryGoodsProducts queryGoodsProducts = new QueryGoodsProducts();

	public QueryGoodsProducts getQueryGoodsProducts() {
		return queryGoodsProducts;
	}

	public void setQueryGoodsProducts(QueryGoodsProducts queryGoodsProducts) {
		this.queryGoodsProducts = queryGoodsProducts;
	}

}
