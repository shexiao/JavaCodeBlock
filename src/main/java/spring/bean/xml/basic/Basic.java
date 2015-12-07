package spring.bean.xml.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Basic {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/bean/xml/basic/bean-basic.xml");
		Student stu = ctx.getBean("student", Student.class);
		System.out.println(stu.toString());
		
		//init with factory-method
		Student stu1 = ctx.getBean("student1", Student.class);
		System.out.println(stu1.toString());
		
		//init with instance factory method
		Student stu2 = ctx.getBean("student2", Student.class);
		System.out.println(stu2.toString());
		
		/*-------------------------------------*/
		Student stu_arg = ctx.getBean("student_arg", Student.class);
		System.out.println(stu_arg.toString());
		System.out.println(stu_arg.getInfo().getInfo());
	}
}
