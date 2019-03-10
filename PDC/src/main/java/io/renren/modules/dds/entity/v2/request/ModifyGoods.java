package io.renren.modules.dds.entity.v2.request;

public class ModifyGoods {
	private String goodsId;
	private String goodsName;
	private String vodAreaId;
	private String goodsType;
	private String billCycle;
	private String goodsPrice;
	private String[] prodList;
	private String detailParams;

	public String getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public String getBillCycle() {
		return billCycle;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public String getDetailParams() {
		return detailParams;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public void setBillCycle(String billCycle) {
		this.billCycle = billCycle;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public void setDetailParams(String detailParams) {
		this.detailParams = detailParams;
	}

	public String[] getProdList() {
		return prodList;
	}

	public void setProdList(String[] prodList) {
		this.prodList = prodList;
	}

}
