package com.exception;

public class JavaExceptionAssign {
	
	public void method1(int a) throws oddNumberException {
		try {
			if(a%2!=0) {
				throw new oddNumberException();
			}
		}catch(ArithmeticException e) {
			System.out.println("odd no");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaExceptionAssign ex1=new JavaExceptionAssign();
		try {
			ex1.method1(3);
		} catch (oddNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class oddNumberException extends Exception{
	public void OddNumberException(String message) {
        System.out.println("odd number exception");
    }
}
