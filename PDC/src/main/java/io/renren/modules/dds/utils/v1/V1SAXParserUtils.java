package io.renren.modules.dds.utils.v1;

import io.renren.common.exception.RRException;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class V1SAXParserUtils {

	private static ThreadLocal<SAXParser> threadLocal;

	private static SAXParserFactory saxParserFactory;

	static {
		saxParserFactory = SAXParserFactory.newInstance();
		saxParserFactory.setNamespaceAware(true);
		threadLocal = new ThreadLocal<SAXParser>() {
			@Override
			protected SAXParser initialValue() {
				try {
					return saxParserFactory.newSAXParser();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				}
				return null;
			}
		};
	}

	public static void parser(String xmlString, DefaultHandler dh) throws Exception {
		try (ByteArrayInputStream in = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));) {
			SAXParser newSAXParser = threadLocal.get();
			newSAXParser.parse(in, dh);
		} catch (RRException e) {
			if (!"saxend".equals(e.getMsg())) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
