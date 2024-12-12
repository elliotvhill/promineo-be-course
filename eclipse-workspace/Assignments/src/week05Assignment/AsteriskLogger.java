package week05Assignment;

public class AsteriskLogger implements Logger {

	@Override
	public void log(String str) {
		// prints a passed String between 3 asterisks on either side
		System.out.println(String.format("***%s***", str));
	}

	@Override
	public void error(String str) {
		// prints a passed String in a box of asterisks
		System.out.println(String.format("****************\n***ERROR: %s***\n****************", str));
	}

}
