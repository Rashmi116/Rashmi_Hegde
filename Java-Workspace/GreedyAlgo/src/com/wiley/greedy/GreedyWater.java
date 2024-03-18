package com.wiley.greedy;

import java.util.Scanner;

public class GreedyWater {
	public void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public void bubble(int[] arr) {
		for(int i=0;i<arr.length;i++) {
		    for(int j=0;j<arr.length-i-1;j++) {
				if (arr[j + 1] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
		        }//end of if
		    }//end of inner for loop
		    printArray(arr);
		    System.out.print("\n");
		
	    }//end of outer for loop
		System.out.println("The final array is");
		printArray(arr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreedyWater w=new GreedyWater();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the test cases");
		int testCase=sc.nextInt();
		while(testCase!=0) {
		System.out.println("enter the total no of bottles and conatiner size");
		int bottle=sc.nextInt();
		int contSize=sc.nextInt();
		System.out.println("enter the bottles  size");
		int[] arr=new int[bottle];
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		w.bubble(arr);
		int sum=0;
		int iter=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			
			if(sum>contSize) {
				break;
			}
			iter++;
		}
		System.out.println("Total no of bottles "+iter);
		testCase--;
		}

	}

}
