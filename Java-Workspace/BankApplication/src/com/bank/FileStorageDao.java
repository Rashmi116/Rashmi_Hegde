package com.bank;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileStorageDao implements Idao, Serializable {

	@Override
	public void saveAllCustomers(List<Customer> customers) {
		File fs=new File("D:\\C376\\Customer.txt");
		FileOutputStream fos=null;
		BufferedOutputStream bfs = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fs);
			oos = new ObjectOutputStream(fos);
			bfs = new BufferedOutputStream(fos);
			oos.writeObject(customers.toString());
			System.out.println("Customer data saved to file.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error saving customer data to file: " + e.getMessage());
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		
	}

	@Override
	public List<Customer> retrieveAllCustomers() {
     List<Customer> customers = new ArrayList<>();
     FileInputStream fis = null;
	 BufferedInputStream bfs = null;
	 ObjectInputStream oos = null;
	 try {
		fis = new FileInputStream("D:\\C376\\Customer.txt");
		bfs=new BufferedInputStream(fis);
		oos=new ObjectInputStream(bfs);
		Object obj=oos.readObject();
		
		if(obj instanceof List) {
			customers = (List<Customer>) obj;
		}
		System.out.println(customers);		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Error retrieving customer data from file: " + e.getMessage());
	}
		return customers;
	}

}

