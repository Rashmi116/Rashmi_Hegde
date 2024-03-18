package com.practice;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StringBuilder build=new StringBuilder("rashmi");
        String name="pqp";
        name.split("");
        String str="";
        for(int i=name.length()-1;i>0;i--) {
        	str=str+name.charAt(i);
        }
        if(str.equals(name)) {
        	System.out.println("palindrome");
        }
	}

}
