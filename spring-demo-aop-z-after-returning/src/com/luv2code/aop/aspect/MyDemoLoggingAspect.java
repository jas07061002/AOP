package com.luv2code.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aop.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	// add a new advice for @AfterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aop.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, 
			List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=======>>> Executing @AfterReturning on method: " +method);
		
		// print out the results of the method call
		System.out.println("\n=======>>> Result is: " +result);
		
	}
	
	@Before("com.luv2code.aop.aspect.LuvAOPExpressions.forDAOPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n====>>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " +methodSig);
		
		//display method arguments
		
		//get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through the args
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				
				//downcast and print account specific stuff
				Account theAccount = (Account)tempArg;
				
				System.out.println("account name: " +theAccount.getName());
				System.out.println("account level: " +theAccount.getLevel());
				
			}
		}
		
	}
	
	
	
	
}