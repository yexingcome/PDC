package io.renren.modules.dds.entity.v1.response.QueryUserGoods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//根元素
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "return")
public class ResponseQueryUserGoodsBaseObj {

	@XmlElement
	private String message;
	@XmlElement
	private String returnCode;
	@XmlElement
	private int recordCount;
	@XmlElement
	private int pageCount;
	@XmlElement
	private int currentPage;

	@XmlElement(required = true, name = "user")
	private QueryUserGoodsResult queryUserResult = new QueryUserGoodsResult();

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

	public QueryUserGoodsResult getQueryUserResult() {
		return queryUserResult;
	}

	public void setQueryUserResult(QueryUserGoodsResult queryUserResult) {
		this.queryUserResult = queryUserResult;
	}

}
