package com.wileyedge.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class OnetoMany {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
       
        Employee e1=new Employee("Rashmi","Hegde");
        Employee e2=new Employee("Rashi","Bendre");
        Employee e3=new Employee("Rani","K");
        List<Employee> list1=new ArrayList<>();
        List<Employee> list2=new ArrayList<>();
        list1.add(e1);
        list1.add(e2);
        list1.add(e3);
        list2.add(new Employee("Kavita","Prasad"));
        list2.add(new Employee("Kalpana","Prasad"));
        Department d1=new Department("Java_Dept");
        Department d2=new Department("Python_Dept");
        d1.setEmployees(list1);
        d2.setEmployees(list2);
        tx.begin();
        em.persist(d1);
        em.persist(d2);
        tx.commit();

	}

}
