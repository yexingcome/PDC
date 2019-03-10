package io.renren.modules.dds.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;

/**
 * 返回BOSS数据
 * @author kugii
 *
 */
public class BR extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 1L;

	public BR() {
	}

	public static BR error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "执行失败");
	}

	public static BR error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}

	public static BR error(int status, String msg) {
		BR r = new BR();
		r.put("status", status);
		r.put("message", msg);
		return r;
	}

	public static BR ok(String msg) {
		BR r = new BR();
		r.put("status", "0000");
		r.put("message", msg);
		return r;
	}

	public static BR ok(Map<String, Object> map) {
		BR r = new BR();
		r.put("status", "0000");
		r.put("message", "执行成功");
		r.putAll(map);
		return r;
	}

	public static BR ok() {
		BR r = new BR();
		r.put("status", "0000");
		r.put("message", "执行成功");
		return r;
	}

	@Override
	public BR put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
