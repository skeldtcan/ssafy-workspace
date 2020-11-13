package com.ssafy.hrm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.hrm.dto.EmployeeDto;



public interface ISSAFYDao {
	public List<EmployeeDto> findAllEmployees() throws Exception;
	public void addEmployee(EmployeeDto emp) throws Exception;
	int findAfterAdd() throws Exception;
	public EmployeeDto detailEmp(int id) throws Exception;
	

	
}
