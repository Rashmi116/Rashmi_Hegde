package com.wiley.bs;

public class BinarySearch {
	
	public static int binarySearch(int[] arr,int value) {
		int low=0;
		int high=arr.length-1;
		while(high>low) {
			int mid=(high+low)/2;
			if(value<arr[mid]) {
				high=mid-1;
			}
			else if(value>arr[mid]) {
				low=low+1;
			}
			else {
				return mid;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,5,7,8};
		System.out.println(binarySearch(arr,7));

	}

}
