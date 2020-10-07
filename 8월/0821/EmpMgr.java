package com.ssafy.java.day0821;

import java.sql.SQLException;
import java.util.List;

public interface EmpMgr {
	public void addEmp(Employee Emp) throws SQLException;

    public List<Employee> search() throws SQLException;
    
    public Employee search(int empNo) throws SQLException;
    
    public List<Employee> search(String name) throws SQLException;
    
    public Boolean updateEmp(int empNo, String dept) throws SQLException;
    
    public Boolean deleteEmp(int empNo) throws SQLException;
}
