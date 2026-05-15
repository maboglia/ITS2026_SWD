package util;

import java.util.Scanner;

public class MyScanner {
	
	// stato dell'oggetto
	private Scanner input = null;
	
	public MyScanner() {
		turnOnScanner();
	}
	
	public String readString(String question) {
		System.out.println(question);
		return this.input.nextLine();
	}
	
	public int readInteger(String question) {
		System.out.println(question);
		int temp = this.input.nextInt();
		input.nextLine();
		return temp;
	}
	
	public double readDouble(String question) {
		System.out.println(question);
		double temp = this.input.nextDouble();
		input.nextLine();
		return temp;
	}
	
	public void turnOnScanner() {
		if (this.input == null) {
			this.input = new Scanner(System.in);			
		}
	}
	
	public void turnOffScanner() {
		if (this.input != null) {
			this.input.close();
		}
	}

}
