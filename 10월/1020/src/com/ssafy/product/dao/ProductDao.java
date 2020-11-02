package com.ssafy.product.dao;

import java.util.List;

import com.ssafy.product.dto.Product;

public interface ProductDao {
	public List<Product>  searchAll();
	public Product  search(int isbn);
	public void insert(Product product);
	public void update(Product product);
	public void delete(int isbn);
}
