package com.control.assign;

public class WhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=121;
		int rem=0;int sum=0;
		while(num>0) {
			rem=num%10;
			sum=(sum*10)+rem;
			num=num/10;
			
		}
		if(sum==num)
		System.out.println("palindrome");

	}

}
