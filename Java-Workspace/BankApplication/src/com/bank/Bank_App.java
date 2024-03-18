package com.bank;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Bank_App {
	static int customerCount = 0;

	static ArrayList<Customer> customers = new ArrayList<>();
	static ArrayList<Account> accounts = new ArrayList<>();

	public static void displayMenu() {
		System.out.println("\n1. Create New Customer Data");
		System.out.println("2. Assign a Bank Account to a Customer");
		System.out.println("3. Display balance or interest earned of a Customer");
		System.out.println("4. Sort Customer Data");
		System.out.println("5. Persist Customer Data");
		System.out.println("6. Show All Customers");
		System.out.println("7. Search Customers by Name");
		System.out.println("8. Exit");
	}

	private static void createNewCustomer() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter customer name: ");
		String name = sc.nextLine();
		System.out.print("Enter customer age: ");
		int age = sc.nextInt();
		System.out.print("Enter mobile number: ");
		int mobileNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter passport number: ");
		String passportNumber = sc.nextLine();
		System.out.print("Enter DOB (DD/MM/YYYY): ");
		String dob = sc.next();

		Customer customer = new Customer(name, age, mobileNumber, passportNumber, dob);
		customers.add(customer);
		System.out.println("Your Customer ID is " + customer.getCustomid());
		DatabaseConnection.insertCustomer(customer);

	}

	private static void assignBankAccount() throws InsufficientBalanceException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Customer ID to whom a new Bank Account will be assigned: ");
		int customerId = sc.nextInt();
		Customer customer = findCustomerById(customerId);

		if (customer != null) {
			System.out.print("Enter Account Number: ");
			long accountNumber = sc.nextLong();
			System.out.print("Enter BSB Code: ");
			long bsbCode = sc.nextLong();
			sc.nextLine(); // Consume the newline character
			System.out.print("Enter Bank Name: ");
			String bankName = sc.nextLine();
			System.out.print("Enter Balance: ");
			double balance = sc.nextDouble();
			sc.nextLine(); // Consume the newline character
			System.out.print("Enter Opening Date (DD/MM/YYYY): ");
			String openingDate = sc.nextLine();

			System.out.println("Choose Account Type:\n1. Savings Account\n2. Fixed Deposit Account");
			int accountTypeChoice = sc.nextInt();
			sc.nextLine(); // Consume the newline character
            
			Account account;
			if (accountTypeChoice == 1) {
				System.out.print("Is Salary Account? (true/false): ");
				boolean isSalaryAccount = sc.nextBoolean();

				if (!isSalaryAccount && balance < 100) {
					throw new InsufficientBalanceException(
							"Insufficient balance for Savings Account, Minimum balance should be $100");
				}

				// Create Savings Account
				account = new SavingsAccount(accountNumber, bsbCode, bankName, balance, getCurrentDate(),
						isSalaryAccount);
				customer.setAccount(account);
				accounts.add(account);

				createSavingsAccount((SavingsAccount)account);

				// option for creating fixed deposit account
			} else if (accountTypeChoice == 2) {
				System.out.print("Enter Deposit Amount (min 1000 ): ");
				double depositAmount = sc.nextDouble();
				System.out.print("Enter Tenure (in years, min 1, max 7): ");
				int tenure = sc.nextInt();
				 account = new FixedDepositAccount(accountNumber, bsbCode, bankName, balance, openingDate,
						depositAmount, tenure);
				customer.setAccount(account);
				accounts.add(account);
				DatabaseConnection.insertAccount(account,customerId);
			} else {
				System.out.println("Invalid account type choice.");
			}
		} else {
			try {
				throw new CustomerNotFoundException("Customer not found.");
			} catch (CustomerNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		

		
	}

	private static void createSavingsAccount(SavingsAccount savingsAccount) throws InsufficientBalanceException {
		Scanner sc = new Scanner(System.in);
		// options to deposit withdraw and check balance for customer's savings account
		int choice;
		do {
			System.out.println("Choose Action:\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Back to Main Menu");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();
				savingsAccount.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter withdrawal amount: ");
				double withdrawalAmount = sc.nextDouble();
				savingsAccount.withdraw(withdrawalAmount);
				break;
			case 3:
				savingsAccount.checkBalance();
				break;
			case 4:
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 4);
	}



	private static Customer findCustomerById(int customerId) {
		for (Customer customer : customers) {
			if (customer.getCustomid() == customerId) {
				return customer;
			}
		}
		return null; // Customer not found

	}
	private static String getCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(new Date());
	}

	private static void handleCustomerNotFoundException() {
		try {
			throw new CustomerNotFoundException("Customer not found.");
		} catch (CustomerNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void displayBalanceandInterest() {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the customer id to know the interest");
      int id=sc.nextInt();
      for(Customer customer:customers) {
    	  if(id==customer.getCustomid()) {
    		  if(customer.getAccount() != null) {
        		  customer.getAccount().calculateInterest();
        		  System.out.println("Total Interest earned by user is " +customer.getAccount().getInterestEarned());
    		  }
    	  }
      }
	}

	private static void sortCustomer() {
		System.out.println("sorting should be done on names or ids? \n1:names 2:ids 3:balance");
		int choice;
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			Collections.sort(customers, Comparator.comparing(Customer::getName));
			break;
		case 2:
			Collections.sort(customers, Comparator.comparingInt(Customer::getCustomid));
			break;
		case 3:
			Collections.sort(customers,Comparator.comparingDouble(c->c.getAccount().getBalance()));

		default:
			System.out.println("invalid choice");
		}
		System.out.println("Sorted Customers:");
		for (Customer customer : customers) {
			System.out.println(customer);
		}

	}

	private static void persistCustomer() {
		Idao storage = chooseStorageType();

	    if (storage != null) {
	        storage.saveAllCustomers(customers);
	    }

	}

	private static Idao chooseStorageType() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose Storage Type:\n1. File System\n2. Relational Database (RDBMS)");
	    int storageChoice = sc.nextInt();
	    sc.nextLine(); // Consume the newline character

	    switch (storageChoice) {
	        case 1:
	            return new FileStorageDao();
	        case 2:
	            DatabaseConnection.displayCustomerDetails();
	            break;
	        default:
	            System.out.println("Invalid storage type choice.");
	    }



		return null;
	}

	private static void showAllCustomers() {
		for (Customer customer : customers) {
			System.out.println(customer);

		}
//		for (Account account : accounts) {
//			System.out.println(account);
//		}
	}

	private static void searchByName() throws CustomerNotFoundException {
      System.out.println("Enter the name of the customer to be searched");
      Scanner sc=new Scanner(System.in);
      String name=sc.nextLine();
      for (Customer customer : customers) {
    	  if (customer.getName() == name) {
			System.out.println(customer);
		}
    	  else {
    		  try {
    				throw new CustomerNotFoundException("Customer not found.");
    			} catch (CustomerNotFoundException e) {
    				System.out.println("Error: " + e.getMessage());
    			}

    	  }
	}
	}

	public static void main(String[] args) {
//		displayMenu();
		Scanner sc = new Scanner(System.in);
		int choice;
		Connection connection = DatabaseConnection.getConnection();
		

		do {
			displayMenu();
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				createNewCustomer();
				break;
			}
			case 2: {
				try {
					assignBankAccount();
				} catch (InsufficientBalanceException e) {
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				displayBalanceandInterest();
				break;
			}
			case 4: {
				sortCustomer();
				break;
			}
			case 5: {
				persistCustomer();
				break;
			}
			case 6: {
				showAllCustomers();
				break;
			}
			case 7: {
				try {
					searchByName();
				} catch (CustomerNotFoundException e) {

					e.printStackTrace();
				}
				break;
			}
			case 8: {
				System.out.println("exiting the program");
				break;
			}
			default: {
				System.out.println("invalid choice");
				break;
			}
			}

		} while (choice != 8);
		//DatabaseConnection.getDataSource().closeConnection();
	}
}
