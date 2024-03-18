package com.wileyedge.FirstBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication //configuartion+component scan+enable automatic config
public class FirstBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(FirstBootDemoApplication.class, args);
		Employee emp=context.getBean("e1",Employee.class);
		System.out.println(emp);
	}

}
