package week04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Week04Quiz {

	public static void main(String[] args) {

		List<String> listOfNames = new ArrayList<>();
		listOfNames.add("Richard");
		listOfNames.add("Garyn");
		listOfNames.add("Helene");
		listOfNames.add("Richard");
		listOfNames.add("Garyn");
		listOfNames.add("Helene");
		//		System.out.println(listOfNames.get(4));
		//		List<String> resultsList = new ArrayList<>();
		//		for (int i = 0; i < listOfNames.size(); i++) {
		//			if (!(i % 2 == 0)) {
		//				resultsList.add(listOfNames.get(i));
		//			}
		//		}
		//		System.out.println(resultsList);

		List<String> resultsList = new ArrayList<>();

		Map<String, String> racerPlaces = new HashMap<String, String>();
		racerPlaces.put("Alex", "one");
		racerPlaces.put("Emily", "two");
		racerPlaces.put("AJ", "three");

		Set<String> keySet = racerPlaces.keySet();
		for (String key : keySet) {
			if (key.toLowerCase().charAt(0) == 'a') {
				resultsList.add(racerPlaces.get(key));
			}
		}
		System.out.println(resultsList);

		/* Question 7 */

		// Vocabulary Source: https://Ïwww.oracle.com/java/technologies/glossary.html

		// *** Declare the map variable, javaDictionary ***
		Map<String, String> javaDictionary = new HashMap<>();

		// *** Populate the map with the following Java vocabulary words, and
		// definitions ***

		javaDictionary.put("array", "A Java Object that contains a collection of data items, all of the same type, accessed by an integer index.");

		javaDictionary.put("API", "Application Programming Interface.  The way that a programmer writing an application will access the behavior and state of classes and objects.");

		javaDictionary.put("autoboxing", "The automatic conversion between reference and primitive types.");

		javaDictionary.put("primitive type", "A Java datatype in which the variable's value is of the appropriate size and format for its type.  There are 8 primitive datatypes in Java.");

		javaDictionary.put("reference type", "A variable data type in which the variable's value is an address.");

		javaDictionary.put("stream", "A byte-stream of data that is sent from a sender to a receiver.");

		javaDictionary.put("class", "A type that defines the implementation of an object.");

		// *** Check the result ***

		// Print the number of entries in the dictionary (Hint: use a method on the Map
		// variable)

		System.out.println("Number of entries in javaDictionary: " + javaDictionary.size()
				);

		// Print the dictionary (Hint: use the Map variable)
		System.out.println(javaDictionary.toString());


	}

}
