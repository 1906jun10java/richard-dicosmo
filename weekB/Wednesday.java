package com.revature.stringpalindrome;

import java.util.Scanner;

public class Wednesday {

	public static void main(String[] args) {
		// Place in repo WeekB/Wednesday.java
		Scanner s = new Scanner(System.in);
		System.out.println("Please input a word to test");
		String test = s.next();
		System.out.println("Testing is the word is a Palindrome: ");
		isPalindrome(test);
		System.out.println(reverseString(test));
	}
	
	//Method to reverse a string
	public static String reverseString(String test) {
		String reverse = ""; //Stores the answer
		int length = test.length(); //Determines the length of the string
		System.out.println("Length of string is " + length);
		//Iterates through the string by each character and places them back into another string in reverse order
		for (int i = 0; i <= test.length()-1; i++) {
			reverse = test.charAt(i) + reverse;
		}
		return reverse;
	}
	
	public static void isPalindrome(String test) {
		boolean checker = false;
		//If the word has an even number of characters
		if((test.length())%2 !=0) {
			System.out.println("The word has an even number of letters");
			for (int i = 0; i <= test.length()-1; i++) {
				//runs through j from highest value to lowest
				for (int j = test.length()-1; j >= 0; j--) {
					if (test.charAt(i) == test.charAt(j)){
						checker = true;
					//Checks if i or j are equal to zero to avoid dividing zero
					}else if(i!=0&j!=0){
						//checks the two characters in the middle of the string
						if ((test.length() - 1)%i==0&(test.length() - 1)%j==0)
						checker = true;
					}else {
						checker = false;
					}
				}
		
			}
		}else { //If the word has an odd number of characters
			System.out.println("The word has an odd number of letters");
			for (int i = 0; i <= test.length()-1; i++) {
				//runs through j from highest value to lowest
				for (int j = test.length()-1; j >= 0; j--) {
					if (test.charAt(i) == test.charAt(j)){
						checker = true;
					}else {
						checker = false;
					}	
				}
		
			}
			
		}
		System.out.println(checker);
	}
	
}