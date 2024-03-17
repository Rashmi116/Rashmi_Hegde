package com.edge.io;

import java.util.Scanner;

public class Scanner_Demo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("name ");
			String name=sc.nextLine();
			if(name.isEmpty()) {
				break;
			}
			System.out.println("welcome "+name);
			}
		sc.close();
			
	}

}
