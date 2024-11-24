//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  StringBuilders, Lists, Sets, & Maps
// Java Week 04 Lab  
//
package week04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
//		System.out.println(numbers);

		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length

		List<String> stringList = new ArrayList<String>();
		stringList.add("Geralt");
		stringList.add("Triss");
		stringList.add("Dandelion");
		stringList.add("Ouch");
		stringList.add("Barad Dur");
		stringList.add("Yennifer");
		stringList.add("Yarpen");
		stringList.add("Octopus");
		stringList.add("Grima");
		
		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string

//		System.out.println(findShortestString(stringList));
		
		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched

//		System.out.println(switchFirstAndLastEls(stringList).toString()); // again, technically don't need to include toString method
		
		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma
		
//		System.out.println(concatenateListEls(stringList));

		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)

		List<String> sports = new ArrayList<String>();
		sports.add("basketball");
		sports.add("tennis");
		sports.add("volleyball");
		sports.add("football");
		sports.add("tetherball");
		
//		System.out.println(searchForString(sports, "ball"));
		
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
		
//		System.out.println(divideNumbers(numbers2));
		
		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string

//		System.out.println(getStringLengths(stringList));

		
		// 9. Create a set of strings and add 5 values

		Set<String> dogs = new HashSet<String>();
		dogs.add("Italian Greyhound");
		dogs.add("Airedale Terrior");
		dogs.add("German Shepherd");
		dogs.add("Chihuahua");
		dogs.add("Doberman");
		
//		System.out.println(dogs);
		
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.

		Set<String> tvShows = new HashSet<String>();
		tvShows.add("Schitt's Creek");
		tvShows.add("Breaking Bad");
		tvShows.add("Rick and Morty");
		tvShows.add("Bosch");
		
//		System.out.println(searchForChar(tvShows, 'B'));
		/* how to make it case insensitive? regex? */
		
		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings

//		System.out.println(convertSetToList(tvShows));
		

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set

		Set<Integer> numbers3 = new HashSet<Integer>();
		numbers3.add(87);
		numbers3.add(46);
		numbers3.add(13);
		numbers3.add(8);
		numbers3.add(3);
		numbers3.add(192);
		
//		System.out.println(findEvenNums(numbers3));

		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word

		Map<String, String> dictionary = new HashMap<String, String>();
		
		dictionary.put("quixotic", "exceedingly idealistic; unrealistic and impractical");
		dictionary.put("superfluous", "unnecessary, especially through being more than enough");
		dictionary.put("egregious", "outstandingly bad; shocking");
		
//		System.out.println(dictionary);
	
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)

		Map<String, String> greetings = new HashMap<String, String>();
		
		greetings.put("Spanish", "Hola");
		greetings.put("Italian", "Ciao");
		greetings.put("French", "Salut");
		
//		System.out.println(lookupGreeting(greetings, "Italian"));
		
		
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		
		System.out.println(countStringsInList(stringList));

	}
	
	
	// Method 15:
	
	public static Map<Character, Integer> countStringsInList(List<String> list) {
		Map<Character, Integer> results = new HashMap<Character, Integer>();
		
		for (String str : list) {
			int charCount = 1;
			
			if (!results.containsKey(str.charAt(0))) {
				results.put(str.charAt(0), charCount);
			} else {
				charCount++;
				results.replace(str.charAt(0), charCount);
			}
		}
		return results;
	}
	
	
	// Method 14:
	
	public static String lookupGreeting(Map<String, String> input, String str) {
		return input.get(str);
	}

	
	// Method 12:
	
	public static Set<Integer> findEvenNums(Set<Integer> numbers) {
		Set<Integer> evenNumbers = new HashSet<Integer>();
		for (int num : numbers) {
			if (num % 2 == 0) {
				evenNumbers.add(num);
			}
		}
		return evenNumbers;
	}

	
	// Method 11:
	
	public static List<String> convertSetToList(Set<String> strings) {
		List<String> results = new ArrayList<String>();
		for (String str : strings) {
			results.add(str);
		}
		return results;
	}

	// Method 10:
	
	public static Set<String> searchForChar(Set<String> input, char a) {
		Set<String> results = new HashSet<String>();
		
		for (String str : input) {
			if (str.charAt(0) == a) {
				results.add(str);
			}
		}
		return results;
	}

	
	// Method 8:
	
	public static List<Integer> getStringLengths(List<String> strings) {
		List<Integer> stringLengths = new ArrayList<Integer>();
		
		for (String str : strings) {
			stringLengths.add(str.length());
		}
		
		return stringLengths;
	}

	
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