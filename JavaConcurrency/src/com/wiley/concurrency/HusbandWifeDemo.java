package com.wiley.concurrency;

class JointAccount {
	public int balance = 100;

	public void withdraw(int amt) {
		balance = balance - amt;
	}
}

class Job implements Runnable {
	private JointAccount acct;

	public Job(JointAccount acct) {
		this.acct = acct;
	}

	@Override
	public void run() {

		startWithdrawProcess(75);
		if (acct.balance < 0) {
			System.out.println("big problem");
		}
	}

	public void startWithdrawProcess(int amt) {

		String name = Thread.currentThread().getName();
		System.out.println(name + " has entered inside method startWithdrawProcess() ");
		System.out.println(name + " is checking the balance");

		synchronized (this) {

			if (amt < acct.balance) {
				System.out.println(name + " has checked the balance which is sfficient");
				System.out.println(name + " actual withdrawing");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				acct.withdraw(amt);
				System.out.println(name + " has withdrawn");
			} else {
				System.out.println("there is no sufficient balance");
			}
		}
	}

}

public class HusbandWifeDemo {

	public static void main(String[] args) {
		JointAccount acct = new JointAccount();
		Job job = new Job(acct);
		Thread t1 = new Thread(job);
		Thread t2 = new Thread(job);
		t1.setName("raj");
		t2.setName("priya");
		t2.start();
		t1.start();

	}

}
