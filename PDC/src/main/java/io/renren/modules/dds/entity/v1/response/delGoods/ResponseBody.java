package io.renren.modules.dds.entity.v1.response.delGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:delGoodsResponse")
	private ResponseDelGoods responseDelGoods = new ResponseDelGoods();

	public ResponseDelGoods getResponseDelGoods() {
		return responseDelGoods;
	}

	public void setResponseDelGoods(ResponseDelGoods responseDelGoods) {
		this.responseDelGoods = responseDelGoods;
	}

}
