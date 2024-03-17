package com.parampassing;

class Num{
	public int n;
}

public class ParameterPassingDemo {
	public void modify(int n) {
		System.out.println("inside modify(int) method");
		n=10;
		System.out.println("exiting modify(int) method "+n);
		
	}
	
	public void modify(Num num) {
		System.out.println("inside modify(Num) method");
		num.n=10;
		System.out.println("exiting modify(Num) method "+num.n);
	}
	
	public void modify(String str) {
		System.out.println("inside modify(String) method");
		str="10";
		System.out.println("exiting modify(String) method "+str);
		
	}
	
	public static void main(String[] args) {
		ParameterPassingDemo par=new ParameterPassingDemo();
		System.out.println("inside main method");
		int n=5;
		System.out.println("Before invoking modify method "+n);
		par.modify(n);
		System.out.println("after invoking modify method "+n);
		System.out.println("===========================");
		Num num=new Num();
		num.n=5;
		System.out.println("Before invoking modify method "+num.n);
		par.modify(num);
		System.out.println("after invoking modify method "+num.n);
		System.out.println("===========================");
		String str="5";
		System.out.println("Before invoking modify method "+str);
		par.modify(str);
		System.out.println("after invoking modify method "+str);
		
		System.out.println("exiting main method");
		
		
	}

}
