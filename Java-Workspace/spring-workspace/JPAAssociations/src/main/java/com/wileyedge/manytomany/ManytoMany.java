package com.wileyedge.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class ManytoMany {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		Employee e1=new Employee("Rashmi","Hegde");
		Employee e2=new Employee("Rashi","Bendre");
		Employee e3=new Employee("Rani","Prasad");
		TechSkill s1=new TechSkill("Java");
		TechSkill s2=new TechSkill("Python");
		List<Employee> javaemployees=new ArrayList<>();
		javaemployees.add(e1);
		javaemployees.add(e2);
		List<Employee> pythonemployees=new ArrayList<>();
		pythonemployees.add(e2);
		pythonemployees.add(e3);
		s1.setEmployees(javaemployees);
		s2.setEmployees(pythonemployees);
        tx.begin();
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(s1);
        em.persist(s2);
        tx.commit();

	}

}
