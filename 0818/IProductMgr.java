package com.ssafy.java.day0818.hw;

import java.util.List;

public interface IProductMgr {
	
	boolean add(Product b);
	
	List<Product> search();
	
	Product search(int code);
	
	List<Product> search(String name);

	List<Product> searchTV();
	
	List<Product> searchRefrigerator();
	
	List<Product> search400Refrigerator();
	
	List<Product> search50TV();
	
	boolean modify(int code, int cost);
	
	boolean delete(int code);
	
	void save();
	
	void send();
	
	int total();
}
