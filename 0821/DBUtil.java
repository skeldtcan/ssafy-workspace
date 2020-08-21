package com.ssafy.java.day0821;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	   final String url = "jdbc:mysql://127.0.0.1:3306/ssafy04_hw?serverTimezone=UTC";
	   private static DBUtil util = new DBUtil();
	   
	   private DBUtil() {
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	   
	   public static DBUtil getUtil() {
	      return util;
	   }
	   
	   public Connection getConnection() throws SQLException {
	      return DriverManager.getConnection(url, "ssafy", "ssafy");
	   }
	   
	   public void close(ResultSet rset, Statement stmt, Connection con) {
	      try {
	         if(rset != null) {
	            rset.close();
	         }
	         if(stmt != null) {
	            stmt.close();
	         }
	         if(con != null) {
	            con.close();
	         }
	      } catch(SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public void close(ResultSet rset, Statement stmt) {
	      this.close(rset, stmt, null);
	   }
	   
	   public void close(Connection con) {
	      this.close(null, null, con);
	   }
	   
	   
	   
	}

