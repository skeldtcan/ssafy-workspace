package com.ssafy.java.day0810;

public class Product {
	int code;
	String name;
	int quantity;
	int cost;
	String type;
	
	public Product() {};
	
	public Product(int code, String name, int quantity, int cost, String type) {
		super();
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("code=").append(code).append(", name=").append(name).append(", quantity=")
				.append(quantity).append(", cost=").append(cost).append("]");
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
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		

}
