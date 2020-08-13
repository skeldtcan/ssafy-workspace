package com.ssafy.java.day0813.hw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class NewsDAOSAXImpl extends DefaultHandler implements INewsDAO {
	List<News> list = new ArrayList<News>();
	News n;
	String currentStr;
	
	
	

	public NewsDAOSAXImpl(String url) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(url, this);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<News> getNewsList(){
		return list;
	}

	@Override
	public News search(int index) {
		return list.get(index);
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		if(qName.equals("item")) {
			n = new News();
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		currentStr = String.valueOf(ch, start, length);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(n != null) {
			if(qName.equals("title")) {
				n.setTitle(currentStr);
			} else if (qName.equals("link")) {
				n.setLink(currentStr);
			} else if (qName.equals("description")) {
				n.setDesc(currentStr);
			} else if (qName.equals("item")) {
				list.add(n);
				n = null;
			}
		}
	}

}

