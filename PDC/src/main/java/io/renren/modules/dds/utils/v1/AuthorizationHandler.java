package io.renren.modules.dds.utils.v1;

import io.renren.common.exception.RRException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AuthorizationHandler extends DefaultHandler {

	private boolean startTag;
	private String goodsId;
	private String currentLocalName;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		currentLocalName = localName;
		startTag = true;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(startTag && "goodsId".equals(currentLocalName)){
			goodsId = new String(ch, start, length);
			throw new  RRException("saxend"); //end
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		startTag = false;
	}

	public String getGoodsId() {
		return goodsId;
	}

}