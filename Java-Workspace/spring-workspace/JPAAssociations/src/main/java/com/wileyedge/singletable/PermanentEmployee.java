package com.wileyedge.singletable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "p")
public class PermanentEmployee extends Employe {
	private int pfAccountNumber;
	
	public PermanentEmployee(int pfAccountNumber) {
		super();
		this.pfAccountNumber = pfAccountNumber;
	}

	public int getPfAccountNumber() {
		return pfAccountNumber;
	}

	public void setPfAccountNumber(int pfAccountNumber) {
		this.pfAccountNumber = pfAccountNumber;
	}
	
	public PermanentEmployee(String fname, String lname,int pfAccountNumber) {
		super(fname,lname);
		this.pfAccountNumber=pfAccountNumber;
	}
	
}
