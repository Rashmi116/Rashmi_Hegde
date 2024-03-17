package com.control.assign;

public class DoWhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=0;int num2=1;
		int num=0;
		do {
			System.out.println(num1);
			int num3=num1+num2;
			num1=num2;
			num2=num3;
			
			num++;
			
		}while(num<10);

	}

}
