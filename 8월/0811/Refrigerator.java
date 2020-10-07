package com.ssafy.java.day0810;

public class Refrigerator extends Product{
	String type;
	int capacity;
	
	public Refrigerator(int code, String name, int quantity, int cost, int capacity) {
		super(code, name, quantity, cost);
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
		this.type = "Refrigerator";
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [type=").append(type).append(", ").append(super.toString()).append(", capacity=").append(capacity).append("L]");
		return builder.toString();
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
