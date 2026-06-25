package model;

public record Studente(String nome, String cognome ){
	
	private static int counter = 1;
	
	public Studente {
		counter++;
	}

	public static int getCounter() {
		//TODO: poi devi sistemare perché è brutto 7/12/1999
		
		return counter - 1;
	}
	
	
}
