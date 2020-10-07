package com.ssafy.java.day5;

public class Product {
	int num;
	String name;
	int price;
	int quantity;
	
	public Product(int num, String name, int price, int quantity) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [num=").append(num).append(", name=").append(name).append(", price=").append(price)
				.append(", quantity=").append(quantity).append("]");
		return builder.toString();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
	
}
