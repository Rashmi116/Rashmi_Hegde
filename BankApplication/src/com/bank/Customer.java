package com.bank;


import java.util.Date;
import java.util.Scanner;

public class Customer {
	private static int nextCustomerId = DatabaseConnection.getNextCustomerId();

	private int customid;
	private String name;
	private int age;
	private int mob_no;
	private String passport_no;
	private Account account;
	private String dob;

	public Customer(String name, int age, int mob_no, String passportNumber, String dob) {
		super();
		this.customid = nextCustomerId++;
		this.name = name;
		this.age = age;
		this.mob_no = mob_no;
		this.passport_no = passportNumber;
		this.dob = dob;
		this.account = null;
	}

	public String toString() {
		String display = "\nCUSTOMER DETAILS\n\nCustomer ID: " + customid + "\nName: " + name + "\nAge: " + age + "\nMobile Number: " + mob_no
		+ "\nPassport Number: " + passport_no + "\nDOB: " + dob + "\n\n";
		if (account != null) {
			display = display + "ACCOUNT DETAILS\n\nAccount Number: " + account.getAccountNumber() + "\nBSB Code: " + account.getBsbCode() + "\nBank Name: " + account.getBankName()
					+ "\nBalance: " + account.getBalance() + "\nOpening Date: " + account.getOpeningDate() + "\nInterest Earned: " + account.getInterestEarned()
					+ "\n";
		}
		return display;
	}

	public int getCustomid() {
		return customid;
	}

	public void setCustomid(int customid) {
		this.customid = customid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMob_no() {
		return mob_no;
	}

	public void setMob_no(int mob_no) {
		this.mob_no = mob_no;
	}

	public String getPassport_no() {
		return passport_no;
	}

	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}

	public String getDob() {
		return dob;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account)
	{
	    this.account=account;
	}

	public void setDob(String dob) {
		// Validate and set Date of Birth
		
			this.dob = dob;
		

	}

	// Method to validate the Date of Birth format
	/*private boolean isValidDate(Date dob2) {
		String[] parts = dob2.split("/");
		if (parts.length == 3) {
			try {
				int day = Integer.parseInt(parts[0]);
				int month = Integer.parseInt(parts[1]);
				int year = Integer.parseInt(parts[2]);

				if ((day > 0 && day < 31) && (month > 0 && month < 12) && year > 0) {
					
					return true;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		return false;
	}*/
}
