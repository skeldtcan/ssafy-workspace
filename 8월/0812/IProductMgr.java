package com.ssafy.java.day0810;

import java.util.List;
import com.ssafy.java.day0810.exception.CodeNotFoundException;
import com.ssafy.java.day0810.exception.DuplicateException;
import com.ssafy.java.day0810.exception.ProductNotFoundException;

public interface IProductMgr {
	
	boolean add(Product b) throws DuplicateException;
	
	List<Product> search();
	
	Product search(int code) throws CodeNotFoundException;
	
	List<Product> search400Refrigerator() throws ProductNotFoundException;
	
	List<Product> search50TV() throws ProductNotFoundException;
	
}
