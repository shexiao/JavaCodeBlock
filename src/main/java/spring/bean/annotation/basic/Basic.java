package spring.bean.annotation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

/**
 * @Required
 * @Autowired
 * @Resource
 * 
 * @Repository
 * @Service
 * @Component
 *
 * how to set properties??
 *
 */

@Repository(value="basic")
public class Basic {
	
	@Autowired
	@Qualifier(value="student")
	private Student student;
	
	public void printStudent() {
		System.out.println(student.getName());
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/bean/annotation/basic/spring-config.xml");	
		Basic b = ctx.getBean("basic", Basic.class);
		b.printStudent();
	}
}
