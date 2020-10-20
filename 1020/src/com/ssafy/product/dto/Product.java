package com.ssafy.product.dto;

import java.io.Serializable;

public class Product implements Serializable {
	private int productno;
	private String name;
	private String info;
	private String company;
	private int    price;
	
	
	public Product(int productno, String name, String info, String comppany, int price) {
		super();
		this.productno = productno;
		this.name = name;
		this.info = info;
		this.company = comppany;
		this.price = price;
	}
	
	public Product() {}

	@Override
	public String toString() {
		return "Product [" + "name=" + name + ", info=" + info + ", comppany=" + company
				+ ", price=" + price + "]";
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String comppany) {
		this.company = comppany;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}




