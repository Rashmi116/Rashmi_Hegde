/*package com.wiley.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DateFormat.Field;

class Person{
	public String fname;
	public String lname;
	
	public Person() {
		
	}
	public Person(String fname,String lname) {
		this.fname=fname;
		this.lname=lname;
	}
	
	public String desc() {
		return "information about the person";
	}
}

public class ReflectionDemo {

	public static void main(String[] args) {
		Person p=new Person();
		Class cls=p.getClass();
		Constructor[] arr=cls.getConstructors();
		for(Constructor c:arr) {
			System.out.println(c);
		}
		Method[] marray=cls.getMethods();
		for(Method m:marray) {
			System.out.println(m.getName());
		}
		Field[] fld=cls.getFields();
		for(Field f:fld) {
			System.out.println(f);
		}

	}

}*/
