package com.wileyedge.singletable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity(name="empl4")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "emptype")
public class Employe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "firstname")
	private String fname;
	
	@Column(name = "lastname")
	private String lname;
	
	

	public Employe() {
		super();
	}



	public Employe(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFname() {
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
