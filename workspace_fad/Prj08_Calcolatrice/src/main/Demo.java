package main;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		double result;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci il primo numero");
		String a = input.nextLine();

		System.out.println("Inserisci il secondo numero");
		String b = input.nextLine();
		
		System.out.println("Inserisci l'operatore aritmetico");
		String c = input.nextLine();
		
		double x, y;
		
		switch (c) {
			case "+":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.addizione(x, y);
				System.out.println("Il risultato dell'addizione è: " + result);
				break;
			
			case "-":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.sottrazione(x, y);
				System.out.println("Il risultato sottrazione è: " + result);
				break;
			
			case "*":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.moltiplicazione(x, y);
				System.out.println("Il risultato moltiplicazione è: " + result);
				break;
			
			case "/":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.divisione(x, y);
				System.out.println("Il risultato divisione è: " + result);
				break;
			
		
			default:
				System.out.println("Operazione non consentita!");
		}
		
		
	}

}
