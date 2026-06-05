package demo;

import java.util.List;

import model.Comune;
import model.Regione;

public class GeografiaDemo {

	public static void main(String[] args) {

		Comune c1 = new Comune("Torino");
		Comune c2 = new Comune("Alessandria");
		Comune c3 = new Comune("Asti");
		Comune c4 = new Comune("Cuneo");
		
		Regione r1 = new Regione("Piemonte");
		
		r1.addComune(c1);
		r1.addComune(c2);
		r1.addComune(c3);
		r1.addComune(c4);
		
		
		List<Comune> comuni = r1.getComuni();
		
		for (Comune comune : comuni) {
			
			System.out.println(comune);
		}
	}

}
