package io.renren.modules.dds.entity.v1.request.modifyGoodsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:modifyGoodsPackage")
	private ModifyGoodsPackage modifyGoodsPackage = new ModifyGoodsPackage();

	public ModifyGoodsPackage getModifyGoodsPackage() {
		return modifyGoodsPackage;
	}

	public void setModifyGoodsPackage(ModifyGoodsPackage modifyGoodsPackage) {
		this.modifyGoodsPackage = modifyGoodsPackage;
	}

}
