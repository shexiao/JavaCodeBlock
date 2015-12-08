package spring.jdbc.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Basic {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/jdbc/basic/spring-jdbc-config.xml");
		SpringJDBCBasic bb = ctx.getBean("springJDBCBasic", SpringJDBCBasic.class);
		bb.query();
		bb.queryWithParameter();
		bb.queryList();
	}
}
