package com.wiley.sort;

public class SelectionSort {
	
	public void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public void selection(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min=i;
		    for(int j=i+1;j<arr.length;j++) {
		    	if(arr[j]<arr[min]) {
		    		min=j;
		    		
		    	}
		    	
		    	int temp=arr[min];
		    	arr[min]=arr[i];
		    	arr[i]=temp;
		    }//end of inner for loop
		    printArray(arr);
		    System.out.print("\n");
		}//end of outer for loop
		System.out.println("The final array is");
		printArray(arr);
	}
	
	

	public static void main(String[] args) {
		SelectionSort sort=new SelectionSort();
		int[] arr= {9,3,7,5,2};
		System.out.println("original array is");
		sort.printArray(arr);
		System.out.println("\n");
		sort.selection(arr);

	}

}
