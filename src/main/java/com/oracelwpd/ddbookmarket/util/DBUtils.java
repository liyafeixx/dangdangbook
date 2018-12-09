package com.oracelwpd.ddbookmarket.util;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import  java.sql.Connection;

public class DBUtils {
   private static Properties pro;
	static {
		pro=new Properties();
		
		try {
			pro.load(DBUtils.class.getResourceAsStream("DB.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//只需要注册一次即可
	static {
		try {
			Class.forName(pro.getProperty("dirverClass"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		try {
			return (Connection) DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user")
					,pro.getProperty("pwd"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void free(ResultSet rs,Statement stmt,Connection conn) {
		
		
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (stmt!=null) {
			try {
				//交流结束需要关闭
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void free(Statement stmt, Connection conn) {
		if (stmt!=null) {
		try {
		stmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		if (conn!=null) {
		try {
		conn.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
	}
}
