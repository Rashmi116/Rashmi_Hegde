package com.emp;

import com.emp.utility.Address;

public class TestEmployee {

	public static void main(String[] args) {
		
		System.out.println("Welcome to java");
		Address a1=new Address("India","Sirsi",581336);

		Employee e1=new Employee(11,"Rashmi","Hegde",a1);
//		e1.setId(11);
//		e1.setFname("Rashmi");
//		e1.setLname("Hegde");
		Address a2=new Address("India","Banglore",567438);

		Employee e2=new Employee(12,"Raksha","Bhat",a1);
//		e2.setId(20);
//		e2.setFname("Raksha");
//		e2.setLname("Bhat");
		
//		a1.setCountry("India");
//		a1.setCity("Sirsi");
//		a1.setZip(67483);
		
//		a2.setCountry("India");
//		a2.setCity("Banglore");
//		a2.setZip(45678);
		
//		e1.setA(a1);
		e2.setA(a2);
//		
		
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		System.out.println(e1.getFname()+","+e1.getA().getCity());
		System.out.println(e2.getFname()+","+e2.getA().getCity());
//        e1.Employee();

	}

}
