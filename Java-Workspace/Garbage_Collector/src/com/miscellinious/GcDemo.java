package com.miscellinious;

class Employee{

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("getting removed from the cleanup");
		}
	
public void doCoding() {
	System.out.println("coding");
	
}
}

public class GcDemo {
	
	public void doWork() {
		Employee e1=new Employee();
		e1.doCoding();
		e1=null;
			
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GcDemo demo=new GcDemo();
		demo.doWork();
		System.gc();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


