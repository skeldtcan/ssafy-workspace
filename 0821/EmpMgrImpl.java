package com.ssafy.java.day0821;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.java.day13.dto.Book;

public class EmpMgrImpl implements EmpMgr{
	private static EmpMgrImpl mgr = new EmpMgrImpl();
	
	private EmpMgrImpl() {}
	
	public static EmpMgrImpl getMgr() {
		return mgr;
	}
	
	private DBUtil util = DBUtil.getUtil();
	private EmpDaoImpl dao = EmpDaoImpl.getDao();
	
	
	@Override
	public void addEmp(Employee emp) throws SQLException {
        Connection con = null;
        int result = -1;
        try {
        con = util.getConnection();
        con.setAutoCommit(false);
        result = dao.insertEmp(con, emp);
        if (result == -1)
        	System.out.println("직원 추가 실패");
        else 
        	System.out.println("직원 추가 성공");
        
        } catch (RuntimeException | SQLException e) {
        	con.rollback();
        	e.printStackTrace();
        	throw e;
        } finally {
        	con.setAutoCommit(true);
        	util.close(con);
        }
	}

	@Override
	public List<Employee> search() throws SQLException {
		List<Employee> emps = null;
        Connection con = null;
        
        try {
            con = util.getConnection();
            con.setAutoCommit(false);
            emps = dao.listEmp(con);
        } catch (RuntimeException | SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            con.setAutoCommit(true);
            util.close(con);
        }
        return emps;
	}

	@Override
	public Employee search(int empNo) throws SQLException {
		Connection con = null;
		Employee emp = null;
		try {
			con = util.getConnection();
			emp = dao.searchByEmpNo(con, empNo);
		} catch(RuntimeException | SQLException e) {
            e.printStackTrace();
            throw e;
		} finally {
            util.close(con);
        }
		return emp;
	}

	@Override
	public List<Employee> search(String name) throws SQLException {
		List<Employee> emps = null;
        Connection con = null;
        
        try {
            con = util.getConnection();
            emps = dao.searchByEmpNmae(con, name);
        } catch (RuntimeException | SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            util.close(con);
        }
        return emps;
	}

	@Override
	public Boolean updateEmp(int empNo, String dept) throws SQLException {
		Connection con = null;
		int result = -1;
        try {
            con = util.getConnection();
            result = dao.updateEmp(con, empNo, dept);
        } catch (RuntimeException | SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            util.close(con);
        }
		return result == -1 ? false:true;
	}

	@Override
	public Boolean deleteEmp(int empNo) throws SQLException {
		Connection con = null;
		int result = -1;
		try {
			con = util.getConnection();
			result = dao.deleteEmp(con, empNo);
		} catch (SQLException e) {
			
		}
		return result == -1 ? false : true;
	}
	
	

}
