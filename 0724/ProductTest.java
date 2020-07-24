package com.ssafy.java.day5;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductMgr mgr = ProductMgr.getMgr();
		Product p1 = new Product(123, "TV", 50000, 3);
		Product p2 = new Product(123, "TV", 50000, 3);
		Product p3 = new Product(456, "Computer", 100000, 5);
		Product p4 = new Product(789, "MacBook", 80000, 2);
		mgr.add(p1);
		mgr.add(p2);
		mgr.add(p3);
		mgr.add(p4);
		mgr.list();
		mgr.list(123);
		mgr.delete(456);
		mgr.delete(456);
		mgr.priceList(90000);
		
	}

}
