package com.wiley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@FunctionalInterface
interface Greetable {
	String greet(String name);
	//String greet2(String name);
	
}

interface Addable{
	
	int add(int a,int b); 
}

class AddableImpl implements Addable{

	@Override
	public int add(int a, int b) {
		
		return a+b;
	}
	
}

class GreetableImpl implements Greetable{

	@Override
	public String greet(String name) {
		System.out.println("inside child class");
		return "welcome "+name;
	}
	
}

class Student implements Comparable<Student>{
	private int rollno;
	private String name;
	
	public Student(int rollno,String name){
		this.rollno=rollno;
		this.name=name;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
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

	@Override
	public int compareTo(Student s) {
		if(this.rollno<s.rollno) {
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

public class LambdaDemo {
	
	public void useLambdaForLoop() {
		List<String> list=new ArrayList<>();
		list.add("rashmi");
		list.add("rashi");
		list.add("kriti");
		list.add("manavi");
		Consumer<String> c1=new Consumer<>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
				
			}
			
		};
		list.forEach(( t)->System.out.println("hello" +t));//lamda
		
		
	}
	
	public void useLamdaThread() {
		Runnable r1=new Runnable() {

			@Override
			public void run() {
				
				
			}
			
		};
		
		//Runnable r2=()->System.out.println("thread is started");
		Thread t=new Thread(()->System.out.println("thread is started"));
		t.start();
	}
	
	
	public void useLambdaInCollection() {
		List<Student> list=new ArrayList<>();
		list.add(new Student(10,"rashmi"));
		list.add(new Student(11,"adam"));
		list.add(new Student(5,"gary"));
		Comparator<Student> com1=new Comparator<>() {

			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
				
			}
			
		};
		Consumer<Student> con1=new Consumer<>() {

			@Override
			public void accept(Student t) {
				System.out.println(t);
				
			}
			
		};
		
		Collections.sort(list,com1);
		list.forEach(con1);
		 System.out.println("=============lamda==============");
		 
		 Collections.sort(list,( s1, s2)-> s1.getName().compareTo(s2.getName()));
		 list.forEach((Student t)->System.out.println(t));
		 
		 System.out.println("=============Reversed==============");
		 Collections.sort(list,com1.reversed());
		 list.forEach((Student t)->System.out.println(t));
		 
		 System.out.println("=============Reverse order==============");
		 
		 Comparator<Student> com2=(Comparator<Student>) Comparator.reverseOrder();
		 Collections.sort(list,com2);
		 list.forEach((Student t)->System.out.println(t));
		 
		 System.out.println("=============stream==============");
		 
		 Stream<Student> s1=list.stream().filter(s->s.getRollno()>5);
		 System.out.println(s1.count());
	}
	
	public void doBinaryOperations() {
		BinaryOperator<Integer> b1=new BinaryOperator<>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				
				return t+u;
			}
			
		};
		BinaryOperator<Integer> b2=(t,u)->t+u;
		List<Integer> numbers = Arrays.asList(20, 10);
		int result1 = performBinaryOp(numbers,(i,j)->i+j);
		int result2 = performBinaryOp(numbers,(i,j)->i-j);
		System.out.println(result1);
		System.out.println(result2);
		
	}
	
	private int performBinaryOp(List<Integer> numbers,BinaryOperator<Integer> bin) {
		return bin.apply( numbers.get(0), numbers.get(1) );
	}
	
	
	public void doBehaviourPassing() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int result1=sumAll(numbers);
		int result2=sumEven(numbers);
		System.out.println(result2);
		System.out.println(result1);
		
		Predicate<Integer> p=new Predicate<>() {
            @Override
			public boolean test(Integer t) {
				if(t%2==0) {
				return true;
			}
			else {
				return false;
			}
            }
			
		};
		System.out.println(sumAll(numbers,(t)->t%2==0));
		System.out.println(sumAll(numbers,(t)->true));
		System.out.println(sumAll(numbers,(t)->t>3));
		
		
	}
	private int sumEven(List<Integer> numbers) {
		int total=0;
		for(int num:numbers) {
			if(num%2==0) {
				total+=num;
			}
		}
		return total;
	}
	
	private int sumAll(List<Integer> numbers) {
		int total=0;
		for(int num:numbers) {
			total+=num;
		}
		
		
		return total;
		
	}
	
	private int sumAll(List<Integer> numbers,Predicate<Integer> p){
		
		int total=0;
		for(int num:numbers) {
			if(p.test(num)) {
				total+=num;
			}
			
		}
		return total;
	
		
	}

	public static void main(String[] args) {
		
		Greetable gt1=new GreetableImpl();
		System.out.println(gt1.greet("rashmi"));
		
		//we r nt creting object of interface
		Greetable gt2=new Greetable() {

			@Override
			public String greet(String name) {
				System.out.println("inside anonymous inner class");
				return "welcome from anonymous class"+" "+name;
			}
			
		};
		   
		   System.out.println(gt2.greet("rashi"));
		   
		   //lambda
		   Greetable gt3=( name)-> "welcome from lambda expr"+" "+name;
			   
		  
		   System.out.println(gt3.greet("ram"));
		   System.out.println("===========================");
		   
		   Addable add1=new AddableImpl(); 
		   System.out.println(add1.add(3, 4));
		   
		   Addable add2=new Addable() {

			@Override
			public int add(int a, int b) {
				
				return a+b;
			}
			   
		   };
		   System.out.println(add2.add(4, 6));
		   
		   Addable add3=(x,y)->x+y;
		   
		   System.out.println(add3.add(6, 8));
		   
		   System.out.println("=============");
		   
		   LambdaDemo demo=new LambdaDemo();
		   demo.useLambdaForLoop();
		   demo.useLamdaThread();
		   System.out.println("=============");
		   demo.useLambdaInCollection();
		   demo.doBehaviourPassing();
		   demo.doBinaryOperations();
		   

	}//end of main

}//end of class

//External Iteration   // The responsibility of iterating over the elements and making sure that  //all elements are iterated lies on Programmer.  //In enhanced for loop also, managing the iterations still remains the programmer’s job
//Internal Iteration
//Manage the iterations in the back ground and 
//Programmer needs to just declaratively code what is to be done with elements
//Programmer will not make sure whether all elements are processed one-by-one
//Improved code readability as its declarative in nature.
//Concise code as multiple lines of code for external iterators is reduced to just one or two lines //less defects as code written by programmer is very less, no iteration code written by programmer