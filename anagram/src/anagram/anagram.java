package anagram;

import java.util.Arrays;
import java.util.Scanner;

public class anagram {
	public static void main(String[] args) {
		System.out.println("Enter first string");
		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		char[] char1 = new char[word1.length()];
		char1 = word1.toCharArray();
		System.out.println("Enter second string");
		String word2 = sc.next();
		char[] char2 = new char[word2.length()];
		char2 = word2.toCharArray();
		
		int[] value1 = new int[57];
		int[] value2 = new int[57];
		
		for(int i = 0 ; i < word1.length() ; i++) {
			if(((int)char1[i])- 65 > 0)
				value1[(((int)char1[i]) - 65)]++;
		}
		
		for(int i = 0 ; i < word2.length() ; i++) {
			if((((int)char2[i]) - 65) > 0)
				value2[(((int)char2[i]) - 65)]++;
		}
		
		if(Arrays.equals(value2, value1)) {
			System.out.println(word1 + " are " + word2 + " are anagrams");
		} else {
			System.out.println("not anagrams");
		}
		
//		for(int i = 0 ; i < 57 ; i++) {
//			if(value1[i] == value2[i]) {
//				if(i == 56)
//					System.out.println(word1 + " are " + word2 + " are anagrams");
//				continue;
//			}
//			else {
//				System.out.println("not anagrams");
//				break;
//			}			
//				
//		}
			
	}
}
