package com.wileyedge.jpql;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.wileyedge.utility.EntityManagerHelper;

public class EmployeeDao implements IDao {

	@Override
	public List<Employee> getEmployees() {
		System.out.println("inside getempl");
		EntityManager em=EntityManagerHelper.getEntityManager();
		List<Employee> list=em.createQuery("from Employee").getResultList();
		return list;
	}

	@Override
	public List<Employee> getEmployeesWithIdGrX(int x) {
		System.out.println("inside get empl with id greater than");
		EntityManager em=EntityManagerHelper.getEntityManager();
		Query q=em.createQuery("FROM Employee where id >= :id order by id");
		q.setParameter("id", x);
		List<Employee> list=q.getResultList();
		return list;
		
	}

	@Override
	public List<String> getEmployeeNames() {
		System.out.println("inside getempl names");
		EntityManager em=EntityManagerHelper.getEntityManager();
		Query q=em.createQuery("select fname from Employee");
		List<String> list=q.getResultList();
		return list;
		
	}

	@Override
	public List<Employee> getXEmployees(int startindex, int number) {
		System.out.println("inside getx employees");
		EntityManager em=EntityManagerHelper.getEntityManager();
		Query q=em.createQuery("from Employee");
		q.setFirstResult(startindex);
		q.setMaxResults(number);
		List<Employee> list=q.getResultList();
		return list;
	}

	@Override
	public List<Employee> getEmployeesUsingNamedQuery() {
		System.out.println("inside getempl using names query");
		EntityManager em=EntityManagerHelper.getEntityManager();
		Query q=em.createNamedQuery("get.all");
		List<Employee> list=q.getResultList();
		return list;
		
	}

	@Override
	public List<Employee> getEmployeesUsingNativeNamedQuery() {
		// TODO Auto-generated method stub
		System.out.println("inside getempl using names query");
		EntityManager em=EntityManagerHelper.getEntityManager();
		Query q=em.createNamedQuery("get.all.native");
		List<Object[]> list=q.getResultList();
		List<Employee> emplist=new ArrayList<>();
		for(Object[] objarr :list) {
			int id=new Integer(objarr[0].toString());
			String fname=objarr[1].toString();
			String lname=objarr[2].toString();
			emplist.add(new Employee(id,fname,lname));
			
		}
		return emplist;
		
		
	}

	@Override
	public void displayEmployeesByIdFnameUsingCriteria(int id, String fname) {
		System.out.println("inside display getempl ");
		EntityManager em=EntityManagerHelper.getEntityManager();
		CriteriaBuilder cb=em.getCriteriaBuilder();
		CriteriaQuery<Employee>cq=cb.createQuery(Employee.class);
		Root<Employee> from=cq.from(Employee.class);
		Predicate pred1=cb.equal(from.get("id"), id);
		Predicate pred2=cb.equal(from.get("fname"), fname);
		cq.select(from);
		cq.where(cb.and(pred1));
		cq.where(cb.and(pred2));
		TypedQuery<Employee> q=em.createQuery(cq);
		List<Employee> list=q.getResultList();
		list.stream().forEach(System.out::println);

	}

	@Override
	public void createEmployee(String fname, String lname) {
		System.out.println("inside create empl with id");
		EntityManager em=EntityManagerHelper.getEntityManager();
		Employee e=new Employee(fname,lname);
		EntityTransaction et =em.getTransaction();
		et.begin();
		em.persist(e);
		et.commit();
	}

}
