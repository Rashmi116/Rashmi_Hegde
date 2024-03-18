package com.wiley.concurrency;

class Education implements Runnable{

	@Override
	public void run() {
		System.out.println("education has started");
		System.out.println("education is going on....");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("education is completed");
	}
	
}

class Marriage implements Runnable{
   private Thread t;
   
   Marriage(Thread t){
	   this.t=t;
   }
	@Override
	public void run() {
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("wedding ceremony started");
		System.out.println("wedding ceremony stopped");
		
	}
	
}

public class JoiningDemo {

	public static void main(String[] args) {
		Education edu=new Education();
		Thread t1=new Thread(edu);
		Marriage m=new Marriage(t1);
		Thread t2=new Thread(m);
		t1.start();
		t2.start();

	}

}
