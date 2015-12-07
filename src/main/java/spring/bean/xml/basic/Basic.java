package spring.bean.xml.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Basic {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-basic.xml");
		Student stu = ctx.getBean("student", Student.class);
		System.out.println(stu.toString());
	}
}
