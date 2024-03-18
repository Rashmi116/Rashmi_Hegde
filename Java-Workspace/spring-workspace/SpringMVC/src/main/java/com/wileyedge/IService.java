package com.wileyedge;

import java.util.List;

import com.wileyedge.Employee;

public interface IService {
	public void saveEmployees(List<Employee> e);
	public void modifyEmployees(List<Employee> e);
	

}
