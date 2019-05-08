package com.luv2code.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAOPExpressions {
	
	@Pointcut("execution(* com.luv2code.aop.dao.*.*(..))")
	public void forDAOPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aop.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aop.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut to include package and exclude getter/setter
	@Pointcut("forDAOPackage() && !(getter() || setter())")
	public void forDAOPackageNoGetterSetter() {}
	

}
