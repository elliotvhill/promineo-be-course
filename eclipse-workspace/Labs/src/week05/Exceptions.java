package week05;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exceptions {

	public static void main(String[] args) {

		int[] numbers = new int[3];
		System.out.println("Hi");

		if (numbers.length > 3) {
			System.out.println(numbers[3]);
		}

		System.out.println("Bye!");

		/*
		 * Checked Exception -- explicitly check for in our code; outside our control
		 * (e.g. external db that app needs to use is down) --> Use 'try catch' blocks
		 * 
		 * Unchecked Exception -- thrown bc of a programming mistake (e.g. index out of
		 * bounds, null pointer, input/output); i.e. something we can control
		 * 
		 * Note: if catching multiple exceptions, order from most specific to most
		 * general, otherwise specific exceptions will never run
		 * 
		 */

		try {
			FileReader fileReader = new FileReader("something.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		} catch (Exception e) {

		} finally {
			System.out.println("Finally");
		}

		System.out.println("after try catch");
		

		try {
			openFile("AnotherFile.jpg");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static FileReader openFile(String fileName) throws FileNotFoundException {
		return new FileReader(fileName);
	}

}
