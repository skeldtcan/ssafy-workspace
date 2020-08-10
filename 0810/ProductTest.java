package com.ssafy.java.day0810;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getMgr();
		TV LGTV = new TV(123, "LGOLED", 3, 500);
		mgr.add(LGTV);
		TV SamsungTV = new TV(456, "SamsungQLED", 4, 1000);
		mgr.add(SamsungTV);
		Refrigerator LGRefrige = new Refrigerator(789, "LGKimchi", 2, 1200);
		mgr.add(LGRefrige);
		Refrigerator SamsungRefrige = new Refrigerator(101, "SamsungDaul", 5, 800);
		mgr.add(SamsungRefrige);
		System.out.println();
		
		mgr.delete(101);
		System.out.println();

		System.out.println("## 전체 상품 리스트 ##");
		for(Product a: mgr.search())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 이름으로 검색 ##");
		for(Product a: mgr.search("LG"))
			System.out.println(a);
		System.out.println();
		
		
		System.out.println("## TV만 검색 ##");
		for(Product a: mgr.searchTV())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 전체 재고*가격 ##");
		System.out.println(mgr.total() + "원");
		

	}

}
