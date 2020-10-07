package com.ssafy.java.day0818.hw;

public class TV extends Product{
	String type = "";
	int size = 0;
	
	public TV(int code, String name, int quantity, int cost, int size) {
		super(code, name, quantity, cost);
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.type = "TV";
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [type=").append(type).append(", ").append(super.toString()).append(", size=").append(size).append("inch]");
		return builder.toString();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}

