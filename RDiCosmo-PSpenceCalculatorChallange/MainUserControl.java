package com.revature.userInterface;
import java.util.Scanner;

import com.revature.calculator.*;

public class MainUserControl {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String value;
		Double first;
		Double second;
		String arith;
		boolean checker = false;
		/*String input;
		*System.out.println("Input an equation: ");
		*input = s.next();
		*Reader.Search(input);
		*/
		while (checker == false) {
			System.out.println("Input first number: ");
			first = s.nextDouble();
			if(first != null) {
				System.out.println("Input second number: ");
				second = s.nextDouble();
				if(second != null) {
					System.out.println("Input an arithmatic symbol (+, -, *, or /): ");
					arith = s.next();
					System.out.println("Current arithatic symbol is " + arith);
					if(arith.contentEquals("+")) {
						System.out.println("The answer is " + Calculator.add(first, second));
						checker = true;
					}else if(arith.contentEquals("-")) {
						System.out.println("The answer is " + Calculator.subtract(first, second));
						checker = true;
					}else if(arith.contentEquals("*")) {
						System.out.println("The answer is " + Calculator.multiply(first, second));
						checker = true;
					}else if(arith.contentEquals("/")) {
						System.out.println("The answer is " + Calculator.divide(first, second));
						checker = true;
					}else {
						System.out.println("Please input a correct arithmatic symbol (+, -, *, or /): ");
						checker = false;
						continue;
					}
				}else {
					System.out.println("Please input a proper number.");
					checker = false;
					continue;
				}
			}else {
				System.out.println("Please input a proper number.");
				checker = false;
				continue;
			}
			
		}
		
	}

}
