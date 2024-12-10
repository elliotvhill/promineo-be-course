package week05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLogger implements Logger {

	private BufferedWriter writer;
	
	public FileLogger() {
		try {
			writer = new BufferedWriter(new FileWriter("logs.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void info(String info) {
		Date date = new Date();
		try {
			writer.append(date.toString() + " - INFO: " + info);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void warning(String warning) {
		Date date = new Date();
		try {
			writer.append(date.toString() + " - WARNING: " + warning);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void error(String error) {
		Date date = new Date();
		try {
			writer.append(date.toString() + " - ERROR: " + error);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void fatal(String fatal) {
		Date date = new Date();
		try {
			writer.append(date.toString() + " - FATAL: " + fatal.toUpperCase());
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
