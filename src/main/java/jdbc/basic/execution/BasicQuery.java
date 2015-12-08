package jdbc.basic.execution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.basic.connection.BasicConnection;

/**
 * 0. get a connection
 * 1. write a sql
 * 2. excute the sql
 * 3. loop and iterate the returned ResultSet
 * 4. close all object need to close
 *
 */
public class BasicQuery {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String queryAllSql = "select * from animals";
		try {
			conn = BasicConnection.getConnection();
			pstmt = conn.prepareStatement(queryAllSql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("id: " + rs.getInt("id") + ", type: " + rs.getString("type") + ", name: " + rs.getString("name")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
