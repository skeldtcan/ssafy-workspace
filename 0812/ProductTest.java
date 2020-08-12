package com.ssafy.java.day0810;

import com.ssafy.java.day0810.exception.CodeNotFoundException;
import com.ssafy.java.day0810.exception.DuplicateException;
import com.ssafy.java.day0810.exception.ProductNotFoundException;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl mgr = ProductMgrImpl.getMgr();
		TV LGTV = new TV(123, "LGOLED", 3, 500, 30);
		System.out.println("## 추가 ##");
		try {
            if(mgr.add(LGTV))
            	System.out.println("[code: " + LGTV.getCode() + "] 성공");
        } catch (DuplicateException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		TV SamsungTV = new TV(456, "SamsungQLED", 4, 1000, 20);
		try {
            if(mgr.add(SamsungTV))
            	System.out.println("[code: " + SamsungTV.getCode() + "] 성공");
        } catch (DuplicateException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
		Refrigerator LGRefrige = new Refrigerator(789, "LGKimchi", 2, 1200, 300);
		try {
            if(mgr.add(LGRefrige))
            	System.out.println("[code: " + LGRefrige.getCode() + "] 성공");
        } catch (DuplicateException e1) {
            e1.printStackTrace();
        }
		Refrigerator SamsungRefrige = new Refrigerator(101, "SamsungDaul", 5, 800, 200);
		try {
            if(mgr.add(SamsungRefrige))
            	System.out.println("[code: " + SamsungRefrige.getCode() + "] 성공");
        } catch (DuplicateException e1) {
            e1.printStackTrace();
        }
        try {
            if(mgr.add(SamsungRefrige))
                System.out.println("[code: " + SamsungRefrige.getCode() + "] 성공");
        } catch (DuplicateException e1) {
            e1.printStackTrace();
        }
		System.out.println();
		
		System.out.println("## 전체 상품 리스트 ##");
		for(Product a: mgr.search())
			System.out.println(a);
		System.out.println();
		
		System.out.println("## 상품번호로 검색 ##");
		try {
            System.out.println(mgr.search(456));
            System.out.println(mgr.search(222));
        } catch (CodeNotFoundException e) {
            e.printStackTrace();
        }
		System.out.println();
		
		System.out.println("## 400L 이상 냉장고만 검색 ##");
		try {
		    for(Product a: mgr.search50TV())
                System.out.println(a);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
		System.out.println();
		
		System.out.println("## 50inch 이상 TV만 검색 ##");
		try {
            for(Product a: mgr.search50TV())
            	System.out.println(a);
        } catch (ProductNotFoundException e) {
            e.printStackTrace();
        }
		System.out.println();
		
	}

}
