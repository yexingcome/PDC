package io.renren.modules.dds.entity.v1.request.delGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:delGoods")
	private DelGoods delGoods;

	public DelGoods getDelGoods() {
		return delGoods;
	}

	public void setDelGoods(DelGoods delGoods) {
		this.delGoods = delGoods;
	}

}
