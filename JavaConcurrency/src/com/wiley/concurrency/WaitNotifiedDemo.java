package com.wiley.concurrency;



	class Account {
		public int balance = 0;

		public void withdraw(int amt) {
			balance = balance - amt;

		}

		public void deposit(int amt) {
			balance = balance + amt;
		}

	}

	class Depositer implements Runnable {

		private Account acct;

		public Depositer(Account acct) {
			this.acct = acct;

		}

		@Override
		public void run() {
			synchronized(acct) {
			acct.deposit(100);
			acct.notifyAll();
			}
            
		}
	}

		class Withdrawer implements Runnable {
			
			private Account acct;

			public Withdrawer(Account acct) {
				this.acct = acct;
			}

			@Override
			public void run() {
				synchronized(acct) {
					try {
						acct.wait();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				acct.withdraw(100);
				
				}
				if(acct.balance<0) {
					System.out.println("big problem");
				}
				else {
					System.out.println("balance is never negative");
				}
				
			}
		}

	
	public class WaitNotifiedDemo {

	public static void main(String[] args) {
		
		Account a1=new Account();
		Depositer dep=new Depositer(a1);
		Thread t1=new Thread(dep);
		Withdrawer w1=new Withdrawer(a1);
		Thread t2=new Thread(w1);
		t1.setName("Raj");
		t2.setName("radha");
		t1.start();
		t2.start();

	}

}
