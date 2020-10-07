package com.ssafy.java.day0810;

public class TV extends Product {

	public TV(int code, String name, int quantity, int cost) {
		super();
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.type = "TV";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [type=").append(type).append(", ").append(super.toString());
		return builder.toString();
	}
	
	
	
}

