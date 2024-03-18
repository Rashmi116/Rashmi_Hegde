package com.wileyedge;

import org.springframework.context.ApplicationListener;

public class FinanceDepartment implements ApplicationListener<EmployeeRecruitEvent> {

	@Override
	public void onApplicationEvent(EmployeeRecruitEvent arg0) {
		System.out.println("Finance dept has started processing...");
	}

}