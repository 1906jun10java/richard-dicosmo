package com.revature.thursday;


import java.util.Arrays;
import java.util.regex.*;

public class Thursday {

	public static void main(String[] args) {
		
		String str = "find this word";
		String subStr = "word";
		int triangleAnswer = 0;
		int numRows = 4;
		//Substring Challenge
		System.out.println("Looking for " + "'" + subStr + "' in the phrase " + "'" + str + "'");
		System.out.println(containsSubstring(str, subStr));
		//Triangle Challenge
		System.out.println("The number of boxes in " + numRows + " rows in a triangular pyramid are: ");
		triangle(numRows, triangleAnswer);
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("-------- Queue Class Work ---------");
		String[] l = new String[4];
		l[0] = "first";
		l[1] = "second";
		l[2] = "third";
		l[3] = "fourth";
		int length = l.length;
		System.out.println("Current Array shows: ");
		for (int i = 0; i < l.length; i++) {
			System.out.println(l[i]);
		}
		System.out.println("Peeking at the queue showing value: " + peekQueue(l));
		removeQueue(l);
		
		System.out.println("Adding a new value to the queue: ");
		//addQueue("fifth", l);
		System.out.println("Current Array shows: ");
		for (int i = 0; i < l.length; i++) {
			System.out.println(l[i]);
		}
	}
	//Finds a substring in a string using regex
	public static boolean containsSubstring(String str, String subStr) {
		boolean checker = false;
		//Creates a regex pattern
		Pattern p = Pattern.compile("." + subStr);
		//specifies the string to search in
		Matcher m = p.matcher(str);
		//checks to see if the substring is inside the string
		checker = m.find();
		//Returns an answer
		return checker;
	}
	
	public static void triangle(int numRows, int triangleAnswer) {
		triangleAnswer = triangleAnswer + numRows; //saves the current sum in answer
		numRows--; //increments down the base case
		if (numRows>0) { //checks the base case
			triangle(numRows, triangleAnswer); //Initiates recursion
		}else {
			System.out.println(triangleAnswer);
		}
	}
	
	public static void addQueue(String q, String[] l) {
		l = Arrays.copyOf(l, l.length +1);
		l[l.length -1] = q;
	}
	
	public static void removeQueue(String[] l) {
		int length = l.length;
		for(int i = 0; i < l.length-1; i++) {
			l[i] = l[i+1];
		}
		
		l = Arrays.copyOf(l, length - 1);
	}
	
	public static String peekQueue(String[] l) {
		return l[0];
	}
	public static String pollQueue(String[] l) {
		String r = peekQueue(l);
		removeQueue(l);
		return r;
	}

}
