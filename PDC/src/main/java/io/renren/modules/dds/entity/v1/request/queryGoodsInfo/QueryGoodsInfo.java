package io.renren.modules.dds.entity.v1.request.queryGoodsInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "queryGoodsInfo")
public class QueryGoodsInfo {

	@XmlElement
	private String goodsIdList;
	@XmlElement
	private String goodsName;

	public String getGoodsIdList() {
		return goodsIdList;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsIdList(String goodsIdList) {
		this.goodsIdList = goodsIdList;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

}
