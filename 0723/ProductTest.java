package com.ssafy.java.day4.hw;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = new TV(1234567, "LG_TV", 1000000, 3, 29, "OLED");
		Refrigerator refrigerator = new Refrigerator(7654321, "Samsung_Refrigerator", 4000000, 75, 100);
		
		System.out.println(tv.toString());
		System.out.println(refrigerator.toString());
	}
}
