package com.assign.game;

import java.util.Scanner;

public class BeerBottleGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int b=21;
		System.out.println("there are 21 beer bottles ");
		System.out.println("there are two players computer and you ");
		System.out.println("At a time, each one can pick up any no. of bottles between 1 and 4");
		System.out.println("would you like to pick up first ");
		Scanner sc=new Scanner(System.in);
		String ans=sc.nextLine();

			if(ans.equals("yes")) {
				while(true) {
				System.out.println("how many would you like to pick up first ");
				int u=sc.nextInt();
				int c=5-u;
				System.out.println("computer has picked up "+c);
				b=b-(c+u);
				System.out.println("bottles remaining "+b);
				if(b==1) {
					System.out.println("The bottles remaining are : 1");
					System.out.println("loser you have to pic up the last bottle");
					break;
				}

			}

		}


	}

}
