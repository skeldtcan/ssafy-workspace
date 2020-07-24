package com.ssafy.java.day5;

import java.util.Arrays;

public class ProductMgr {
	Product[] product = new Product[100];
	int size = 0;
	
	private ProductMgr() {}
	private static ProductMgr mgr = new ProductMgr();
	public static ProductMgr getMgr() {
		return mgr;
	}
	
	public void add(Product p) {
		System.out.println(" --- [상품 추가] --- ");
		boolean is_in = false;
		for (int i=0; i<size; i++) {
			if (product[i].getName().contains(p.getName())) {
				System.out.println("이미 추가된 상품입니다.");
				is_in = true;
				break;
			}			
		}
		if (!is_in) {
			product[size++] = p;
			System.out.println(p.getName()+" 상품을 추가했습니다.");
		}
	}
	
	public void list() {
		System.out.println(" --- [전체 상품 보기] --- ");
		for (int i=0; i<size; i++)
			System.out.println(product[i]);
	}
	
	public void list(int num) {
		System.out.println(" --- [상품 번호로 검색] --- ");
		for (int i=0; i<size; i++) {
			if (product[i].getNum() == num) {
				System.out.println(product[i]);
			}
		}
	}
	
	public void delete(int num) {
		System.out.println(" --- [상품 번호로 삭제] --- ");
		boolean is_del = false;
		for (int i=0; i<size; i++) {
			if (product[i].getNum() == num) {
				if (i == size-1) {
					product[i] = null;
					size--;
				} else {
					product[i] = product[--size];
				}
				System.out.println("삭제 완료!");
				is_del = true;
			}
		}
		if (!is_del) System.out.println("해당 상품이 없습니다.");
	}
	
	public void priceList(int price) {
		System.out.println(" --- ["+price+"원 이하 상품 검색] --- ");
		for (int i=0; i<size; i++) {
			if (product[i].getPrice() <= price) {
				System.out.println(product[i]);
			}
		}
	}
}
