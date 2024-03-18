package com.softra.model;

public class Student {
	private String name;
	private int age;
	private String mobno;
	private String address;
	public Student(String name, int age, String mobno, String address) {
		this.name=name;
		this.age=age;
		this.mobno=mobno;
		this.address=address;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
