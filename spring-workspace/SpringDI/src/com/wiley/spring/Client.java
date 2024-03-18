package com.wiley.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= //new ClassPathXmlApplicationContext("emp.xml");
				new AnnotationConfigApplicationContext(MyConfig.class);
		
//		Employee emp1 = context.getBean("e1", Employee.class);
//		System.out.println("-------------------------------------------");

//		Employee emp2 = context.getBean("e2", Employee.class);
//		System.out.println("-------------------------------------------");
//		if(emp1==emp2) {
//			System.out.println("Both are pointing to same object");
//		}
//		
//		else {
//			System.out.println("Both are pointing to diff object");
//
//		}
//		System.out.println(emp1);
		Employee emp2 = context.getBean("e3", Employee.class);

		System.out.println(emp2);

//		Address addr1 = context.getBean("a1", Address.class);
//		System.out.println(addr1);
		
//		ConfigurableApplicationContext configctx = (ConfigurableApplicationContext) context;
		ConfigurableApplicationContext configctx=(ConfigurableApplicationContext) context;
		//this should call mydestroy()
		configctx.close();
		try {
			Thread.sleep(10000);
		}
		catch(Exception e) {
			
		}
//		
		
	}

}