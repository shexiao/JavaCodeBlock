package spring.aop.annotation.basic;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectObject {
	
	@Before("execution(* spring.aop.annotation.basic.ObjectToAspect.*())")
	public void doBefore() {
		System.out.println("do before");
	}
	
	@After("execution(* spring.aop.annotation.basic.ObjectToAspect.*())")
	public void doAfter() {
		System.out.println("do after");
	}
}
