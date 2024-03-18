package com.wileyedge.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class OnetoOne {

	public static void main(String[] args) {
		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
       tx.begin();
       Address a=new Address("Sirsi","54790");
       em.persist(a);
       Employee e=new Employee("Rashmi","Hegde");
       e.setAddr(a);
       em.persist(e);
       tx.commit();
       
	}

}
