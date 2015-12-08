package jdbc.basic.execution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.basic.connection.BasicConnection;

/**
 *0. get a connection
 *1. create a statement or preparedStatement
 *2. set sql and parameters
 *3. addBatch to statement
 *4. execute the statement
 *5. handle batch exception(?): when a select sql was added or update sql throw a exception 
 *
 */

public class BasicBatch {
	public static void main(String[] args) {
		BasicBatch bb = new BasicBatch();
//		bb.batchByStatement();
		bb.batchByPreparedStatement();
	}
	
	public void batchByStatement() {
		Connection conn = BasicConnection.getConnection();
		Statement stmt = null;
		
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.addBatch("insert into animals(type, name) values('monkey', 'sunwukong')");
			stmt.addBatch("insert into animals(type, name) values('fish', 'bigfish')");
			int[] count = stmt.executeBatch();
			conn.commit();
			System.out.println("count: " + count);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void batchByPreparedStatement() {
		Connection conn = BasicConnection.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("insert into animals(type, name) values(?, ?)");
			
			pstmt.setString(1, "jjjj");
			pstmt.setString(2, "jjjj");
			pstmt.addBatch();
			
			pstmt.setString(1, "kkkk");
			pstmt.setString(2, "kkkk");
			pstmt.addBatch();
			
			int[] count = pstmt.executeBatch();
			conn.commit();
			System.out.println("count: " + count);
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
