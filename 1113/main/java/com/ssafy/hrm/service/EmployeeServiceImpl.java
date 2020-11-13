package com.ssafy.hrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.hrm.dao.ISSAFYDao;
import com.ssafy.hrm.dto.EmployeeDto;



@Service
public class EmployeeServiceImpl implements EmployeeService {
	
    @Autowired
	private ISSAFYDao employeeDao;

    @Override
	@Transactional(readOnly=true)
	public List<EmployeeDto> findAllEmployees() throws Exception {
		return employeeDao.findAllEmployees();
	}
    
	@Override
	@Transactional
	public int addEmployee(EmployeeDto emp) throws Exception {
		//나중에 auto로 바꾸기
		emp.setId(employeeDao.findAfterAdd()+1);
		employeeDao.addEmployee(emp);
		return employeeDao.findAfterAdd();
	}

	@Override
	public EmployeeDto detailEmp(int id) throws Exception {
		return employeeDao.detailEmp(id);
	}

	
}
