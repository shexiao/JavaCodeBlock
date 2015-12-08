package spring.jdbc.basic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/**
 * what spring jdbc does:
 * 0. open the connection
 * 1. prepare and execute the sql
 * 2. loop the query result
 * 3. process any exception
 * 4. handle transaction
 * 5. close connection, statement and resultset
 * 
 * what you do:
 * 0. define connection parameters
 * 1. define the sql statement to execute
 * 2. provide sql execute parameters
 * 3. do the work for each result that spring jdbc iterate 
 * 
 * need 2 step to config:
 * 0. define a dataSource
 * 1. define a jdbc dao bean with the dataSource, and init a JdbcTemplate Object
 * 
 * jdbcTemplate methods:
 * 0. queryForObject
 * 1. query
 * 2. update
 *
 */
public class SpringJDBCBasic {
	private JdbcTemplate jdbcTemplate;


	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void query() {
		int rowCount = this.jdbcTemplate.queryForObject("select count(*) from animals", Integer.class);
		System.out.println("Animals count: " + rowCount);
	}
	
	public void queryWithParameter() {
		String name = this.jdbcTemplate.queryForObject("select name from animals where id=?", String.class, new Object[]{1});
		System.out.println("selected animal name: " + name);
	} 
	
	public void queryList() {
		List<Animals> list = this.jdbcTemplate.query("select * from animals", new RowMapper<Animals>() {
			public Animals mapRow(ResultSet rs, int rowNum) throws SQLException {
				Animals animals = new Animals();
				animals.setId(rs.getInt("id"));
				animals.setName(rs.getString("name"));
				animals.setType(rs.getString("type"));
				return animals;
			}
		});
		for (Animals animals : list) {
			System.out.println(animals.toString());
		}
	}
}
