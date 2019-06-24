package com.revature.mondaychallange;



public class Mutations {
	
	
	public static int mutationReader(String startCase, String endCase, String[] test, int answer, String current) {
		int checker = 0;
		
		if(startCase == endCase) {
			System.out.println("Current gene and end gene are identical: Code 0");
			return 0;
		}else {
			
				for (int j = 0; j < 8; j++) {
					if(current.charAt(j) != test[answer].charAt(j)) {
						checker++;
						System.out.println("Current Checker: " + checker);
						//New Code for bubble sort attempt:
						/*
						if(checker > 1) {
							String change = test[answer];
							test[answer-1] = change;
						}
						*/
					}
				}
			
			if(checker > 1) {
				System.out.println("Mutation chain broken! No Mutation Present: Code -1");
				return -1;
				
			}else if(checker == 0){
				System.out.println("Gene did not mutate at this stage, checking next gene.");
				answer++;
				current = test[answer];
				mutationReader(startCase, endCase, test, answer, current);
				
			}else if(checker == 1){
				
				if(test.length -1 == answer) {
					System.out.println("Number of mutations to reach end point: " + answer);
					return answer;
				}else {
					current = test[answer];
					answer++;
					
					System.out.println("Current mutations needed to reach end point are: " + answer);
					mutationReader(startCase, endCase, test, answer, current);
				}
				
			}
			
			
		}
		return answer;
	}
	
	
	
}
