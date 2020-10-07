package com.ssafy.java.day0818.hw;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl mgr = ProductMgrImpl.getMgr();
		System.out.println("## 추가 ##");
		Refrigerator LGRefrige = new Refrigerator(789, "LGKimchi", 2, 1200, 300);
		if(mgr.add(LGRefrige))
			System.out.println("성공");
		Refrigerator SamsungRefrige = new Refrigerator(101, "SamsungDaul", 5, 800, 500);
		if(mgr.add(SamsungRefrige))
			System.out.println("성공");
		TV LGTV = new TV(123, "LGOLED", 3, 500, 30);
		if(mgr.add(LGTV))
			System.out.println("성공");
		TV SamsungTV = new TV(456, "SamsungQLED", 4, 1000, 50);
		if(mgr.add(SamsungTV))
			System.out.println("성공");
		System.out.println();
		
		System.out.println("## 전체 상품 리스트 ##");
		for(Product a: mgr.search())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 상품번호로 검색 ##");
		System.out.println(mgr.search(456));
		System.out.println();
		
		System.out.println("## 이름으로 검색 ##");
		for(Product a: mgr.search("LG"))
			System.out.println(a);
		System.out.println();
		
		
		System.out.println("## TV만 검색 ##");
		for(Product a: mgr.searchTV())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 냉장고만 검색 ##");
		for(Product a: mgr.searchRefrigerator())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 400L 이상 냉장고만 검색 ##");
		for(Product a: mgr.search400Refrigerator())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 50inch 이상 TV만 검색 ##");
		for(Product a: mgr.search50TV())
			System.out.println(a);
		System.out.println();
		
		
		System.out.println("## 코드로 검색해서 가격수정 ##");
		if(mgr.modify(123, 5000))
			System.out.println("성공");
		else
			System.out.println("실패");
		for(Product a: mgr.search())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 코드로 검색해서 상품삭제 ##");
		if(mgr.delete(456))
			System.out.println("성공");
		else
			System.out.println("실패");
		for(Product a: mgr.search())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 전체 재고*가격 ##");
		System.out.println(mgr.total() + "원");
		System.out.println();
		
		System.out.println("## 저장 ##");
		mgr.save();
		System.out.println();
		
		System.out.println("## 전송 ##");
		mgr.send();
	}

}
