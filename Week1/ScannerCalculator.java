package com.revature.challanges;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerCalculator {

	public static void main(String[] args) {
		
		
		String operator = "";
		double num1 = 0;
		double num2 = 0;
		boolean logic = false;
		
		//Attempts to take in user input
		while (logic == false){
			try {
				scanner(num1, num2, operator);
				logic = true;
			//Catches any number based exceptions
			}catch(NumberFormatException e) {
				System.out.println("Invalid data. Please try again.");
				logic = false;
			}catch(ArithmeticException e) {
				System.out.println("Invalid data. Please try again.");
				logic = false;
			}catch(NoSuchElementException e) {
				System.out.println("Invalid data. Please try again.");
				logic = false;
			}
		}
	}
	
	//Method to calculate two numbers
	public static double calculator(double num1, double num2, String operator) {
		double answer = 0;
		switch (operator) {
		case "+":
			answer = num1 + num2;
			return answer;
		case "*":
			answer = num1 * num2;
			return answer;
		case "-":
			answer = num1 - num2;
			return answer;
		case "/":
			answer = num1 / num2;
			return answer;
		}
		return answer;
	}
	//Calls for input from the user
	public static void scanner(double num1, double num2, String operator) {
		double answer = 0;
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Please input the first number: ");
		num1 = Double.parseDouble(s.nextLine());
		System.out.println("Please input the arithmatic operator: ");
		operator = s.nextLine();
		//Checks the operator for a correct symbol
		switch (operator) {
		case "+":
			System.out.println("Please input the second number: ");
			num2 = Double.parseDouble(s.nextLine());
			System.out.println("calculting....");
			answer = calculator(num1, num2, operator);
			System.out.println(answer);
			break;
		case "*":
			System.out.println("Please input the second number: ");
			num2 = Double.parseDouble(s.nextLine());
			System.out.println("calculting....");
			answer = calculator(num1, num2, operator);
			System.out.println(answer);
			break;
		case "-":
			System.out.println("Please input the second number: ");
			num2 = Double.parseDouble(s.nextLine());
			System.out.println("calculting....");
			answer = calculator(num1, num2, operator);
			System.out.println(answer);
			break;
		case "/":
			System.out.println("Please input the second number: ");
			num2 = Double.parseDouble(s.nextLine());
			System.out.println("calculting....");
			answer = calculator(num1, num2, operator);
			System.out.println(answer);
			break;
		default:
			//If the symbol inputed is incorrect, recalls the method
			System.out.println("Wrong operator given. Please put a proper operator. (+, -, *, /)");
			scanner(num1, num2, operator);
		}
		
	}
	
	

}
