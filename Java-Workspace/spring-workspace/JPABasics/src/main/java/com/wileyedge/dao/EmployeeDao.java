package com.wileyedge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.model.Address;
import com.wileyedge.model.Employee;
import com.wileyedge.utility.EntityManagerHelper;

public class EmployeeDao implements IDao {

	@Override
	public int createEmployee(int id, String fname, String lname) {
		Employee e=new Employee(); //e is in transient state
		e.setId(id);
		e.setFname(fname);
		e.setLname(lname); 
		Address a=new Address("Banglore","304690");
		e.setAddr(a);
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(e);
		tx.commit(); //e is in Managed state
		return id;
	}

	@Override
	public boolean updateEmployee(int id, String newfname) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Employee e=em.find(Employee.class, id);//e is in managed state
		if(e==null){
			  return false;        
		}
		e.setFname(newfname);
		em.merge(e);
		tx.commit();
		return true;
	}

	@Override
	public boolean removeEmployee(int id) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		Employee e=em.find(Employee.class, id); //managed state
		if(e==null){
			  return false;        
		}
		em.remove(e); //e is in removed state
		tx.commit();
		return true;
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
