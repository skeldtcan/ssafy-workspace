package com.ssafy.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.product.dto.Product;
import com.ssafy.product.dto.ProductException;
import com.ssafy.product.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	public void insert(Product product){
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql =" insert into product(productno,name,price,info,company) "
					  + " values(?,?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt( 1, product.getProductno());
			stmt.setString( 2, product.getName());
			stmt.setInt( 3, product.getPrice());
			stmt.setString( 4, product.getInfo());
			stmt.setString( 5, product.getCompany());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new ProductException("제품 정보를 등록하는 중 오류 발생");
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void update(Product product){
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql =" update product set name=?,price=?,info=?,company=? "
					  + " where productno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString( 1, product.getName());
			stmt.setInt( 2, product.getPrice());
			stmt.setString( 3, product.getInfo());
			stmt.setString( 4, product.getCompany());
			stmt.setInt( 5, product.getProductno());
			stmt.executeUpdate();
		}catch(SQLException e) {
			throw new ProductException("제품 정보를 수정하는 중 오류 발생");
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
	public void delete(int productno){
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql =" delete from product where productno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt( 1, productno);
			stmt.executeUpdate();
		}catch(SQLException e) {
			throw new ProductException("제품 정보를 삭제하는 중 오류 발생");
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	public Product search(int productno){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql =" select * from product where productno = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, productno);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Product product =  new Product();
				product.setProductno(productno);
				product.setName(rs.getString("name"));
				product.setInfo(rs.getString("info"));
				product.setCompany(rs.getString("company"));
				product.setPrice(rs.getInt("price"));
				return product;
			}
		}catch(SQLException e) {
			throw new ProductException("제품 정보를 조회하는 중 오류 발생");
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}
	public List<Product> searchAll() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql =" select * from product ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Product> products = new LinkedList<Product>();
			while(rs.next()) {
				products.add(new Product(rs.getInt("productno")
							 , rs.getString("name")
							 , rs.getString("info")
							 , rs.getString("company")
						 	, rs.getInt("price")));
			}
			return products;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new ProductException("제품 목록을 조회하는 중 오류 발생");
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	public int count() throws SQLException{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet  rs  = null;
		try {
			con = DBUtil.getConnection();
			String sql =" select count(*) as cnt from product ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			List<Product> products = new LinkedList<Product>();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return 0;
	}
}





