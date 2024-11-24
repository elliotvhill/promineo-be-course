//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package week04;

import java.util.ArrayList;
import java.util.List;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// 		a. Instantiate a new StringBuilder
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder
		
		// Strings are immutable and StringBuilders are mutable
		
		StringBuilder numbers = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			numbers.append(i + "-");
		}
		numbers.delete(numbers.length() - 1, numbers.length());
		System.out.println(numbers);

		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length

		List<String> stringList = new ArrayList<String>();
		stringList.add("Geralt");
		stringList.add("Triss");
		stringList.add("Dandelion");
		stringList.add("Ouch");
		stringList.add("Barad Dur");
//		stringList.add("Hi");
		
		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string

		System.out.println(findShortestString(stringList));
		
		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched

		System.out.println(switchFirstAndLastEls(stringList).toString()); // again, technically don't need to include toString method
		
		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma
		
		System.out.println(concatenateListEls(stringList));

		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)

		List<String> sports = new ArrayList<String>();
		sports.add("basketball");
		sports.add("tennis");
		sports.add("volleyball");
		sports.add("football");
		
		System.out.println(searchForString(sports, "ball"));
		
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5

		List<Integer> numbers2 = new ArrayList<Integer>();
		numbers2.add(8);
		numbers2.add(17);
		numbers2.add(36);
		numbers2.add(95);
		numbers2.add(3);
		numbers2.add(14);
		numbers2.add(56);
		numbers2.add(49);
		numbers2.add(71);
		
		System.out.println(divideNumbers(numbers2));
		
		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string


		
		// 9. Create a set of strings and add 5 values

		
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.


		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
	
		

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set


		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word

	
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)

		
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		

	}
	
	
	// Method 15:
	
	
	
	// Method 14:
	

	
	// Method 12:
	

	
	// Method 11:
	


	// Method 10:
	

	
	// Method 8:
	

	
	// Method 7:
	
	public static List<List<Integer>> divideNumbers(List<Integer> numbers) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> divisibleByTwo = new ArrayList<Integer>();
		List<Integer> divisibleByThree = new ArrayList<Integer>();
		List<Integer> divisibleByFive = new ArrayList<Integer>();
		List<Integer> allOtherNums = new ArrayList<Integer>();
		
		for (int num : numbers) {
			if (num % 2 == 0) {
				divisibleByTwo.add(num);
			} else if (num % 3 == 0) {
				divisibleByThree.add(num);
			} else if (num % 5 == 0) {
				divisibleByFive.add(num);
			} else {
				allOtherNums.add(num);
			}
		}
		
		result.add(divisibleByTwo);
		result.add(divisibleByThree);
		result.add(divisibleByFive);
		result.add(allOtherNums);
		
		return result;
	}

	
	// Method 6:
	
	public static List<String> searchForString(List<String> list, String str) {
		List<String> results = new ArrayList<String>();
		
		for (String listItem : list) {
			if (listItem.contains(str)) {
				results.add(listItem);
			}
		}
		
		return results;
	}

	
	// Method 5:
	
	public static String concatenateListEls(List<String> list) {
		String result = "";
		for (String el : list) {
			result += el + ",";
		}
		return result;
	}
	
	
	// Method 4:
	
	public static List<String> switchFirstAndLastEls(List<String> list) {
		String firstEl = list.get(0);
		String lastEl = list.get(list.size() - 1);
		String temp = firstEl;
		System.out.println("First: " + firstEl + " Last: " + lastEl);
		firstEl = lastEl;
		lastEl = temp;
		System.out.println("First: " + firstEl + " Last: " + lastEl);
		return list;
	}
	
	
	// Method 3:
	
	public static String findShortestString(List<String> list) {
		// iterate through list and get string lengths
		// set initial smallest length = first iterator length
		// check subsequent current string length against smallest length
		// if smaller length = current
		
		int shortestLength = 0;
		String smallest = "";
		
		for (int i = 0; i < list.size(); i++) {
			int currentLength = list.get(i).toString().length();
			if (shortestLength == 0) {
				shortestLength = currentLength;
			}
			if (currentLength < shortestLength) {
				shortestLength = currentLength;
				smallest = list.get(i).toString();
			}
		}
		return smallest;
	}
	

}