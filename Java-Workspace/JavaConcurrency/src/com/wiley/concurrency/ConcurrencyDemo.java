package com.wiley.concurrency;

//class Job extends Thread {
class Job1 extends Thread {
	public void run() {
		method2();
	}

	public void method2() {
		String name = Thread.currentThread().getName();
		for (int j = 1000; j < 2000; j++) {
			System.out.println(name + "= " + j);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class Job2 implements Runnable {

	@Override
	public void run() {
		method1();

	}

	public void method1() {
		String name = Thread.currentThread().getName();
		for (int i = 0; i < 1000; i++) {
			System.out.println(name + "=" + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

public class ConcurrencyDemo {

	public static void main(String[] args) {
		ConcurrencyDemo demo = new ConcurrencyDemo();
		Job1 job1 = new Job1();
		Job2 job2 = new Job2();
		Thread t1 = new Thread(job1);
		Thread t2 = new Thread(job2);
		t1.setName("thread1");
		t2.setName("thread2");
		t1.start();
		t2.start();
		// demo.method1();
		// demo.method2();

	}

}
