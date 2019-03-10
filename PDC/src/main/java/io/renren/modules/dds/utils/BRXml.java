package io.renren.modules.dds.utils;

import org.apache.http.HttpStatus;

/**
 * 返回BOSS数据 xml
 * @author kugii
 *
 */
public class BRXml{
	
	private String status;
	private String message;
	private String[] params;
	
	public BRXml() {
	}

	public static BRXml error() {
		return error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), "失败");
	}

	public static BRXml error(String msg) {
		return error(String.valueOf(HttpStatus.SC_INTERNAL_SERVER_ERROR), msg);
	}

	public static BRXml error(String status, String msg) {
		BRXml r = new BRXml();
		r.status = status;
		r.message = msg;
		return r;
	}
	
	public static BRXml ok() {
		BRXml r = new BRXml();
		r.status = "0000";
		r.message = "成功";
		return r;
	}

	public static BRXml ok(String msg) {
		BRXml r = ok();
		r.message = msg;
		return r;
	}
	
	public static BRXml ok(String status, String msg) {
		BRXml r = ok();
		r.status = status;
		r.message = msg;
		return r;
	}

	public static BRXml ok(String[] params) {
		BRXml r = ok();
		r.params = params;
		return r;
	}

	public String toXml(String format){
		if(params == null){
			return String.format(format, message, status);
		}
		Object[] ss = new String[params.length + 2];
		ss[0] = message;
		ss[1] = status;
		for (int i = 0; i < params.length; i++) {
			ss[i+2] = params[i];
		}
		return String.format(format, ss);
	}
	
}
