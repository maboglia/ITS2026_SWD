package concatena;

import java.util.Scanner;

public class ConcatenaMain {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Dimmi una parola?");
		String f1 = input.nextLine();
		System.out.println("Dimmi una parola?");
		String f2 = input.nextLine();
		System.out.println("Dimmi una parola?");
		String f3 = input.nextLine();
		
		
		String c = unisciStringhe(unisciStringhe(f1,f2),f3);
		Concatena f = new Concatena(c);
		System.out.println(f.Stampa());

	}
	public static String unisciStringhe(String p, String d) {
		String n = p + "*" + d;
		return n;
	}

}
