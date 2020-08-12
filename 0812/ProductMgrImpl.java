package com.ssafy.java.day0810;

import java.util.LinkedList;
import java.util.List;
import com.ssafy.java.day0810.exception.CodeNotFoundException;
import com.ssafy.java.day0810.exception.DuplicateException;
import com.ssafy.java.day0810.exception.ProductNotFoundException;

public class ProductMgrImpl implements IProductMgr {
	private List<Product> product = new LinkedList<Product>();
	
	private ProductMgrImpl() {}
	private static ProductMgrImpl mgr = new ProductMgrImpl();
	public static ProductMgrImpl getMgr() {
		return mgr;
	}
	
	//추가
	@Override
	public boolean add(Product b) throws DuplicateException{
	    boolean isIn = false;
		for(int i=0; i<product.size(); i++) {
			if (product.get(i).getCode() == b.getCode())
				isIn = true;
		}
		try {
		    if(isIn)
		        throw new DuplicateException(b.getCode());
		    else {
		        product.add(b);
		    }
		} catch (DuplicateException e){
		    e.printStackTrace();
		    throw e;
		} finally {
		    if(isIn)
		        return false;
		    else
		        return true;
		}
	}
	
	//전체 리스트
	@Override
	public List<Product> search(){
		return product;
	}
	
	//번호로 검색
	@Override
	public Product search(int code) throws CodeNotFoundException{
		Product p = null;
	    for (int i=0; i<product.size(); i++) {
			if (product.get(i).getCode() == code) {
			    p = product.get(i);
			}
		}
	    try {
	        if(p == null)
	            throw new CodeNotFoundException(code);
	    } catch (CodeNotFoundException e){
	        e.printStackTrace();
	        throw e;
	    } finally {
	        if(p != null)
	            return p;
	        else
	            return null;
	    }
	}
	
	
	//400L 이상 냉장고만 검색
	@Override
	public List<Product> search400Refrigerator() throws ProductNotFoundException{
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<product.size(); i++) {
			if(product.get(i) instanceof Refrigerator) {
				Refrigerator re = (Refrigerator)product.get(i);
				if(re.getCapacity() >= 400)
					p.add(product.get(i));
			}
		}
		try {
		    if(p.size() == 0)
		        throw new ProductNotFoundException();
		} catch (ProductNotFoundException e) {
		    e.printStackTrace();
		    throw e;
		} finally {
		    if(p.size() == 0)
		        return p;
		    else
		        return p;
		}
	}
	
	//50inch 이상 TV만 검색
	@Override
	public List<Product> search50TV() throws ProductNotFoundException{
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<product.size(); i++) {
			if(product.get(i) instanceof TV) {
				TV tv = (TV)product.get(i);
				if(tv.getSize() >= 50)
					p.add(product.get(i));
			}
		}
		try {
            if(p.size() == 0)
                throw new ProductNotFoundException();
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(p.size() == 0)
                return p;
            else
                return p;
        }
	}

}
