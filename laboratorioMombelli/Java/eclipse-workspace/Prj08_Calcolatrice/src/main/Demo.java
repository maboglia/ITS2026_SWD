package main;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		double result;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci il primo numero");
		String a = input.nextLine();
		System.out.println("Inserisci il secondp numero");
		String b = input.nextLine();
		System.out.println("Inserisci l'operatore");
		String c = input.nextLine();
		double x,y;
		switch (c) {
			case "+":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.addizione(x, y);
				System.out.println("Il risultato dell'addizione è: " + result);
				//System.out.printf("Il risultato dell'addizione è: %s" , result);
				break;
			case "-":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.sottrazione(x, y);
				System.out.println("Il risultato della sottrazione è: " + result);
				break;
			case "*":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.moltiplicazione(x, y);
				System.out.println("Il risultato della moltiplicazione è: " + result);
				break;
			case "/":
				x = Double.parseDouble(a);
				y = Double.parseDouble(b);
				result = CalcolatriceStatic.divisione(x, y);
				System.out.println("Il risultato della divisione è: " + result);
				
				break;
			default:
				System.out.println("Operazione non consentita");
				
		}
		
		
		

		
		result = CalcolatriceStatic.sottrazione(5, 4);

		System.out.println("\nIl risultato della sottrazione è: " + result);
		
		result = CalcolatriceStatic.moltiplicazione(5, 4);

		System.out.println("Il risultato della moltiplicazione è: " + result);
		
		result = CalcolatriceStatic.divisione(5, 4);

		System.out.println("Il risultato della divisione è: " + result);
		
	}

}
