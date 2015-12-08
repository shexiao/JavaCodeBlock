package jdbc.basic.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 0. define url, username, password
 * 1. use DriverManager.getConnection() to get a connection
 * 2. the other way to get a connection is using DataSource(?)
 *
 */
public class BasicConnection {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = getConnection();
			if (conn.isValid(0)) {
				System.out.println("mysql database connected.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/spring_mybatis";
		String username = "root";
		String password = "root";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
}
