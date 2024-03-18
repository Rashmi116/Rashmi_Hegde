package com.edge.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DeserializationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		BufferedInputStream bfs = null;
		ObjectInputStream oos = null;
		try {
			fis = new FileInputStream("D:\\C376\\student.ser");
			bfs=new BufferedInputStream(fis);
			oos=new ObjectInputStream(bfs);
			Object obj=oos.readObject();
			if(obj instanceof Student) {
				Student s=(Student)obj;
				System.out.println(s);
			}
			 System.out.println("Customer data retrieved from file.");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
