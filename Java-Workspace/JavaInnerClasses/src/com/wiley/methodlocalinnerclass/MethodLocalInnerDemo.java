package com.wiley.methodlocalinnerclass;

public class MethodLocalInnerDemo {
	private int x=10;
	
	public void Outer() {
		int y=7;
		
		class MyInner{
			int z=9;
			public void innerMethod() {
				System.out.println("from method local class can access outer private x "+(x));
				System.out.println("from method local class can access local variable y "+(y));
				System.out.println("from method local class can access inner instance variable z "+(z));
			}//end of inner method
		}//end of inner class
		MyInner mi=new MyInner();
		mi.innerMethod();
	}

	public static void main(String[] args) {
		MethodLocalInnerDemo demo=new MethodLocalInnerDemo();
		demo.Outer();

	}

}
