package io.renren.modules.dds.entity.v1.request.chgCredit;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:chgCredit")
	private ChgCredit chgCredit;

	public ChgCredit getChgCredit() {
		return chgCredit;
	}

	public void setChgCredit(ChgCredit chgCredit) {
		this.chgCredit = chgCredit;
	}

}
