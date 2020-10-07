package com.ssafy.java.day0813.hw;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class NewsMain {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		INewsDAO dao = new NewsDAOSAXImpl("http://rss.etnews.com/Section902.xml");
		List<News> n = dao.getNewsList();
		System.out.println("## 모든 뉴스 출력 ##");
		for(int i=0; i<n.size(); i++) {
			
			System.out.println(i+"번째: " +n.get(i).getTitle());
		}
		System.out.println();
		
		System.out.println("## index번째 뉴스 가져오기 ##");
		System.out.println(dao.search(29));

		
	}
	
}
