package main;

public class CalcolatriceStatic {
	
	// ciò che è static non  poossono vedere gli oggetti
	// ma gli oggetti vedono ciò che è static
	// overload: sovraccarico dei metodi: diversi metodi con stesso nome ma FIRMA differente
	
	
	
	/**
	 * Funzione addizione della calcolatrice
	 * @param a primo numero da addizionare
	 * @param b secondo numero da addizionare
	 * @return risultato di tipo double
	 */
	public static double addizione(double a, double b) {
		return a + b;
	}
	
	public static double sottrazione(double a, double b) {
		return a - b;
	}
	
	public static double moltiplicazione(double a, double b) {
		return a * b;
	}
	
	public static double divisione(double a, double b) {
		return a / b;
	}

}
