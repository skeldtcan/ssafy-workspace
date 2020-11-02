package com.ssafy.product.dto;


public class ProductException extends RuntimeException {
	public ProductException() {
		super("Product 정보를 처리 중 오류 발생");
	}
	public ProductException(String msg) {
		super(msg);
	}
}
