package io.renren.modules.dds.entity.v1.request.modifyGoodsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "info")
public class ModifyGoodsPackageInfo {

	@XmlElement
	private String branchNO;
	@XmlElement
	private String branchName;
	@XmlElement
	private String detailParams;
	@XmlElement
	private String feeKind;
	@XmlElement
	private String goodsId;
	@XmlElement
	private String goodsName;
	@XmlElement
	private String goodsPrice;
	@XmlElement
	private String goodsStatus;
	@XmlElement
	private String goodsType;
	@XmlElement
	private String limitResetType;
	@XmlElement
	private String limitType;
	@XmlElement
	private String limitValue;
	@XmlElement
	private String productIds;
	@XmlElement
	private String vodAreaId;
	@XmlElement
	private String billCycle;

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public String getBranchNO() {
		return branchNO;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getDetailParams() {
		return detailParams;
	}

	public String getFeeKind() {
		return feeKind;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public String getGoodsStatus() {
		return goodsStatus;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public String getLimitResetType() {
		return limitResetType;
	}

	public String getLimitType() {
		return limitType;
	}

	public String getLimitValue() {
		return limitValue;
	}

	public String getVodAreaId() {
		return vodAreaId;
	}

	public String getBillCycle() {
		return billCycle;
	}

	public void setBranchNO(String branchNO) {
		this.branchNO = branchNO;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public void setDetailParams(String detailParams) {
		this.detailParams = detailParams;
	}

	public void setFeeKind(String feeKind) {
		this.feeKind = feeKind;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public void setLimitResetType(String limitResetType) {
		this.limitResetType = limitResetType;
	}

	public void setLimitType(String limitType) {
		this.limitType = limitType;
	}

	public void setLimitValue(String limitValue) {
		this.limitValue = limitValue;
	}

	public void setVodAreaId(String vodAreaId) {
		this.vodAreaId = vodAreaId;
	}

	public void setBillCycle(String billCycle) {
		this.billCycle = billCycle;
	}

}
