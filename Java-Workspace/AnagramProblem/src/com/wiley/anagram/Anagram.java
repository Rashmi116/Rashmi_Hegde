package com.wiley.anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Anagram {
	public static boolean is_anagram(String s1,String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s1.length();i++) {
			if(map.containsKey(s1.charAt(i))) {
				map.put(s1.charAt(i),map.get( s1.charAt(i))+1);
			}
			else {
				map.put(s1.charAt(i), 1);
			}
		}
		for(int i=0;i<s2.length();i++) {
			if(map.containsKey(s2.charAt(i))) {
				map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
			}
			else {
				return false;
			}
		}
		Set<Character> keys=map.keySet();
		for(Character key:keys) {
			if(map.get(key)!=0) {
				return false;
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String s1="listen";
         String s2="silent";
         
         if(is_anagram(s2, s1)) {
        	 System.out.println("two strings are equal");
         }
         else {
        	 System.out.println("two strings are not equal");
         }
	}

}
