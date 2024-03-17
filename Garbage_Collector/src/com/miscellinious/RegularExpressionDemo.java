package com.miscellinious;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemo {

	public static void main(String[] args) {
		//first way
		Pattern p=Pattern.compile("..i.");
		Matcher m=p.matcher("rashmi");
		boolean b=m.matches();
		System.out.println(b);
		
		//second way
		boolean s=Pattern.compile(".s").matcher("as").matches();
		System.out.println(s);
		
		//third way
		boolean k=Pattern.matches(".s", "as");
		System.out.println(k);
		System.out.println("==========================================");
		
		System.out.println(Pattern.matches("[amt]", "ttt"));
		System.out.println(Pattern.matches("[amt]*", "tttt"));
		System.out.println(Pattern.matches("\\d*", "123"));
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "amit41"));
		

	}

}
