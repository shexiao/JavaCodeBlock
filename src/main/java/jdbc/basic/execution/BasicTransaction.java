package jdbc.basic.execution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import jdbc.basic.connection.BasicConnection;

/**
 * 0. jdbc auto-commit default, to use transaction, setautocommit to false first
 * 1. commit: after execute a group of sql statement, commit() to get work
 * 2. rollback: when an exception catch, better rollback() the pre sql statement
 * 3. savepoint: use with rollback, when using rollback(savepoint), the sql statement
 *    before setSavepoint() will update the db, while the after won't
 * 
 *
 */
public class BasicTransaction {
	public static void main(String[] args) {
//		basic();
//		rollback();
		savepoint();
	}
	
	public static void basic() {
		Connection conn = BasicConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into animals(type, name) values(?, ?)";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "111");
			pstmt.setString(2, "111");
			pstmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void rollback() {
		Connection conn = BasicConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into animals(type, name) values(?, ?)";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "111");
			pstmt.setString(2, "111");
			if (!pstmt.execute()) {
				throw new SQLException();
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				if (conn != null){
					conn.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void savepoint() {
		Connection conn = BasicConnection.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into animals(type, name) values(?, ?)";
		
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "111");
			pstmt.setString(2, "111");
			pstmt.execute();
			
			Savepoint savepoint = conn.setSavepoint();
			
			pstmt.setString(1, "222");
			pstmt.setString(2, "222");
			pstmt.execute();
			
			conn.rollback(savepoint);
			
			conn.commit();
			conn.setAutoCommit(true);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
