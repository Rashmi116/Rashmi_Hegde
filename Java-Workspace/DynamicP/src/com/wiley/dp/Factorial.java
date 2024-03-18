package com.wiley.dp;

public class Factorial {
	static int[] mem;
	
	//using recursion
	public static int factRecursion(int n) {
		if(n==1||n==0) {
			 return 1;
		}
		return n*factRecursion(n-1);
		
	}
	//using memoization
	public static int factMem(int n) {
		int res=0;
		if(mem[n]!=0) {
			return mem[n];
		}
		else {
			if(n==1||n==0) {
				 res=1;
			}
			else {
				res=n*factMem(n-1);
				mem[n]=res;
			}
			return res;
		}
	}
	
	//using tabulation
	public static int factTab(int n) {
		int mem[]=new int[n+1];
		int i;
		mem[0]=1;
		if(n>0) {
			mem[1]=1;
			for(i=2;i<=n;i++) {
				mem[i]=i*mem[i-1];
			}
			
		}
		return mem[n];		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		mem=new int[n+1];
		//System.out.println(factRecursion(2));
		//System.out.println(factMem(n));
		System.out.println(factTab(n));


	}

}
