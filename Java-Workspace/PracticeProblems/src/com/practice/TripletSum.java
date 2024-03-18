package com.practice;

public class TripletSum {
	public static boolean triplet(int[] arr,int sum) {
		for(int i=0;i<arr.length-2;i++) {
			for(int j=i+1;i<arr.length-1;i++) {
				for(int k=j+1;i<arr.length;i++) {
					if(arr[i]+arr[j]+arr[k]==sum) {
						return true;
					}
				}
			}
		}
		return false;
		
	}
	public static void findTripletWithTwoPointers(int[] arr,int n, int sum) {
		for (int i=0; i<n-1; i++) {
        	// initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r) {
                if (x + arr[l] + arr[r] == sum) {
                    // print elements if it's sum is given sum.
                    System.out.println(x + " " + arr[l] + " "+ arr[r]);
                    l++;
                    r--;
                }
                // If sum of three elements is less than 'sum' then increment in left
                else if (x + arr[l] + arr[r] < sum)
                    l++;
                // if sum is greater than given sum, then decrement in right side
                else
                    r--;
            }	
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, -1, 2, -3, 1};
		int[] arr1 = {0,3,5,7};
		int n = arr.length;
		int sum = -2;
		//System.out.println(triplet(arr,sum));
		//findTripletWithTwoPointers( arr, n,  sum);
		String n2="10";
		String n1="10";
		String s1=new String("rash");
		String s2=new String("rash");
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(n1.equals(n2));
		System.out.println(s1.equals(s2));

	}
	/*
	 2 pointer technique, after sorting the array.
	 Use of a nested loop (one for iterating, other for two-pointer technique) brings 
	 the time complexity to O(n2).	 
	 */

}
