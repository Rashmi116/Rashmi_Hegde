package com.exp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JavaExceptionDemo {
	
	public void method1(int a) {
		method2();
		System.out.println("entering method1");
		try {
			System.out.println("going divide ");
			int r=10/a;
			System.out.println("divided");
		}
		
		catch(ArithmeticException | NullPointerException e) {
			System.out.println("dont divide by 0");
		}
		 catch(Exception e) {
				
			}
		finally {
			System.out.println("It gets excecuted always");
		}
		
		
        System.out.println("exiting method1");
	}

	public void method2() {
		System.out.println("entering method2");
		try {
			FileInputStream file=new FileInputStream("D:\\C376\\abc.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e.printStackTrace();
		}
		System.out.println("exiting method2");
	}
	public void method3() {
		System.out.println("inside method 3");
		BankAccount acc=new BankAccount();
		try {
			acc.withdraw(200);
		} catch (InsufficientFundsException e) {
			// TODO Auto-generated catch block
			System.out.println("try to remove lesser amt");
			e.printStackTrace();
		}
		
		System.out.println("exiting method 3");
		
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("entering main");
        JavaExceptionDemo demo=new JavaExceptionDemo();
        demo.method1(2);
        demo.method3();
        
        System.out.println("exiting main");
	}

}
