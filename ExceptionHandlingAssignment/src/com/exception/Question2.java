package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Question2 {
	
	static void ex2() throws DuplicateElementException {
		try {
			Set<Integer> list=new TreeSet<>();
			list.add(2);
			list.add(3);
			list.add(2);
			for(int num:list) {
			if(!list.add(num)) {
				throw new DuplicateElementException();
			}
			}
		}catch(DuplicateElementException e) {
			e.printStackTrace();
		}

	}
	
	//Question 3
	
	static void input(String str) throws NoVowelException {
		try {
			if(!str.matches(".*[aeiouAEIOU].*")) {
				throw new NoVowelException();
			}
		}catch(NoVowelException e) {
			e.printStackTrace();
		}
	}
	
	//Question 4
	static void fileNotFoundExample() {
		try {
			FileInputStream file=new FileInputStream("D:\\C376\\abc.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found");
			e.printStackTrace();
		}
	}
	
	//Question 5
	static void divideExample() {
	try {
		
		int r=10/0;
		
	}
	
	catch(ArithmeticException | NullPointerException e) {
		System.out.println("dont divide by 0");
	}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ex2();
		} catch (DuplicateElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			input("ho");
		} catch (NoVowelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fileNotFoundExample();
		divideExample();
		
	}

}
class DuplicateElementException extends Exception{
	public void DuplicateElementException(String message) {
		System.out.println("duplicates");
		}
}

class NoVowelException extends Exception{
	public void NoVowelException(String message) {
		System.out.println("no vowel is present");
		}
}
