package week05;

public interface Logger {

	/*
	 * Interfaces solve the problem of multiple inheritance -- e.g. having a House
	 * class and a Car class but needing to create an RV
	 * 
	 * Interfaces _only_ have abstract methods
	 * 
	 */

	// Define method _signatures_ we want it to have; not the bodies
	public void info(String info);
	public void warning(String warning);
	public void error(String error);
	public void fatal(String fatal);
	public void close();
	
}
