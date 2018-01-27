package com.neo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private static Connection conn = null;
	public static String url = "jdbc:mysql://127.0.0.1:3306/grade_management";
	public static String username = "sa";
	public static String password = "123456";

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConncetion() throws Exception{
		return conn;
	}

	public static void realseConnection() throws SQLException{
		conn.close();
	}
}
