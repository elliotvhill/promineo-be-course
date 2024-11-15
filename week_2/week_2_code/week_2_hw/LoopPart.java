package com.promineotech.hw;

import java.util.Scanner;

public class LoopPart {
	public static void main(String[] args) {
		question5();
	}
	
	public static void question5() {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int power = in.nextInt();
        int result = 1;
        
        for(int index = 1; index <= power; index++ ) {
        	result = result * base;
        	System.out.println(result);
        }
        in.close();
	}
}
