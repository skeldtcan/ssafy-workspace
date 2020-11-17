package com.ssafy.hrm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.hrm.dto.EmployeeDto;

@Repository
public class SSAFyDaoImpl implements ISSAFYDao{
	
    private String ns="com.ssafy.hrm.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return sqlSession.selectList(ns+"findAllEmployees");
	}
	
	
	@Override
	public void addEmployee(EmployeeDto emp) throws Exception {
		sqlSession.insert(ns+"addEmployee",emp);
	}
	@Override
	public int findAfterAdd() throws Exception{
		return sqlSession.selectOne(ns+"findAfterAdd");
	}
}
