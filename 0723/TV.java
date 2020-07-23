package com.ssafy.java.day4.hw;

public class TV {
	private int code;
	private String name;
	private int price;
	private int quantity;
	private int size;
	private String dis;	
	
	public TV(int code, String name, int price, int quantity, int size, String dis) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.size = size;
		this.dis = dis;
	}
	
	@Override
	public String toString() {
		return "TV [제품번호=" + code + ", 제품명=" + name + ", 가격=" + price + "원, 재고수량=" + quantity + "개, 인치=" + size
				+ "(inch), 디스플레이 타입 정보=" + dis + "]";
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDis() {
		return dis;
	}
	public void setDis(String dis) {
		this.dis = dis;
	}
}
