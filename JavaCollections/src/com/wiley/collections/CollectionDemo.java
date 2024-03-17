package com.wiley.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Student implements Comparable<Student>{
	private int rollno;
	private String name;

	public Student() {

	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		System.out.println("inside hashcode");
		return this.rollno;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("inside equals");
		if (obj instanceof Student) {
			Student s = (Student) obj;
			if (this.rollno == s.rollno && this.name.equals(s.name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		System.out.println("inside compare to");
		if( this.rollno<s.rollno) {
			return -1;
		}
		else if(this.rollno>s.rollno) {
			return 1;
		}
		else {
			return 0;
		}
	}
	}





	/*public int compareTo(Student s) {
		System.out.println("inside compare to");
		if( this.rollno<s.rollno) {
			return 1;
		}
		else if(this.rollno>s.rollno) {
			return 0;
		}
		else {
			return -1;
		}
	}*/

class ScienceStudent extends Student{



}
class EngineeringStudent extends ScienceStudent{

}
class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		return(s2.getName().compareTo(s1.getName()));


	}



}
public class CollectionDemo {

	public void testSets() {
		Set<? super Student> set=new TreeSet<>(new StudentComparator()); //set of something whose super is student
		set.add(new ScienceStudent());
		set.add(new EngineeringStudent());
		//Set set = new TreeSet();
		// set.add(3);
		// set.add("hello");
		// set.add(1234);
		// set.add(3);

		Student s1 = new Student(11, "adam");
		Student s2 = new Student(12, "bobin");
		Student s3 = new Student(1, "harry");
		Student s4 = new Student(0, "adam");
		Student s5 = new Student(45, "adamo");
		Student s6 = new Student(101, "adami");
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		set.add(s5);
		set.add(s6);

		for (Object obj : set) {
			System.out.println(obj);
		}
	}

	public void testLists() {
	   List<Object> list=new ArrayList<>();
		// List list=new LinkedList();//ordered unsorted allowing duplicates
		//List list = new Vector();
		list.add("rashmi");
		list.add("kim");
		list.add("abc");
		list.add("hi");
		list.add("pqr");
		for (Object element : list) {
			System.out.println(element);
		}
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
	public void testMaps() {
		//Map<Integer,String> map=new HashMap<>();
		//Map map=new Hashtable();
		Comparator<Student> comparator=new StudentComparator();
		Map<Student,Integer> map=new TreeMap<>(comparator);

		Student s1 = new Student(11, "adam");
		Student s2 = new Student(12, "bobin");
		Student s3 = new Student(13, "harry");
		Student s4 = new Student(10, "adam");

		map.put(s1, 11);
		map.put(s2, 12);
		map.put(s3, 13);
		map.put(s4, 10);

		Set<Student> set=map.keySet();

		for (Student key : set) {
			Integer value=map.get(key);
			System.out.println(key+" "+value);
		}

	}

	public static void main(String[] args) {
		CollectionDemo demo = new CollectionDemo();
		//demo.testLists();
		//demo.testSets();
		demo.testMaps();

	}

}
