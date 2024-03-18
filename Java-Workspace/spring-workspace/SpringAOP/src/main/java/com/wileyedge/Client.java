package com.wileyedge;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wileyedge.dao.IDao;
import com.wileyedge.model.Employee;
import com.wileyedge.service.EmployeeService;
import com.wileyedge.service.IService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> list=new ArrayList<Employee>();
		list.add(new Employee(112,"rashmi","hegde"));
		list.add(new Employee(113,"raniRRRRRRRRRRRRRRRRyyyyy","h"));
		ApplicationContext context=new ClassPathXmlApplicationContext("aop.xml");
		IService service=context.getBean("service",IService.class);
		IDao dao=context.getBean("dao", IDao.class);
		service.saveEmployees(list);
		//service.modifyEmployees(list);
		/*List<Employee> list1=dao.getAllEmployees();
		for(Employee e:list1) {
			System.out.println(e);
		}
		System.out.println(dao.getEmployeeById(10));
		System.out.println(dao.getEmployeeNameById(10));
		System.out.println(dao.getEmployeeCount()); */


	}

}
