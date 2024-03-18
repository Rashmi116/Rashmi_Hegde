package com.wileyedge;

import java.util.List;

import com.wileyedge.Employee;

public interface IDao {
   public void saveEmployee(Employee e);
   public void modifyEmployee(Employee e);
   public List<Employee> getAllEmployees();
   public Employee getEmployeeById(int empid);
   	
   public String getEmployeeNameById(int empid);
   	
   int getEmployeeCount();
}
