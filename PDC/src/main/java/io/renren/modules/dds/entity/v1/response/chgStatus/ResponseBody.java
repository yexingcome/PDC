package io.renren.modules.dds.entity.v1.response.chgStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:chgStatusResponse")
	private ResponseChgStatus responseChgStatus = new ResponseChgStatus();

	public ResponseChgStatus getResponseChgStatus() {
		return responseChgStatus;
	}

	public void setResponseChgStatus(ResponseChgStatus responseChgStatus) {
		this.responseChgStatus = responseChgStatus;
	}
}
