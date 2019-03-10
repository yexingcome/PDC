package io.renren.modules.dds.entity.v2.response;

import java.io.Serializable;

public class HttpResponse implements Serializable {

	private String status;
	private String[] success;
	private String[] error;
	private String message;

	public String[] getSuccess() {
		return success;
	}

	public String[] getError() {
		return error;
	}

	public void setSuccess(String[] success) {
		this.success = success;
	}

	public void setError(String[] error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
