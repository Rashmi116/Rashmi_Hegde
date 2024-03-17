package com.miscellinious;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatching {
	
	public static boolean validate(String password) {
		if(password==null) {
			return false;
		}
		
		String pass="^(?=.*[a-zA-Z$%^&*@])(?=.*[0-9$%^&*@]).{5,}$";
		Pattern p=Pattern.compile(pass);
		
		Matcher m=p.matcher(password);
		
		boolean b=m.matches();
		return b;
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validate("rashmi$%^&*"));
		System.out.println(validate("rashmi"));
		System.out.println(validate("ras%"));

	}

}
