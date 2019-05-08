package com.luv2code.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	@Pointcut("execution(* com.luv2code.aop.dao.*.*(..))")
	private void forDAOPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aop.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aop.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut to include package and exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	private void forDAOPackageNoGetterSetter() {}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on method");
	}
	
	@Before("forDAOPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Performing API analytics");
	}

}
