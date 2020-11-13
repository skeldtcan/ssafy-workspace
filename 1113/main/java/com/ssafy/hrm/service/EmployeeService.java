package com.ssafy.hrm.service;

import java.util.List;

import com.ssafy.hrm.dto.EmployeeDto;


public interface EmployeeService {
	
	public List<EmployeeDto> findAllEmployees() throws Exception;

	
	public int addEmployee(EmployeeDto emp) throws Exception;
	
	public EmployeeDto detailEmp(int id) throws Exception;
	
}
