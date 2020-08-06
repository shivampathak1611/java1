package com.lti.restApiDb;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class ProductDb {
public boolean service() 
	{
		Connection conn = null;
		try {

		//step-1 Loading a JDBC Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			//Step 2
			//Establishing connecion
			String url="jdbc:oracle:thin:@localhost:1521:ORCL";
			String user="system";
			String pass="GuruMaa11";
			
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection Successful");
			
			
			
			//Insert done in 2 ways:
			//1. Statement
			//2. PreparedStatement
			
			
			Statement st = conn.createStatement();
			//st.execute("Drop Table tbl_product");
			st.execute("CREATE TABLE tbl_product(id Number(5), name VARCHAR2(20), price NUMBER(8,2))");
			st.execute("INSERT INTO tbl_product VALUES(111, 'iPhoneX1', 75000)");
			st.execute("INSERT INTO tbl_product VALUES(222, 'Samsung S20', 85000)");
			st.execute("INSERT INTO tbl_product VALUES(333, 'Moto Razr', 125000)");
			
			st.execute("commit");
			
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
		return false;
	}
	public static void main(String[] args) {
		new ProductDb().service();
	}

}