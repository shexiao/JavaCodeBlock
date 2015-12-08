package jdbc.basic.execution;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.basic.connection.BasicConnection;

/**
 * 
 * ResultSet Config:
 * ResultSet Type: 
 * 	0. TYPE_FORWARD_ONLY (default)
 * 	1. TYPE_SCROLL_INSENTSITIVE
 *  2. TYPE_SCROLL_SENTSITIVE
 *  
 * ResultSet Concurrency:
 *  0. CONCUR_READ_ONLY (default)
 *  1. CONCUR_UPDATABLE
 *  
 * Cursor Holdability: (depend)
 *  0. HOLD_CURSORS_OVER_COMMIT
 *  1. CLOSE_CURSORS_AT_COMMIT
 *  
 * Cursors manipulation: (only next() can invoke default)
 *  0. next
 *  1. previous
 *  2. first
 *  3. last
 *  4. beforeFirst
 *  5. afterLast
 *  6. relative
 *  7. absolute
 *
 */

public class ResultSetUsage {
	public static void main(String[] args) {
		ResultSetUsage rsu = new ResultSetUsage();
//		rsu.updateRows();
//		rsu.insertRows();
		rsu.retrieveColumns();
	}
	
	public void retrieveColumns() {
		Connection conn = BasicConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from animals");
			while (rs.next()) {
				System.out.println("id: " + rs.getInt("id")
						+ "type: " + rs.getString("type")
						+ "name: " + rs.getString("name"));
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateRows() {
		Connection conn = BasicConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from animals");
			while (rs.next()) {
				String name = rs.getString("name");
				rs.updateString("name", name + "_update");
				rs.updateRow();
			}
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void insertRows() {
		Connection conn = BasicConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from animals");
			
			rs.moveToInsertRow();
			rs.updateString("type", "monkey");
			rs.updateString("name", "sun");
			
			rs.insertRow();
			rs.beforeFirst();
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
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
