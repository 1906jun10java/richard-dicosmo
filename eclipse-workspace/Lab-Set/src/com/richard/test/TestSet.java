package com.richard.test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();
		
		int[] numbers = {19,2,35,3,5,5,4,427,7,7,99,1};
		
		for(int i = 0; i < numbers.length; i++) {
			//unsorted elements
			hashSet.add(numbers[i]);
			//sorted elements
			treeSet.add(numbers[i]);
			
		}
		
		System.out.println(hashSet);
		System.out.println(treeSet);
		
		//contains
		System.out.println(hashSet.containsAll(treeSet));
		
		//removeAll
		hashSet.removeAll(treeSet);
		System.out.println(hashSet);

	}

}
