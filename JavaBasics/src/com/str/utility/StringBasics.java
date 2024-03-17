package com.str.utility;

public class StringBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="helloworld";
		String reverse="";
		char s;
		for(int i=0;i<s1.length();i++) {
			 s=s1.charAt(i);
			reverse=s+reverse;
		}
		System.out.println(reverse);
		 
		char firstChar = s1.charAt(0);
        char lastChar = s1.charAt(s1.length() - 1);
        String modifiedS1 = lastChar + s1.substring(1, s1.length() - 1) + firstChar;
        System.out.println(modifiedS1);
        
        String s2="hello hi";
        
        String[] s3=s2.split("\\s+");
        String max="";
        for (String word : s3) {
            if (word.length() >= max.length()) {
                max = word;
            }
        }
        System.out.println(max);
        
        
        
    
        

	}

}


/*1) Parse the String in the given format separated with ‘-’
Sample input : computer
Sample output : r-e-t-u-p-m-o-c
2) Remove all small ‘x’ and append at the end of the string
Sample input : abcxXXcxerxxXXwer
Sample output: abcXXcerXXwerxxxx
3) Replace the first and last characters in the given string
Sample input : Hello World
Sample output: dello WorlH
4) Find the substring which is having max length, if two strings lengths are equal 
return the first one.
Sample input 1 : “Hi How are you”
Sample output 1 : How
Sample input 2 : “This is java String program ”
Sample output 2 : program
5) Given input as : “Softra Services Limited”
Output should be like: SSL
6) Given input as : “Softra Services Limited” < first char from 1st word, 2nd char from 
second word, 3rd char from 3rd word etc.>> Output should be in capitals at the end.
Output should be like: SEM */
