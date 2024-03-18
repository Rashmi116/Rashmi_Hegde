package com.wileyedge;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HrDepartment implements ApplicationContextAware{
	
	private ApplicationContext context;


	public void recruitEmployee() {
		System.out.println("New Employee is Recruited");
		this.context.publishEvent(new EmployeeRecruitEvent(this));
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		System.out.println("Inside setApplicationContext() of HR DEPT");
	}
	
}
