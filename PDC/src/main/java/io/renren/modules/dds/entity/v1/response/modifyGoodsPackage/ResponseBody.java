package io.renren.modules.dds.entity.v1.response.modifyGoodsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:modifyGoodsPackageResponse")
	private ResponseModifyGoodsPackage responseModifyGoodsPackage = new ResponseModifyGoodsPackage();

	public ResponseModifyGoodsPackage getResponseModifyGoodsPackage() {
		return responseModifyGoodsPackage;
	}

	public void setResponseModifyGoodsPackage(ResponseModifyGoodsPackage responseModifyGoodsPackage) {
		this.responseModifyGoodsPackage = responseModifyGoodsPackage;
	}

}
