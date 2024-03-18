package com.emp.utility;

public class Address {
   public String country;
   public String city;
   private  int zip;
   
   public Address() {
	   System.out.println("Object of Employee is being created");

   }
   public Address(String country,String city,int zip) {
	   this.country=country;
	   this.city=city;
	   this.zip=zip;
	   System.out.println("Object of Employee is being created");

	   
   }
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getZip() {
	return zip;
}
public void setZip(int zip) {
	this.zip = zip;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return this.country+ " "+this.city+" "+this.zip;
}
   
   
}