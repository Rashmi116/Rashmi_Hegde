package com.wiley.staticinnerclass;

public class Outer {
	
	static class Inner{
		public void inner() {
			System.out.println("hi from inner");
		}
		
	}

	public static void main(String[] args) {
		Outer.Inner in =new Outer.Inner();
		in.inner();
		
	}

}
