package io.renren.modules.dds.entity.v1.request.chgStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "SOAP-ENV:Body")
public class RequestBody {
	@XmlElement(required = true, name = "ns1:chgStatus")
	private ChgStatus chgStatus;

	public ChgStatus getChgStatus() {
		return chgStatus;
	}

	public void setChgStatus(ChgStatus chgStatus) {
		this.chgStatus = chgStatus;
	}
}
