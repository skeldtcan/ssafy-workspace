package com.ssafy.java.day4.hw;

public class Refrigerator {
	private int code;
	private String name;
	private int price;
	private int quantity;
	private int capacity;
	
	public Refrigerator(int code, String name, int price, int qunatity, int cpapcity) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = qunatity;
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Refrigerator [제품번호=" + code + ", 제품명=" + name + ", 가격=" + price + "원, 재고수량=" + quantity
				+ "개, 용량=" + capacity + "(L)]";
	}

	public int getcode() {
		return code;
	}
	public void setcode(int code) {
		this.code = code;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	public int getquantity() {
		return quantity;
	}
	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	

}
