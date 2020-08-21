package com.ssafy.java.day0821;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpTest {

	public static void main(String[] args) throws SQLException {
		EmpMgrImpl mgr = EmpMgrImpl.getMgr();
		
		System.out.println("## 추가 ##");
		Employee emp1 = new Employee(123, "김동현", "사장", "CEO");
		mgr.addEmp(emp1);
		Employee emp2 = new Employee(345, "홍길동", "사원", "마케팅");
		mgr.addEmp(emp2);
		System.out.println();
		
		System.out.println("## 전체 조회 ##");
		System.out.println(mgr.search());
		System.out.println();
		
		System.out.println("## 사번 123으로 조회 ##");
		System.out.println(mgr.search(123));
		System.out.println();
		
		System.out.println("## 이름에 '동'이 들어간 조회 ##");
		System.out.println(mgr.search("동"));
		System.out.println();
		
		System.out.println("## 사번 123을 운영팀으로 수정 ##");
		System.out.println("update결과: " + mgr.updateEmp(123, "운영팀"));
		System.out.println(mgr.search());
		System.out.println();
		
		System.out.println("## 사번 345를 삭제 ##");
		System.out.println("delete결과: " + mgr.deleteEmp(345));
		System.out.println(mgr.search());
		mgr.deleteEmp(123);
		
	}

}
