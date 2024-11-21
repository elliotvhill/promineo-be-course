package week03;

import java.io.File;

public class Week03ClassNotes {

	public static void main(String[] args) {

		// File object has methods like `.exists()` built in
//		File file = new File("/tmp/mydata.txt");
//		boolean doesExist = file.exists();
//		System.out.println(doesExist);

		int[] numbers = {2, 4, 6, 8, 10};
		for (int num : numbers) {
			System.out.println(num);
		}
		
		int[][] myNumbers = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
	}

}
