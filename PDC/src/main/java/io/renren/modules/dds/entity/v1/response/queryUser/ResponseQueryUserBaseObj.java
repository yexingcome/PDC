package io.renren.modules.dds.entity.v1.response.queryUser;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "return")
public class ResponseQueryUserBaseObj {

	@XmlElement
	private String message;
	@XmlElement
	private String returnCode;

	@XmlElement(required = true, name = "user")
	private QueryUserResult queryUserResult = new QueryUserResult();

	public String getMessage() {
		return message;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public QueryUserResult getQueryUserResult() {
		return queryUserResult;
	}

	public void setQueryUserResult(QueryUserResult queryUserResult) {
		this.queryUserResult = queryUserResult;
	}

}
