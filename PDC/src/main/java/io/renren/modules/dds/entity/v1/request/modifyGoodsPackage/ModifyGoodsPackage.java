package io.renren.modules.dds.entity.v1.request.modifyGoodsPackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "info")
public class ModifyGoodsPackage {

	@XmlElement(required = true, name = "info")
	private ModifyGoodsPackageInfo info = new ModifyGoodsPackageInfo();

	public ModifyGoodsPackageInfo getInfo() {
		return info;
	}

	public void setInfo(ModifyGoodsPackageInfo info) {
		this.info = info;
	}

}
