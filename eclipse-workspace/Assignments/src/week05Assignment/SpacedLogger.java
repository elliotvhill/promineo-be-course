package week05Assignment;

public class SpacedLogger implements Logger {

	@Override
	public void log(String str) {
		// Prints a space between each character of the passed string
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (i != str.length()) {
				result.append(str.charAt(i) + " ");
			} else {
				result.append(str.charAt(i));
			}
		}
		System.out.println(result.toString());
	}

	@Override
	public void error(String str) {
		// Prints a space between each character of a string preceded by 'ERROR: '
		System.out.print("ERROR: ");
		this.log(str);
	}

}
