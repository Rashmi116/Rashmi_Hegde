package com.wiley.innerclass;

public class RegularInnerDemo {
	private int x=7;
	
	public class Inner{
		public void method1() {
			System.out.println("access to private variable of x outer class in inner class "+x);
		}
	}
	

	public static void main(String[] args) {
		RegularInnerDemo demo1=new RegularInnerDemo();
		Inner in=demo1.new Inner();
		in.method1();

	}

}
