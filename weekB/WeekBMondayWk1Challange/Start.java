package com.revature.mondaychallange;
import java.io.*;
import java.util.Scanner;

import com.revature.mondaychallange.Mutations;

public class Start {

	public static void main(String[] args) throws IOException {
		String[] bank = new String[5];
		
		 try {
			 //File location is stored here:
			 InputStream s = new FileInputStream("C:/Users/rjdic/eclipse-workspace/WeekB/src/com/revature/mondaychallange/input.txt");
		      Scanner myReader = new Scanner(s); 
		      //Loop that takes in file data and saves it to a string
		      System.out.println("Listing available gene bank: ");
		      for (int i = 0; i < bank.length; i ++) {
		    	 
				    	
				        bank[i] = myReader.nextLine();
				        
				        System.out.println(bank[i]);
				      
				      
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } 
		
		/*
		bank[0] = "AACCGCTA";
		bank[1] = "AAACGCTA";
		bank[2] = "AAACGGTA";
		*/
		//System.out.println("Number of mutations present: " + Mutations.mutationCheck(bank));
		
		//ArrayList<String> geneBank = new ArrayList<>();
		String startCase = "AACCGGTA";
		String endCase = "AAAGGGTT";
		//String endCase = "AAACGGTA";
		int answer = 0;
		String current = startCase;
		
		
		Mutations.mutationReader(startCase, endCase, bank, answer, current);

	}



}
