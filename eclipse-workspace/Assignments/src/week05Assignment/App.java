package week05Assignment;

public class App {

	public static void main(String[] args) {

		Logger asteriskLogger = new AsteriskLogger();
		Logger spacedLogger = new SpacedLogger();
		
		asteriskLogger.log("Howdy");
		System.out.println();
		asteriskLogger.error("Howdy");
		
		System.out.println("\n-------------------\n");
		
		spacedLogger.log("Howdy");
		System.out.println();
		spacedLogger.error("Howdy");

	}

}
