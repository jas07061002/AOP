package com.luv2code.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aop.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call the method to find the accounts
		List<Account> theAccounts = null;

		try {
			
			// add a boolean flag to simulate the exceptions
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}

		catch (Exception e) {
			System.out.println("\nMain Program.....caught exception: " + e);
		}
		
		// display the accounts
		System.out.println("\n\n Main Program : AfterThrowingDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");

		// close the context
		context.close();
	}

}
