package com.string;

public class Stringassign {
	
	public static void reversed(String inp) {
		StringBuilder reversed=new StringBuilder(inp).reverse();
		StringBuilder res=new StringBuilder();
		for(int i=0;i<reversed.length();i++) {
			res.append(reversed.charAt(i));
			if(i<reversed.length()-1)
			{
				res.append("-");
			}
			
		}
		System.out.println(res);
		
	}
	public static void removeX(String inp) {
		StringBuilder removex=new StringBuilder();
		StringBuilder appendx=new StringBuilder();
		for(int i=0;i<inp.length();i++) {
			if(inp.charAt(i)!='x') {
				removex.append(inp.charAt(i));
			}
			else {
				appendx.append(inp.charAt(i));
			}
		}
		removex.append(appendx);
		System.out.println(removex);
		
	}
	
	public static void replacefirstLast(String inp) {
		if(inp.length()<2) {
			System.out.println( inp);
		}
		StringBuilder res=new StringBuilder(inp);
		char firstChar=inp.charAt(0);
		char lastChar=inp.charAt(inp.length()-1);
		res.setCharAt(0, lastChar);
		res.setCharAt(inp.length()-1, firstChar);
		System.out.println(res);
	}
	public static void maxSubString(String inp) {
		String[] words=inp.split("//s+");
		String maxLength=" ";
		for(String word:words) {
			if(word.length()>maxLength.length()) {
				maxLength=word;
			}
			System.out.println(maxLength);
		}
		
	}
	
	//5th question
	public static void getSubstringFromWords(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");

        for (String word : words) {
            result.append(word.charAt(0));
        }

        System.out.println(result.toString());
    }

    
    public static void getSubstringFromEachWord(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            if (i < words[i].length()) {
                result.append(Character.toUpperCase(words[i].charAt(i)));
            }
        }

        System.out.println(result.toString());
    }
    public static void getNextCharacter(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if the character is a letter
            if (Character.isLetter(currentChar)) {
                // Check if it's lowercase or uppercase
                char nextChar = (char) (Character.isLowerCase(currentChar) ?
                                       ((currentChar - 'a' + 1) % 26 + 'a') :
                                       ((currentChar - 'A' + 1) % 26 + 'A'));
                result.append(nextChar);
            } else {
                // Non-letter characters remain unchanged
                result.append(currentChar);
            }
        }

        System.out.println(result.toString());
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
          
           reversed("computer");
           removeX("guhxxXg");
           replacefirstLast("hello");
           maxSubString("hi how are you Rashmi");
           getSubstringFromEachWord("hi how are");
           getNextCharacter("hello");
	}
	
}
