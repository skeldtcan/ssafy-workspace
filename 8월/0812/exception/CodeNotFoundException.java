package com.ssafy.java.day0810.exception;

public class CodeNotFoundException extends Exception{
    public CodeNotFoundException(int code) {
        super("[code: " + code + "]인 상품을 찾을 수 없습니다.");
    }

}
