package com.feng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestDatabase {

	public static void main(String[] args) {
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
			 String url = "jdbc:mysql://localhost:3306/test" ;    
		     String username = "root" ;   
		     String password = "root" ;   
		    Connection con =    
		             DriverManager.getConnection(url , username , password ) ;   
		    Statement stmt = con.createStatement() ;  
		    ResultSet rs = stmt.executeQuery("select name from userinfo");
		    while(rs.next()) {
		    	System.out.println(rs.getString(1));
		    }
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
