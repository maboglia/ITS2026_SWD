package esercizi;

import java.util.Scanner;

/*
 * Scrivere un programma Ripeti che chiede all’utente di inserire una 
 * stringa e un numero intero positivo.

Entrambe gli elementi dovranno essere passati 
a un metodo ausiliario che stamperà tante copie 
della stringa quante indicate nel numero inserito dall’utente.

Se il numero inserito dall'utente è negativo 
il metodo ausiliario stamperà "ERRORE: numero negativo".

Il nome del metodo ausiliario può essere scelto a piacere.
 */

public class Ripeti {

	
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Scrivi la frase da duplicare");
		String parola = input.nextLine();
		System.out.println("Quante volte vuoi ripetere la frase");
		int numero = input.nextInt();		
		
		String risposta = creaRisposta(parola, numero);
		
		System.out.println(risposta);
		
		

	}

	private static String creaRisposta(String string, int i) {

		if (i < 0) {
			return "ERRORE: numero negativo";
		}
		
		String risposta = "";
		for (int j = 0; j < i; j++) {
			risposta += string;
		}
		
		return risposta;
	}

}
