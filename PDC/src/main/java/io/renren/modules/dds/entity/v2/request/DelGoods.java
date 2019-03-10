package io.renren.modules.dds.entity.v2.request;

public class DelGoods {
	private String goodsId;
	private String goodsName;
	private String vodAreaId;

	public String getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getVodAreaId() {
		return vodAreaId;
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

}
