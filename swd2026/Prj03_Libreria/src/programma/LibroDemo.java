package programma;

import controller.Scaffale;
import model.Libro;
import util.MioScanner;

public class LibroDemo {

	public static void main(String[] args) {
		Libro libro1 = new Libro("Io robot", 123, 10.50);
		Libro libro2 = new Libro("Tu robot", 223, 15.40);
		Libro libro3 = new Libro("Egli robot", 323, 20.30);
		
		Scaffale fantascienza = new Scaffale();

		MioScanner canon = new MioScanner();
		
//		fantascienza.addLibro(libro1);
//		fantascienza.addLibro(libro2);
//		fantascienza.addLibro(libro3);
		
		boolean gira = true;
		
		while(gira) {
			aggiungiLibro(fantascienza, canon);
			String risposta = canon.leggiStringa("Vuoi inserire altri libri?");
			//canon.leggiStringa("");
			if (risposta.equalsIgnoreCase("n")) {
				gira = false;
			}
		}
		
		
		System.out.println("<ul>");
		for (Libro l : fantascienza.getLibri()) {

			System.out.println("<li>" + l.titolo + "</li>");

		}
		System.out.println("</ul>");
		
		
	}

	private static void aggiungiLibro(Scaffale fantascienza, MioScanner canon) {
		
		
		String titolo = canon.leggiStringa("Scrivi il titolo del libro");
		int pagine = canon.leggiIntero("Quante pagine ha il libro?");
		double prezzo = canon.leggiDouble("Quanto costa ii libro?");
		
		Libro temp = new Libro(titolo, pagine, prezzo);
		fantascienza.addLibro(temp);
		
		
	}

}
