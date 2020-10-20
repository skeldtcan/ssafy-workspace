package com.ssafy.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.product.dao.ProductDao;
import com.ssafy.product.dto.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao dao;
	
	
	
	public ProductServiceImpl() {}
    
    public ProductServiceImpl(ProductDao dao) {
        super();
        this.dao = dao;
    }
    
    public ProductDao getDao() {
        return dao;
    }

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }
    
    
	
	public List<Product> searchAll() {
		return dao.searchAll();
	}
	public Product search(int productno) {
		return dao.search(productno);
	}
	public void insert(Product product) {
		dao.insert(product);
	}
	public void update(Product product) {
		dao.update(product);
	}
	public void delete(int productno) {
		dao.delete(productno);
	}
}
