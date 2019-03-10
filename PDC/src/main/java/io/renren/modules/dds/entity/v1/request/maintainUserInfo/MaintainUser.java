package io.renren.modules.dds.entity.v1.request.maintainUserInfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "userInfo")
public class MaintainUser {
	@XmlElement(required = true, name = "userInfo")
	private MaintainUserInfo userInfo = new MaintainUserInfo();

	public MaintainUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(MaintainUserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
