package io.renren.modules.dds.utils;

public class UUID {
	public static String getUUID() {
		String uuid = java.util.UUID.randomUUID().toString();
		//去掉“-”符号 
		return uuid.replaceAll("-", "");
	}

}
