package io.renren.modules.dds.utils;

import io.renren.modules.dds.entity.v1.request.addUserGroups.AddUserGroups;
import io.renren.modules.dds.entity.v1.request.addUserGroups.AddUserGroupsEntity;
import io.renren.modules.dds.entity.v1.request.addUserGroups.AddUserGroupsInfo;
import io.renren.modules.dds.entity.v1.request.addUserGroups.RequestBody;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class JaxbXmlUtil {
	public static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * pojo转换成xml 默认编码UTF-8
	 *
	 * @param obj 待转化的对象
	 * @return xml格式字符串
	 * @throws Exception JAXBException
	 */
	public static String convertToXml(Object obj) throws Exception {
		return convertToXml(obj, DEFAULT_ENCODING);
	}

	/**
	 * pojo转换成xml
	 *
	 * @param obj 待转化的对象
	 * @param encoding 编码
	 * @return xml格式字符串
	 * @throws Exception JAXBException
	 */
	public static String convertToXml(Object obj, String encoding) throws Exception {
		String result = null;

		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		Marshaller marshaller = context.createMarshaller();
		// 指定是否使用换行和缩排对已编组 XML 数据进行格式化的属性名称。
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		result = writer.toString();

		return result;
	}

	/**
	 * xml转换成JavaBean
	 *
	 * @param xml xml格式字符串
	 * @param t 待转化的对象
	 * @return 转化后的对象
	 * @throws Exception JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T convertToJavaBean(String xml, Class<T> t) throws Exception {
		T obj = null;
		JAXBContext context = JAXBContext.newInstance(t);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		StringReader reader = new StringReader(xml);
		SAXParserFactory sax = SAXParserFactory.newInstance();
		sax.setNamespaceAware(false);
		XMLReader xmlReader = sax.newSAXParser().getXMLReader();
		Source source = new SAXSource(xmlReader, new InputSource(reader));

		obj = (T) unmarshaller.unmarshal(source);
		return obj;
	}

	public static void main(String[] args) {
		String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.cms.coship.com/\">   "
				+ "<soapenv:Header/>   "
				+ "<soapenv:Body>      "
				+ "<ser:addUserGroups>         "
				+ "<!--Optional:-->        "
				+ " <addUserGroups>            "
				+ "<!--Optional:-->            "
				+ "<description>?</description>          "
				+ " <!--Optional:-->            "
				+ "<groupNo>?</groupNo>            "
				+ "<!--Optional:-->            "
				+ "<userId>?</userId>         "
				+ "</addUserGroups>      " + "</ser:addUserGroups>   " + "</soapenv:Body>" + "</soapenv:Envelope>";
		try {
			AddUserGroupsEntity entity = convertToJavaBean(xml, AddUserGroupsEntity.class);
			System.out.println(entity.getBody().getAddUserGroups().getAddUserGroupsInfo().getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}

		AddUserGroupsEntity obj = new AddUserGroupsEntity();
		//		obj.setEapp("http://service.cms.coship.com/");
		//		obj.setSoapenv("http://schemas.xmlsoap.org/soap/envelope/");
		RequestBody body = new RequestBody();
		AddUserGroups addUserGroups = new AddUserGroups();
		AddUserGroupsInfo addUserGroupsInfo = new AddUserGroupsInfo();
		addUserGroupsInfo.setDescription("1");
		addUserGroups.setAddUserGroupsInfo(addUserGroupsInfo);
		body.setAddUserGroups(addUserGroups);
		obj.setBody(body);
		try {
			System.out.println(convertToXml(obj));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
