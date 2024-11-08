package com.promineotech;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("My first Java Program!");
		
		int elliotAge = 33;
		String name = "Elliot";
		boolean isEmployed = false;
		
		System.out.println(elliotAge);
		System.out.println(name);
		System.out.println(isEmployed);
		
		double accountBalance = 174.235;
		String accountBalanceMsg = "Your account balance is $%.2f";
		System.out.println(String.format(accountBalanceMsg, accountBalance));
	}

}
