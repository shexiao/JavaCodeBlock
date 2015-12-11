package jdbc.rowset.jdbcrowset;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.sun.rowset.JdbcRowSetImpl;

import jdbc.basic.connection.BasicConnection;;


/**
 * 5 kinds of RowSet:
 * 0. JdbcRowSet
 * 1. CachedRowSet <- JdbcRowSet
 * 2. WebRowSet <- CachedRowSet
 * 3. JoinRowSet <- WebRowSet
 * 4. FilteredRowSet <- WebRowSet
 * 
 * 4 ways to create a RowSet Object
 * 0. with ResultSet: ResultSet must be set TYPE_SCROLL_SENSITIVE and CONCUR_UPDATABLE
 * 1. with Connection
 * 2. default constructor: setCommand(), setUrl(), setUsername(), setPassword()
 * 3. by RowSetFacotry: 
 * 
 *
 */
public class Create {
	public static void main(String[] args) throws SQLException {
		createByResultset();
		createByConnection();
		createByDefault();
		createByFactory();
	}

	public static void createByResultset() throws SQLException {
		Connection conn = BasicConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from animals";

		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		JdbcRowSet jdbcRowset = new JdbcRowSetImpl(rs);
		jdbcRowset.absolute(1);
		System.out.println(
				jdbcRowset.getInt("id") + " " + jdbcRowset.getString("type") + " " + jdbcRowset.getString("name"));
	}

	public static void createByConnection() throws SQLException {
		Connection conn = BasicConnection.getConnection();
		JdbcRowSet jdbcRowSet = new JdbcRowSetImpl(conn);
		jdbcRowSet.setCommand("select * from animals");
		jdbcRowSet.execute();
		jdbcRowSet.absolute(2);
		System.out.println(
				jdbcRowSet.getInt("id") + " " + jdbcRowSet.getString("type") + " " + jdbcRowSet.getString("name"));

	}

	public static void createByDefault() throws SQLException {
		JdbcRowSet jdbcRowSet = new JdbcRowSetImpl();
		jdbcRowSet.setCommand("select * from animals");
		jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/spring_mybatis");
		jdbcRowSet.setUsername("root");
		jdbcRowSet.setPassword("root");
		jdbcRowSet.execute();
		jdbcRowSet.absolute(3);
		System.out.println(
				jdbcRowSet.getInt("id") + " " + jdbcRowSet.getString("type") + " " + jdbcRowSet.getString("name"));
	}
	
	public static void createByFactory() throws SQLException {
		RowSetFactory factory = RowSetProvider.newFactory();
		JdbcRowSet jdbcRowSet = factory.createJdbcRowSet();
		jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/spring_mybatis");
		jdbcRowSet.setUsername("root");
		jdbcRowSet.setPassword("root");
		jdbcRowSet.setCommand("select * from animals");
		jdbcRowSet.execute();
		jdbcRowSet.absolute(4);
		System.out.println(
				jdbcRowSet.getInt("id") + " " + jdbcRowSet.getString("type") + " " + jdbcRowSet.getString("name"));

	}
}
