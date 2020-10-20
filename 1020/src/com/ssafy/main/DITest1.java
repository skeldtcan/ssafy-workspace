package com.ssafy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssafy.product.dto.Product;
import com.ssafy.product.service.ProductService;

public class DITest1 {

	public static void main(String[] args) {
		//spring Container 생성
		ApplicationContext container = new ClassPathXmlApplicationContext("com/ssafy/configuration/beans.xml");
		
		//getBean() : 객체 추출
		Product product = container.getBean("product", Product.class);
		
		ProductService service = container.getBean("productService", ProductService.class);
		service.insert(product);
		System.out.println("추가: " + product);
		System.out.println("조회: " + service.search(1));
	}

}
