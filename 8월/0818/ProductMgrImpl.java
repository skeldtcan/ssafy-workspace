package com.ssafy.java.day0818.hw;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ProductMgrImpl implements IProductMgr {
	private List<Product> products = new LinkedList<Product>();
	
	private ProductMgrImpl() {}
	private static ProductMgrImpl mgr = new ProductMgrImpl();
	public static ProductMgrImpl getMgr() {
		return mgr;
	}
	
	@Override
    public void save() {
		new Thread(() -> {
            try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("product.dat"))) {
                oout.writeObject(products);
                System.out.println("파일 저장 완료!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
	
	@Override
    public void send() {
        // 서버로 파일 전송할 계획
        new Thread(() -> {
            try (Socket socket = new Socket("localhost", 9999);
                    ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream())) {
            	oout.writeObject(searchTV());
                System.out.println("전송 완료!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (Socket socket = new Socket("localhost", 9999);
                    ObjectOutputStream oout = new ObjectOutputStream(socket.getOutputStream())) {
            	oout.writeObject(searchRefrigerator());
                System.out.println("전송 완료!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
	
	//추가
	@Override
	public boolean add(Product b) {
		for(int i=0; i<products.size(); i++) {
			if (products.get(i).getCode() == b.getCode())
				return false;
		}
		products.add(b);
		return true;
	}
	
	//전체 리스트
	@Override
	public List<Product> search(){
		return products;
	}
	
	//번호로 검색
	@Override
	public Product search(int code) {
		for (int i=0; i<products.size(); i++) {
			if (products.get(i).getCode() == code)
				return products.get(i);
		}
		return null;	
	}
	
	//이름으로 검색
	@Override
	public List<Product> search(String name){
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<products.size(); i++) {
			if (products.get(i).getName().contains(name))
				p.add(products.get(i));
		}
		return p;
	}
	
	//TV만 검색
	@Override
	public List<Product> searchTV(){
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<products.size(); i++) {
			if(products.get(i) instanceof TV) {
				TV tv = (TV)products.get(i);
				p.add(tv);
			}
		}
		return p;
	}
	
	//냉장고만 검색
	@Override
	public List<Product> searchRefrigerator() {
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				Refrigerator re = (Refrigerator)products.get(i);
				p.add(re);
			}
		}
		return p;
	}
	
	//400L 이상 냉장고만 검색
	@Override
	public List<Product> search400Refrigerator() {
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				Refrigerator re = (Refrigerator)products.get(i);
				if(re.getCapacity() >= 400)
					p.add(products.get(i));
			}
		}
		return p;
	}
	
	//50inch 이상 TV만 검색
	@Override
	public List<Product> search50TV(){
		List<Product> p = new LinkedList<Product>();
		for (int i=0; i<products.size(); i++) {
			if(products.get(i) instanceof TV) {
				TV tv = (TV)products.get(i);
				if(tv.getSize() >= 50)
					p.add(products.get(i));
			}
		}
		return p;
	}
	
	//번호로 검색해서 가격 수정
	@Override
	public boolean modify(int code, int cost) {
		for (int i=0; i<products.size(); i++) {
			if (products.get(i).getCode() == code) {
				products.get(i).setCost(cost);
				return true;
			}
		}
		return false;	
	}
	
	
	//삭제
    public boolean delete(int code) {
    	for (int i=0; i<products.size(); i++) {
    		if (products.get(i).getCode() == code) {
    			products.remove(i);
    			return true;
    		}
    	}
    	return false;
    }
	
	
	//전체 재고 * 수량
	public int total() {
		int sum = 0;
		for (int i=0; i<products.size(); i++) {
			sum += products.get(i).getQuantity() * products.get(i).getCost(); 
		}
		return sum;
	}
	
	

}
