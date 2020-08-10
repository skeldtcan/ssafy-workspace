package com.ssafy.java.day0810;

public class Refrigerator extends Product{

	public Refrigerator(int code, String name, int quantity, int cost) {
		super();
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.type = "Refrigerator";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [type=").append(type).append(", ").append(super.toString());
		return builder.toString();
	}
}
