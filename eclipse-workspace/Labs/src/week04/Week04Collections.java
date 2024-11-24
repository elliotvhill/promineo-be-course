package week04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Week04Collections {

	public static void main(String[] args) {
		
		/* 
		 * Lists and Collections are Interfaces
		 * A List is a type of Collection itself
		 * So we also cannot instantiate a Collection
		 */
		
		/*
		 * List:
		 * 
		 * Allows duplicates
		 * Keeps elements ordered by index, in order of entry
		 * Allows null values
		 * Common implementations: ArrayList, LinkedList, Vector
		 * 
		 * List Methods: 
		 * .add()
		 * .get()
		 * .contains() // will search Strings for a sequence of chars, for example
		 */
		
		List<String> students = new ArrayList<String>();
		students.add("Geralt");
		students.add("Geralt");
		students.add("Cahir");
		students.add(null);
		
		for (String student : students) {
			System.out.println(student);
		}
		
		System.out.println(students.get(2));
		System.out.println(students.get(0));
		
		 /*
		  * Set:
		  * 
		  * Does NOT allow duplicates
		  * Unordered -- cannot guarantee order of elements
		  * Allows null value (but only one bc no dupes)
		  * Common implementations: HashSet, LinkedHashSet, treeSet
		  * 
		  * Set Methods:
		  * 
		  * .contains()
		  * .isEmpty()
		  * .size()
		  * .remove()
		  * 
		  */
		
		Set<String> states = new HashSet<String>();
		states.add("Connecticut");
		states.add("Connecticut");
		states.add("New York");
		states.add("California");
		states.add(null);
		
		System.out.println(states.size());
		System.out.println(states.contains("Delaware"));
		System.out.println(states.contains("New York"));
		if (states.contains("New York")) { // remove if exists
			states.remove("New York");
		}
		
		for (String state : states) {
			System.out.println(state);
		}
		
		Set<String> vegetables = new HashSet<String>(); // Note: JDK 7+ can just say 'new HashSet<>()'
		vegetables.add("Zucchini");
		System.out.println(vegetables);
		vegetables.add("Broccoli");
		System.out.println(vegetables);
		vegetables.add("Artichoke");
		System.out.println(vegetables);
		vegetables.add("Asparagus");
		System.out.println(vegetables);
		vegetables.add("Asparagus");
		System.out.println(vegetables);
		
		
		 /*
		  * Map:
		  * 
		  * Map<K, V> where K is the key, V is the value
		  * 
		  * Key value pairs (like a dictionary)
		  * Values can be duplicate, but not keys
		  * Allows null
		  * Common implementations: HashMap, LinkedHashMap, TreeMap, Hashtable
		  * 
		  * Map Methods:
		  *  .get() -- have to pass in an object
		  *  .isEmpty()
		  *  .keySet() -- returns a Set of the keys
		  *  .put()
		  *  .remove() -- pass in a key to remove
		  *  .size() -- number of elements in the Map
		  *  .values() -- like keySet but returns collection of just values
		  * 
		  */
		
		Map<Integer, String> racerPlaces = new HashMap<Integer, String>();
		racerPlaces.put(1, "Alex");
		racerPlaces.put(2, "Emily");
		racerPlaces.put(3, "AJ");
		
		System.out.println(racerPlaces.get(1));
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("word1", "definition1");
		dictionary.put("word2", "definition2");
		dictionary.put("word3", "definition3");
		
		
		
		racerPlaces.remove(1);
		
		Set<Integer> racerKeys = racerPlaces.keySet();
		for (Integer key : racerKeys) {
//			System.out.println(key); // Print list of keys
			System.out.println(key + " : " + racerPlaces.get(key)); // Print keys and values from the keys retrieved
		}
		
		Collection<String> racers = racerPlaces.values();
		for (String racer : racers) {
			System.out.println(racer);
		}
		
	}

}
