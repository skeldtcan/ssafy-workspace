package com.ssafy.java.day0821;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmpDaoImpl implements EmpDao {
	private static EmpDaoImpl dao = new EmpDaoImpl(); 
	DBUtil util = DBUtil.getUtil();
	private EmpDaoImpl() {}
	
	public static EmpDaoImpl getDao() {
		return dao;
	}

	@Override
	public int insertEmp(Connection con, Employee emp) throws SQLException {
		String sql = "insert into employee values(?, ?, ?, ?)";
		int result = -1;
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
            con.setAutoCommit(false);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getPosition());
			pstmt.setString(4, emp.getDept());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			con.setAutoCommit(true);
		}
		
		return result;
	}

	@Override
	public List<Employee> listEmp(Connection con) throws SQLException {
		List<Employee> emps = new ArrayList<Employee>();
		String sql = "select * from employee";
        
        try (PreparedStatement pstmt = con.prepareStatement(sql);) {
            try (ResultSet rset = pstmt.executeQuery();) {
	            while (rset.next()) {
	                int empno = rset.getInt(1);
	                String name = rset.getString(2);
	                String position = rset.getString(3);
	                String dept = rset.getString(4);
	                Employee emp = new Employee(empno, name, position, dept);
	                emps.add(emp);
	            }
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return emps;
	}

	@Override
	public Employee searchByEmpNo(Connection con, int empNo) throws SQLException {
		String sql = "select * from employee where empno=" + Integer.toString(empNo);
		Employee emp = null;
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			try (ResultSet rset = pstmt.executeQuery();) {
				rset.next();
				int empno = rset.getInt(1);
                String name = rset.getString(2);
                String position = rset.getString(3);
                String dept = rset.getString(4);
                emp = new Employee(empno, name, position, dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> searchByEmpNmae(Connection con, String n) throws SQLException {
		List<Employee> emps = new ArrayList<Employee>();
		String sql = "select * from employee where name like '%" + n + "%'";
		Employee emp = null;
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)){
			try (ResultSet rset = pstmt.executeQuery();) {
				while(rset.next()) {
					int empno = rset.getInt(1);
	                String name = rset.getString(2);
	                String position = rset.getString(3);
	                String dept = rset.getString(4);
	                emp = new Employee(empno, name, position, dept);
	                emps.add(emp);
				}
			}
		}
		return emps;
	}

	@Override
	public int updateEmp(Connection con, int empNo, String dept) throws SQLException {
		String sql = "update employee set dept=? where empno=?";
		int result = -1;
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
            con.setAutoCommit(false);
            pstmt.setString(1, dept);
            pstmt.setInt(2, empNo);
			result = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			con.rollback();
			e.printStackTrace();
		} finally {
			con.setAutoCommit(true);
		}
		return result;
	}

	@Override
	public int deleteEmp(Connection con, int empNo) throws SQLException {
		String sql = "delete from employee where empno=?";
		int result = -1;
		
		try(PreparedStatement pstmt = con.prepareStatement(sql)) {
			con.setAutoCommit(false);
			pstmt.setInt(1, empNo);
			result = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			con.setAutoCommit(true);
			e.printStackTrace();
		}
		return result;
	}


}
