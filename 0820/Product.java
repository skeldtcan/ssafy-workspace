package com.ssafy.java.day0820.hw;

public class Product {
	private int code;
	private String name;
	private int price;
	private int quantity;
	
	
	public Product(int code, String name, int price, int quantity) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [code=").append(code).append(", name=").append(name).append(", price=").append(price)
				.append(", quantity=").append(quantity).append("]");
		return builder.toString();
	}
	
	
	

}
