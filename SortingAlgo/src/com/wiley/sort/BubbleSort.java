package com.wiley.sort;

public class BubbleSort {
	
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
		BubbleSort sort=new BubbleSort();
		int[] arr= {9,3,7,5,2};
		System.out.println("original array is");
		sort.printArray(arr);
		System.out.println("\n");
		sort.bubble(arr);

	}

}
