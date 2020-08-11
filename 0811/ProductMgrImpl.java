package com.ssafy.java.day0810;

import java.util.LinkedList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {
	private List<Product> product = new LinkedList<Product>();
	
	private ProductMgrImpl() {}
	private static ProductMgrImpl mgr = new ProductMgrImpl();
	public static ProductMgrImpl getMgr() {
		return mgr;
	}
	
	//추가
	@Override
	public boolean add(Product b) {
		for(int i=0; i<product.size(); i++) {
			if (product.get(i).getCode() == b.getCode())
				return false;
		}
		product.add(b);
		return true;
	}
	
	//전체 리스트
	@Override
	public List<Product> search(){
		return product;
	}
	
	//번호로 검색
	@Override
	public Product search(int code) {
		for (int i=0; i<product.size(); i++) {
			if (product.get(i).getCode() == code)
				return product.get(i);
		}
		return null;	
	}
	
	//이름으로 검색
	@Override
	public List<Product> search(String name){
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<product.size(); i++) {
			if (product.get(i).getName().contains(name))
				p.add(product.get(i));
		}
		return p;
	}
	
	//TV만 검색
	@Override
	public List<Product> searchTV(){
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<product.size(); i++) {
			if(product.get(i) instanceof TV) {
				TV tv = (TV)product.get(i);
				p.add(tv);
			}
		}
		return p;
	}
	
	//냉장고만 검색
	@Override
	public List<Product> searchRefrigerator() {
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<product.size(); i++) {
			if(product.get(i) instanceof Refrigerator) {
				Refrigerator re = (Refrigerator)product.get(i);
				p.add(re);
			}
		}
		return p;
	}
	
	//400L 이상 냉장고만 검색
	@Override
	public List<Product> search400Refrigerator() {
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<product.size(); i++) {
			if(product.get(i) instanceof Refrigerator) {
				Refrigerator re = (Refrigerator)product.get(i);
				if(re.getCapacity() >= 400)
					p.add(product.get(i));
			}
		}
		return p;
	}
	
	//50inch 이상 TV만 검색
	@Override
	public List<Product> search50TV(){
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<product.size(); i++) {
			if(product.get(i) instanceof TV) {
				TV tv = (TV)product.get(i);
				if(tv.getSize() >= 50)
					p.add(product.get(i));
			}
		}
		return p;
	}
	
	//번호로 검색해서 가격 수정
	@Override
	public boolean modify(int code, int cost) {
		for (int i=0; i<product.size(); i++) {
			if (product.get(i).getCode() == code) {
				product.get(i).setCost(cost);
				return true;
			}
		}
		return false;	
	}
	
	
	//삭제
    public boolean delete(int code) {
    	for (int i=0; i<product.size(); i++) {
    		if (product.get(i).getCode() == code) {
    			product.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
	
	
	//전체 재고 * 수량
	public int total() {
		int sum = 0;
		for (int i=0; i<product.size(); i++) {
			sum += product.get(i).getQuantity() * product.get(i).getCost(); 
		}
		return sum;
	}
	
	

}
