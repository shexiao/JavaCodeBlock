package jdbc.rowset.cachedrowset;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

import com.sun.rowset.CachedRowSetImpl;

import jdbc.basic.connection.ConnectionProperties;

/**
 * 2 ways to create CachedRowSet Object
 * 0. with default constructor
 * 1. by factory
 * 
 * 0. extends JdbcRowSet
 * 1. connect to datasource and execute query
 * 2. read data from resultset and update itself
 * 3. manipulate data and make changes to data while it is disconnected
 * 4. reconnect to datasource to update data to it
 * 5. check for conflicts and solve them 
 */
public class Create {
	public static void main(String[] args) throws SQLException {
		createByDefault();
		createByFactory();
	}
	
	public static void createByDefault() throws SQLException {
		CachedRowSet cachedRowSet = new CachedRowSetImpl();
		cachedRowSet.setUrl(ConnectionProperties.URL);
		cachedRowSet.setUsername(ConnectionProperties.USERNAME);
		cachedRowSet.setPassword(ConnectionProperties.PASSWORD);
		cachedRowSet.setCommand("select * from animals");
		cachedRowSet.setKeyColumns(new int[] {1});
		cachedRowSet.execute();
		cachedRowSet.absolute(2);
		System.out.println(cachedRowSet.getInt(1));
	}
	
	public static void createByFactory() throws SQLException {
		RowSetFactory factory = RowSetProvider.newFactory();
		CachedRowSet crs = factory.createCachedRowSet();
		crs.setUrl(ConnectionProperties.URL);
		crs.setUsername(ConnectionProperties.USERNAME);
		crs.setPassword(ConnectionProperties.PASSWORD);
		crs.setCommand("select * from animals");
		crs.setKeyColumns(new int[] {1});
		crs.execute();
		crs.absolute(10);
		System.out.println(crs.getInt(1));
	}
}
