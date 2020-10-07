package com.ssafy.java.day0821;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
	public int insertEmp(Connection con, Employee emp) throws SQLException;
	
	public List<Employee> listEmp(Connection con) throws SQLException;
	
	public Employee searchByEmpNo(Connection con, int empNo) throws SQLException;
	
	public List<Employee> searchByEmpNmae(Connection con, String name) throws SQLException;
	
	public int updateEmp(Connection con, int empNo, String dept) throws SQLException;
	
	public int deleteEmp(Connection con, int empNo) throws SQLException;
}
