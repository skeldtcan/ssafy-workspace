package com.ssafy.java.day0810;

import java.util.LinkedList;

public class ProductMgr {
	private LinkedList<Product> product = new LinkedList<Product>();
	/** 저장된 직원 정보의 갯수를 기억하는 변수 */
	
	private ProductMgr() {}
	private static ProductMgr mgr = new ProductMgr();
	public static ProductMgr getMgr() {
		return mgr;
	}
	
	//추가
	public void add(Product b) {
		product.add(b);
		System.out.println("## 추가: " + b.name + " ##");
    	
	}
	
	//삭제
    public boolean delete(int code) {
    	for (int i=0; i<product.size(); i++) {
    		if (product.get(i).getCode() == code) {
    			System.out.println("## 삭제 성공: " + product.get(i).name + " ##");
    			product.remove(i);
    			return true;
    		}
    	}
    	System.out.println("## 삭제 실패 ##");
    	return false;
    }
    
    //전체 리스트
    public LinkedList<Product> search(){
    	return product;
    }
    
    //번호로 검색
	public Product search(int code) {
    	for (int i=0; i<product.size(); i++) {
    		if (product.get(i).getCode() == code)
    			return product.get(i);
    	}
		
		return null;	
	}
    
	//이름으로 검색
	public LinkedList<Product> search(String name){
		LinkedList<Product> p = new LinkedList<Product>();
    	for (int i=0; i<product.size(); i++) {
    		if (product.get(i).getName().contains(name))
    			p.add(product.get(i));
    	}
	    return p;
	}
    
	//TV만 검색
	public LinkedList<Product> searchTV(){
		LinkedList<Product> p = new LinkedList<Product>();
    	for (int i=0; i<product.size(); i++) {
    		if (product.get(i).type == "TV")
    			p.add(product.get(i));
    	}
	    return p;
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
