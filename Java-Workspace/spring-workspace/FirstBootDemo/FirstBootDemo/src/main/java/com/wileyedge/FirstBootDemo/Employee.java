package com.wileyedge.FirstBootDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="e1")
public class Employee {
	@Value("101")
	private int id;
	@Value("Rashmi")
	private String name;
	
	public Employee() {
		System.out.println("inside default employee");
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
