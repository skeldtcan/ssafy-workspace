package com.ssafy.java.day0818.hw;

import java.io.Serializable;

public class Product implements Serializable{
	int code;
	String name;
	int quantity;
	int cost;
	
	public Product() {};
	
	public Product(int code, String name, int quantity, int cost) {
		super();
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("code=").append(code).append(", name=").append(name).append(", quantity=")
				.append(quantity).append(", cost=").append(cost);
		return builder.toString();
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

}
