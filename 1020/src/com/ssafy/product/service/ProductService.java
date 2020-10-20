package com.ssafy.product.service;

import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductService {
	public List<Product>  searchAll();
	public Product search(int productno);
	public void insert(Product product);
	public void update(Product product);
	public void delete(int productno);
}



