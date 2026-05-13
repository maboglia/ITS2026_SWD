package incrementa;

import java.util.Scanner;

public class Incrementa {

	public static void main(String[] args) {
		
		incrementaValore();

	}
	private static void incrementaValore() {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci una variabile numerica");
		int variabile = input.nextInt();
		System.out.println("Inserisci l'incremento");
		int incremento = input.nextInt();
		for (int i = 0; i < incremento; i++) {
			variabile = variabile + 1;
		}
		System.out.println("La sua variabile è: " + variabile);
	}

}
