package com.str.utility;

public class StringDemo {

	public static void main(String[] args) {
		String s1="hello";
		String s2=new String("hello");
		if(s1==s2) {
			System.out.println("both are pointing to same memory location");
		}
		else {
			System.out.println("both are pointing to diffrent memory location");
		}
		if(s1.equals(s2)) {
			System.out.println("both are equal");
		}
		else {
			System.out.println("both are diffrent");
		}
		String s3=s1.concat("world");
		System.out.println(s3);
		System.out.println(s3.substring(0,3));
		System.out.println(s3.indexOf("lo"));
		System.out.println(s3.lastIndexOf('h'));
		String[] str=s3.split("ll");
		for(String s:str) {
			System.out.println(s+"");

		}
		System.out.println(s3.startsWith("hell"));
		System.out.println(s3.toUpperCase());
		System.out.println(s3.toLowerCase());
		System.out.println(s3.replace("l", "p"));

	}

}
