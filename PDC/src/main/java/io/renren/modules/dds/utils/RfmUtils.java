package io.renren.modules.dds.utils;

import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RfmUtils {

	protected Logger logger = LoggerFactory.getLogger(RfmUtils.class);
	
	public static String chgStatus_fm;
	public static String maintainUserInfo_fm;
	public static String modifyGoodsPackage_fm;
	public static String delGoods_fm;
	public static String closeUser_fm;
	public static String authorization_fm;
	public static String deleteAuthorization_fm;
	public static String addUserGroups_fm;
	public static String chgCredit_fm;
	
	@PostConstruct
	public void loadFm() throws Exception{
			try {
				chgStatus_fm = locaFm("ddsfm/chgStatus.fm");
				maintainUserInfo_fm = locaFm("ddsfm/maintainUserInfo.fm");
				modifyGoodsPackage_fm = locaFm("ddsfm/modifyGoodsPackage.fm");
				delGoods_fm = locaFm("ddsfm/delGoods.fm");
				closeUser_fm = locaFm("ddsfm/closeUser.fm");
				authorization_fm = locaFm("ddsfm/authorization.fm");
				deleteAuthorization_fm = locaFm("ddsfm/deleteAuthorization.fm");
				addUserGroups_fm = locaFm("ddsfm/addUserGroups.fm");
				chgCredit_fm = locaFm("ddsfm/chgCredit.fm");
			} catch (Exception e) {
				logger.error("加载模板文件失败，请检查目录下的文件 ddsfm/*.fm ", e);
				throw e;
			}
	}

	private static String locaFm(String filePath) throws Exception {
		try (InputStream in = RfmUtils.class.getClassLoader().getResourceAsStream(filePath)) {
			List<String> list = IOUtils.readLines(in, "UTF-8");
			StringBuilder sb = new StringBuilder();
			for (String str : list) {
				sb.append(str.trim());
			}
			return sb.toString();
		} catch (Exception e) {
			throw e;
		}
	}

}
