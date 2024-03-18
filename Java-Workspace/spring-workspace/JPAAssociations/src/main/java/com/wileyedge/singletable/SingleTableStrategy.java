package com.wileyedge.singletable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wileyedge.utility.EntityManagerHelper;

public class SingleTableStrategy {

	public static void main(String[] args) {

		EntityManager em=EntityManagerHelper.getEntityManager();
		EntityTransaction tx=em.getTransaction();
		
		Employe e1 = new PermanentEmployee("Rashmi","Hegde",3001);
		Employe e2 = new PermanentEmployee("Ravi","Kumar",3002);
		
		Employe e3 = new ContractEmployee("Venktesh","G","wileyedge");
		Employe e4 = new ContractEmployee("Suresh","Kumar","wileyedge");
		
		tx.begin();
		
		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);
		
		em.close();
		
		tx.commit();
		
	}

}
