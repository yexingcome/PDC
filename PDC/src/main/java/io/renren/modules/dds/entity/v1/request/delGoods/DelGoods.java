package io.renren.modules.dds.entity.v1.request.delGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "delGoods")
public class DelGoods {

	@XmlElement
	private String detailParams;
	@XmlElement
	private String goodsId;
	@XmlElement
	private String branchNO;
	@XmlElement
	private String vodAreaId;

	public String getDetailParams() {
		return detailParams;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public String getBranchNO() {
		return branchNO;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public void setDetailParams(String detailParams) {
		this.detailParams = detailParams;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setBranchNO(String branchNO) {
		this.branchNO = branchNO;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

}
