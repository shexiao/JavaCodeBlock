package jdbc.basic.execution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.basic.connection.BasicConnection;

/**
 * 0. get a connection
 * 1. better using PreparedStatement than using Statement
 * 2. set the parameters and execute the manual sql
 * 3. close PreparedStatement and connection
 *
 */
public class BasicIUD {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		String insertSql = "insert into animals(type, name) values(?, ?)";
		String updateSql = "update animals set name=? where id=?";
		String deleteSql = "delete from animals where id=?";
		try {
			conn = BasicConnection.getConnection();
			pstmt = conn.prepareStatement(insertSql);
			pstmt.setString(1, "cat");
			pstmt.setString(2, "tomcat");
			pstmt.execute();
			System.out.println("insert successfully.");
			pstmt.close();
			
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setString(1, "jackjack");
			pstmt.setInt(2, 1);
			pstmt.execute();
			System.out.println("update successfully.");
			pstmt.close();
			
			pstmt = conn.prepareStatement(deleteSql);
			pstmt.setInt(1, 11);
			pstmt.execute();
			System.out.println("delete successfully.");
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
