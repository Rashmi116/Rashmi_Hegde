package com.wileyedge.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class Address {
	@Column(name="city", nullable=false)
	private  String city;
	@Column(name="zip", nullable=false)
	private String zip;
	public Address() {
		System.out.println("inside default constructor of address");
	}
	public Address(String city, String zip) {
		super();
		this.city = city;
		this.zip = zip;
	}
	

}
