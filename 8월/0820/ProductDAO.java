package com.ssafy.java.day0820.hw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	private static ProductDAO dao = new ProductDAO();
	private DBUtil util = DBUtil.getUtil();
	
	public static ProductDAO getDAO() {
		return dao;
	}
	
	private ProductDAO() {}

	public int insertProduct(Product product) throws SQLException {
		// 1. connection 얻기
        Connection con = util.getConnection();
        // 2. Statement 생성
        String sql = "insert into product values(?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, product.getCode());
        pstmt.setString(2, product.getName());
        pstmt.setInt(3, product.getPrice());
        pstmt.setInt(4, product.getQuantity());
        
        int result = pstmt.executeUpdate();
        util.close(null, pstmt, con);
		return result;
	}
	
	public List<Product> listProduct() throws SQLException {
		List<Product> products = new ArrayList<Product>();
		Connection con = util.getConnection();
        String sql = "select * from product";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        
        while(rset.next()) {
        	int code = rset.getInt(1);
        	String name = rset.getString(2);
        	int price = rset.getInt(3);
        	int quantity = rset.getInt(4);
        	Product product = new Product(code, name, price, quantity);
        	products.add(product);
        }
        util.close(rset, pstmt, con);
        return products;
	}
	
	public List<Product> searchByName(String str) throws SQLException {
		List<Product> products = new ArrayList<Product>();
		Connection con = util.getConnection();
        String sql = "select * from product where name like '%" + str + "%'";
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        
        while(rset.next()) {
        	int code = rset.getInt(1);
        	String name = rset.getString(2);
        	int price = rset.getInt(3);
        	int quantity = rset.getInt(4);
        	Product product = new Product(code, name, price, quantity);
        	products.add(product);
        }
        util.close(rset, pstmt, con);
        return products;
	}
	
	public List<Product> searchByPrice(String p) throws SQLException {
		List<Product> products = new ArrayList<Product>();
		Connection con = util.getConnection();
        String sql = "select * from product where price <=" + p;
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        
        while(rset.next()) {
        	int code = rset.getInt(1);
        	String name = rset.getString(2);
        	int price = rset.getInt(3);
        	int quantity = rset.getInt(4);
        	Product product = new Product(code, name, price, quantity);
        	products.add(product);
        }
        util.close(rset, pstmt, con);
        return products;
	}
	
	public Product searchByCode(String c) throws SQLException {
		Connection con = util.getConnection();
        String sql = "select * from product where code =" + c;
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rset = pstmt.executeQuery();
        
        rset.next();
    	int code = rset.getInt(1);
    	String name = rset.getString(2);
    	int price = rset.getInt(3);
    	int quantity = rset.getInt(4);
    	Product product = new Product(code, name, price, quantity);
    	
        util.close(rset, pstmt, con);
        return product;
	}
	
	public int deleteProduct(String c) throws SQLException {
        Connection con = util.getConnection();
        String sql = "delete from product where code=" + c;
        PreparedStatement pstmt = con.prepareStatement(sql);
        int result = pstmt.executeUpdate();
        
        util.close(null, pstmt, con);
		return result;
	}
	
	public int updateProduct(String c, String p) throws SQLException {
        Connection con = util.getConnection();
        String sql = "update product set price =" + p + " where code=" + c;
        PreparedStatement pstmt = con.prepareStatement(sql);
        int result = pstmt.executeUpdate();
        
        util.close(null, pstmt, con);
		return result;
	}
	
	
	
}
