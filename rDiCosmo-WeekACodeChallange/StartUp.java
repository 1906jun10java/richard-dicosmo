package com.revature.startup;
import com.revature.fbmechanism.*;

import java.util.ArrayList;
import java.util.Scanner;

public class StartUp {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numOne;
		int numTwo;
		int fizz;
		int buzz;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> effects = new ArrayList<String>();
		boolean cont = false;
		int i = 0;
		String check;
		boolean valid = false;
		System.out.println("Select a number range: First Number ");
		numOne = s.nextInt();
		System.out.println("Select a number range: Second Number ");
		numTwo = s.nextInt();
		System.out.println("What multiple makes a fizz? ");
		fizz = s.nextInt();
		System.out.println("What multiple makes a buzz? ");
		buzz = s.nextInt();
		
		System.out.println("Executing FizzBuzzBasic");
		FizzBuzz fb = new FizzBuzz(numOne, numTwo, fizz, buzz);
		fb.fizzBuzzBasic();
		
		System.out.println("Starting Advanced Portion...");
		System.out.println("Select a number range: First Number ");
		numOne = s.nextInt();
		System.out.println("Select a number range: Second Number ");
		numTwo = s.nextInt();
			while(cont == false) {
				valid = false;
				System.out.println("Input multiple number " + i + ": ");
				numbers.add(s.nextInt());
				i++;
				while (valid == false) {
						System.out.println("Would you like to add another? (Y or N)");
						s.reset();
						check = s.next();
						System.out.println("You answered: " + check);
							if(check.equals("y") || check.equals("Y") ) {
									cont = false;
									valid = true;
									
							}else if(check.equals("n") || check.equals("N")) {
									cont = true;
									valid = true; 
							}else {
								System.out.println("Please input a proper answer (Y or N).");
								valid = false;
							}
				}
				
				
				
		}
			for (int j = 0; j < numbers.size(); j++) {
				System.out.println("Add a word effect to " + numbers.get(j));
				s.reset();
				check = s.next();
				System.out.println("You answered: " + check + " for the number " + numbers.get(j));
				effects.add(j, check);
		}
		
		System.out.println("Executing FizzBuzzAdvanced");
		fb.fizzBuzzAdvanced(numOne, numTwo, numbers, effects);

	}

}
