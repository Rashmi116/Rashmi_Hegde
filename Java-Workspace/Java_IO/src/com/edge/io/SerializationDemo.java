package com.edge.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address implements Serializable{
	private String country;
	private String city;
	
	
	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + "]";
	}
	public Address(){
		
	}
	public Address(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}
}
class Student implements Serializable {
	private int rollno;
	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	private String name;
	private transient Address addr;

	public Student() {
		System.out.println("default constructor");
	}

	public Student(int rollno, String name) {
		System.out.println("param constructor");
		this.rollno = rollno;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.rollno + " " + this.name+" "+this.addr;
	}
}

public class SerializationDemo {

	public static void main(String[] args) {
		Student s1 = new Student(11, "rashmi");
		Address a1=new Address("India","Banglore");
         s1.setAddr(a1);
		File fs = new File("D:\\C376\\student.txt");
		FileOutputStream fos;
		BufferedOutputStream bfs = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fs);
			bfs = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(s1);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
