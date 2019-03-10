package io.renren.modules.dds.entity.v1.response.QueryUserGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:queryUserResponse")
	private ResponseQueryUserGoods responseQueryUser = new ResponseQueryUserGoods();

	public ResponseQueryUserGoods getResponseQueryUser() {
		return responseQueryUser;
	}

	public void setResponseQueryUser(ResponseQueryUserGoods responseQueryUser) {
		this.responseQueryUser = responseQueryUser;
	}

}
