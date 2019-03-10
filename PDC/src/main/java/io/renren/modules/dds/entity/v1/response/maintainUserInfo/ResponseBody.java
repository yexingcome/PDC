package io.renren.modules.dds.entity.v1.response.maintainUserInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "S:Body")
public class ResponseBody {

	@XmlElement(required = true, name = "ns2:maintainUserInfoResponse")
	private ResponseMaintainUserInfo responseMaintainUserInfo = new ResponseMaintainUserInfo();

	public ResponseMaintainUserInfo getResponseMaintainUserInfo() {
		return responseMaintainUserInfo;
	}

	public void setResponseMaintainUserInfo(ResponseMaintainUserInfo responseMaintainUserInfo) {
		this.responseMaintainUserInfo = responseMaintainUserInfo;
	}

}
