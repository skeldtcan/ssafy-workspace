package com.ssafy.java.day0820.hw;

import java.sql.SQLException;

public class ProductTest {

	public static void main(String[] args) {
		DBUtil util = DBUtil.getUtil();
		try {
			util.getConnection();
			
			ProductDAO dao = ProductDAO.getDAO();
			
			System.out.println("## 제품 추가 ##");
			Product product = new Product(123, "냉장고", 1000, 3);
			check(dao.insertProduct(product));
			Product product2 = new Product(234, "컴퓨터", 500, 6);
			check(dao.insertProduct(product2));
			Product product3 = new Product(345, "에어컨", 2000, 100);
			check(dao.insertProduct(product3));
			Product product4 = new Product(456, "프린터", 1200, 5);
			check(dao.insertProduct(product4));
			System.out.println();
			
			System.out.println("## 전체 리스트 ##");
			System.out.println(dao.listProduct());
			System.out.println();
			
			System.out.println("## 문자 '터'로 검색 ##");
			System.out.println(dao.searchByName("터"));
			System.out.println();
			
			System.out.println("## 1000원 이하 상품 ##");
			System.out.println(dao.searchByPrice("1000"));
			System.out.println();
			
			System.out.println("## 코드가 345인 제품 ##");
			System.out.println(dao.searchByCode("345"));
			System.out.println();
			
			System.out.println("## 코드가 456인 제품 삭제 ##");
			check(dao.deleteProduct("456"));
			System.out.println();
			
			System.out.println("## 코드가 123인 제품 가격을 5000원으로 수정 ##");
			check(dao.updateProduct("123", "5000"));
			
			System.out.println(dao.listProduct());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void check(int chk) {
		if(chk==1)
			System.out.println("성공");
		else
			System.out.println("실패");
	}

}
