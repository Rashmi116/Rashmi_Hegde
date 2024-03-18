package com.wileyedge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.EmployeeDao;
import com.wileyedge.IDao;
import com.wileyedge.Employee;

@Service(value="service")
public class EmployeeService implements IService {
	@Autowired
	private IDao dao;
	@Autowired
	private PlatformTransactionManager transactionManager;
     
	@Transactional(propagation = Propagation.REQUIRED)
	

	@Override
	public void saveEmployees(List<Employee> empList) {
		//System.out.println("inside service layer");
		for(Employee e:empList) {
			dao.saveEmployee(e);
		}

	}

	@Override
	public void modifyEmployees(List<Employee> empList) {
		//System.out.println("inside service layer");
		

	}

	

}
