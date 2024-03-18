package com.wiley;

/*
We use enums to define a set of predefined, related constants
We use enums to define a set of predefined, related constants

*/

enum Gender{
	Male,Female;
}

enum MathOperator{
	PLUS, MINUS, MULTIPLY, DIVIDE;
}
enum Days{
	Monday(100),Tuesday(101),Wednesday(102),Thursday(103),Friday(104),Saturday(105),Sunday(106);int n;
	Days(int x){
		n=x;
	}
	public int getValue() {
		return n;
	}
}
public class EnumDemo {

	public static void main(String[] args) {
		System.out.println(Gender.Male);
		System.out.println(calculate(MathOperator.PLUS,5,3));
		System.out.println(calculate(MathOperator.MINUS,5,3));
		System.out.println(calculate(MathOperator.MULTIPLY,5,3));
		System.out.println(calculate(MathOperator.DIVIDE,5,3));
		
		Days aday = Days.Friday;
		switch(aday) {
		case Monday:System.out.println("boring");break;
		
		case Tuesday:System.out.println("not so boring");break;
		case Friday:System.out.println("weekend");break;
		}
		Days d=Days.Monday;
		switch(d.getValue()) {
         case 100:System.out.println("boring");break;
		 case 101:System.out.println("not so boring");break;
		 case 104:System.out.println("weekend");break;
		}
		}

	
	public static int calculate(MathOperator op,int num1,int num2) {
		
		switch(op){
		case PLUS:return num1+num2;
		case MINUS:return num1-num2;
		case DIVIDE:return num1/num2;
		case MULTIPLY:return num1*num2;
		default:
			throw new UnsupportedOperationException();
		}
	}

}


