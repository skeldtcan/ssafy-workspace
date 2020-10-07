package com.ssafy.java.day0810.exception;

public class DuplicateException extends Exception{
    public DuplicateException(int code ) {
        super("[code: " + code + "]인 상품이 이미 존재합니다.");
    }

}
