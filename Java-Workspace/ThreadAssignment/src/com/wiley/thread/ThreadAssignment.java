package com.wiley.thread;

class Demo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("hello world");
	}
	
}

class Even implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
		
	}
	
}
class Odd implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			if(i%2!=0) {
				System.out.println(i);
			}
		}
		
	}
	
}

public class ThreadAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo d=new Demo();
		Thread t1=new Thread(d);
		t1.start();
		Even e=new Even();
		Odd o=new Odd();
		Thread t2=new Thread(e);
		Thread t3=new Thread(o);
		t2.start();
		t3.start();

	}

}
