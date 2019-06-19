package com.revature.stringpalindrome;

import java.util.Scanner;

public class Wednesday {

	public static void main(String[] args) {
		// Place in repo WeekB/Wednesday.java
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		//Requests input for a word
		System.out.println("Please input a word to test");
		String test = s.next();
		//Sets the length of the word minus one to a variable for the recursive methods
		int n = test.length() -1;
		int y = 0;
		String reverseAnswer = "";
		System.out.println("Testing is the word is a Palindrome: ");
		isPalindrome(test);
		System.out.println(reverseString(test));
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Activating recursive methods...");
		recursiveReverse(test, reverseAnswer, n);
		recursivePalindrome(test, n, y);
		
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
	
	public static void recursiveReverse(String test, String answer, int n) {
		answer = answer + test.charAt(n); //Saves the characters in reverse
		n--; //increments down the base case
		if (n>=0) { //checks the base case
			recursiveReverse(test, answer, n); //Initiates recursion
		}else {
			System.out.println(answer);
		}
	}
	
	public static void recursivePalindrome(String test, int n, int y) {
		boolean checker = false;
		if (test.charAt(n) == test.charAt(y)){
			checker = true;
		//Checks if i or j are equal to zero to avoid dividing zero
		}else if(n!=0&y!=0){
			//checks the two characters in the middle of the string
			if ((test.length() - 1)%n==0&(test.length() - 1)%y==0)
			checker = true;
		}else {
			checker = false;
		}
		n--;
		y++;
		if (n>=0) { //checks the base case
			recursivePalindrome(test,n,y); //Initiates recursion
		}else {
			System.out.println("Testing if the word is a palindrome: " + checker);
		}
		
	}
	
}