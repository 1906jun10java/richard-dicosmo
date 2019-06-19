package com.revature.fbmechanism;

import java.util.ArrayList;

public class FizzBuzz {
	int numOne;
	int numTwo;
	int fizz;
	int buzz;
	int current = 1;
	String statement = "";
	public FizzBuzz(int numOne, int numTwo,int fizz, int buzz ) {
		this.numOne  = numOne;
		this.numTwo = numTwo;
		this.fizz = fizz;
		this.buzz = buzz;
	}
	public void fizzBuzzBasic(){
		for(int i = numOne; i < numTwo; i++) {
			if(i%fizz == 0 & i%buzz == 0) {
				System.out.println("fizzbuzz");
			}
			else if(i%fizz == 0) {
				System.out.println("fizz");
			}
			else if(i%buzz == 0) {
				System.out.println("buzz");
			}
			else{
				System.out.println(i);
			}
		}
	}
	public void fizzBuzzAdvanced(int numberOne, int numberTwo, ArrayList<Integer> numbers, ArrayList<String> effects) {
		
		while(current <= numberTwo) {
			
			for(int i = 0; i < numbers.size(); i++) {
				//int remainder = current%numbers.get(i);
				//System.out.println("remainder: " + remainder);
				//System.out.println("Current Equation " + (numbers.get(i)) + "%" + current + " = " + (numbers.get(i)%current));
				
				if(current%numbers.get(i) == 0) {
					//System.out.println(numbers.get(i) + " Matches");
					statement = statement + effects.get(i) + "(" + numbers.get(i) + ")";
				}else {
					//System.out.println(numbers.get(i) + " Does not match");
				}
			}
			if(statement.isEmpty() == true) {
				System.out.println(current);
			}else {
				System.out.println(statement);
			}
			statement = "";
			current++;
			
		}
		
	}
}
