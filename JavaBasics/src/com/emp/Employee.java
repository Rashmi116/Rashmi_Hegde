package com.emp;

import com.emp.utility.Address;

public class Employee {
   private int id;
   private String fname;
   private String lname;
   private  Address a;//after static it is become the class employee not an instance variable //a is of type Address and and instance variable of class Employee
   public Employee() {
	   System.out.println("Object of Employee is being created");
   }
   public Employee(int id,String fname,String lname) {
	   this.id=id;
	   this.fname=fname;
	   this.lname=lname;
	   System.out.println("Object of Employee is been created using Parametarized constructor");
	   }
   
   public Employee(int id,String fname,String lname,Address a) {
	   this.id=id;
	   this.fname=fname;
	   this.lname=lname;
	   this.a=a;
	   System.out.println("Object of Employee is been created using 4 Parametarized constructor");
	   }
   @Override// make sure whether you are overriding or not
    public String toString() {
	
    	return this.id+""+this.fname+" "+this.lname;
}
public Address getA() {
	return a;
   }

   public void setA(Address a) {
	this.a = a;
   }

public int getId() 
   {
	return id;
   }
   
    public void setId(int id) 
    {
	   this.id = id;
    }
    
    public String getFname() 
    {
	   return fname;
    }
    
    
    public void setFname(String fname) {
	     this.fname = fname;
    }
    
    public String getLname() {
	    return lname;
    }
    
    public void setLname(String lname) {
	    this.lname = lname;
    }
   
   
}