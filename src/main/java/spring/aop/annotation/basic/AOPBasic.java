package spring.aop.annotation.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * import aspectjweaver.jar
 * 
 * 0.the most important thing is the rule.
 * 1.config file set <aop:aspectj-autoproxy/>
 * 2.define class with annotation @Aspect
 * 3.define method with rule,i.e.:@After("execution(* com.sample.*.*(..))")
 * 4.define this class as bean
 * 5.the service beans don't change at all
 * 
 * Advice Annotations:
 * 	@Before, @AfterReturning, @AfterThrowing, @After
 * 	@Around, @PointCut
 *
 */

public class AOPBasic {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/aop/annotation/basic/spring-config.xml");
		ObjectToAspect ota = ctx.getBean("objectToAspect", ObjectToAspect.class);
		ota.doSomething();
		ota.cc();
	}
}
