package com.lti.restApiDb;

//classes which contain DB code are commonly
//reffered to as Data Access Objects

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDao {
	
	public Product select (int id)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user="system";
			String pass="GuruMaa11";
			
			conn = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT * FROM tbl_product where id = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				return product;
			}
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Product> selectAll()
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> products = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user="system";
			String pass="GuruMaa11";
			
			conn = DriverManager.getConnection(url, user, pass);
			
			String sql = "SELECT * FROM tbl_product";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				products.add(product);
			}
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(products.size() != 0)
			return products;
		else
			return null;
	}
	public void insert(Product product)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user="system";
			String pass="GuruMaa11";
			
			conn = DriverManager.getConnection(url, user, pass);
			
			String sql = "INSERT INTO tbl_product VALUES(?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, product.getId());
			pst.setString(2, product.getName());
			pst.setDouble(3, product.getPrice());
			pst.executeQuery();
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
