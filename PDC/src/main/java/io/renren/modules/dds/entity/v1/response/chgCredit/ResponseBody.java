package io.renren.modules.dds.entity.v1.response.chgCredit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:chgCreditResponse")
	private ResponseChgCredit responseChgCredit = new ResponseChgCredit();

	public ResponseChgCredit getResponseChgCredit() {
		return responseChgCredit;
	}

	public void setResponseChgCredit(ResponseChgCredit responseChgCredit) {
		this.responseChgCredit = responseChgCredit;
	}
}
