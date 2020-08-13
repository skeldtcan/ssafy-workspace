package com.ssafy.java.day0813.hw;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface INewsDAO {
	List<News> getNewsList();
	
	News search(int index);

}
