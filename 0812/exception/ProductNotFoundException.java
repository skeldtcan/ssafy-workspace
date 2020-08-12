package com.ssafy.java.day0810.exception;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException() {
        super("해당 조건에 만족하는 상품이 없습니다.");
    }

}
