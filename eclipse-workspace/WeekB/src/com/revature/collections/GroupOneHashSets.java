package com.revature.collections;
import com.revature.model.*;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class GroupOneHashSets {

	public static void main(String[] args) {
		hs();
		lhs();

	}
	
	public static void hs() {
		
		HashSet<User> userSet = new HashSet<>();
		
		User u1 = new User("Gandalf", "Grey", "mirthrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		
		//.add method:
		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		
		for (User user : userSet) {
			System.out.println(user);
		}
		
		System.out.println(userSet.iterator());
		
		System.out.println("--------------------------------------------------------------");
		System.out.println("Clearing the HashSet");
		//.clear method clears the hashMap
				userSet.clear();
		System.out.println("--------------------------------------------------------------");
		
		
		User us1 = new User("Joe", "Johnson", "thisguy", "that_guy");
		User us2 = new User("Paul", "Mcendrix", "MeAmThatKindOfOrc", "thats_right");
		User us3 = new User("David", "Doe", "deo", "doooh");
		
		//.add method:
		userSet.add(us1);
		userSet.add(us2);
		userSet.add(us3);
		
		for (User user : userSet) {
			System.out.println(user);
		}
		
		System.out.println(userSet.iterator());
		
		System.out.println("--------------------------------------------------------------");
		
	}
	
	public static void lhs() {
		LinkedHashSet<User> userSet = new LinkedHashSet<>();
		
		User u1 = new User("Gandalf", "Grey", "mirthrandir", "you_shall_not");
		User u2 = new User("Paul", "Hewson", "bono", "u2RuleZ");
		User u3 = new User("David", "Tennant", "doc10", "tardis");
		
		//.add method:
		userSet.add(u1);
		userSet.add(u2);
		userSet.add(u3);
		
		for (User user : userSet) {
			System.out.println(user);
		}
		System.out.println("Notice the LinkedHashSet is in order of object insertion");
		System.out.println(userSet.iterator());
		System.out.println("--------------------------------------------------------------");
		System.out.println("Clearing the LinkedHashSet");
		//.clear method clears the hashMap
				userSet.clear();
		System.out.println("--------------------------------------------------------------");
		
		
		User us1 = new User("Joe", "Johnson", "thisguy", "that_guy");
		User us2 = new User("Paul", "Mcendrix", "MeAmThatKindOfOrc", "thats_right");
		User us3 = new User("David", "Doe", "deo", "doooh");
		
		//.add method:
		userSet.add(us1);
		userSet.add(us2);
		userSet.add(us3);
		
		for (User user : userSet) {
			System.out.println(user);
		}
		System.out.println("Notice the LinkedHashSet is in order of object insertion");
		
		System.out.println(userSet.iterator());
		
		System.out.println("--------------------------------------------------------------");
		
	}
	
	

}
