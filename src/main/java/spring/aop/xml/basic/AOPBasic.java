package spring.aop.xml.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPBasic {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/xml/basic/spring-config.xml");
		ServiceBean sb = ctx.getBean("serviceBean", ServiceBean.class);
		sb.doSomething();
	}
}
