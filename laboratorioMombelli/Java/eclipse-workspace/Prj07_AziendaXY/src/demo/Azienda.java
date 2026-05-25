package demo;

import java.util.Iterator;
import java.util.List;

import controller.AziendaController;
import model.Dipendente;
import model.Dirigente;
import model.Fattorino;
import model.Impiegato;

public class Azienda {
	
	public static void main(String[] args) {
		AziendaController ctrl = new AziendaController();
		
		Dipendente f1 = new Fattorino("Ismail", "Perta");
		Dipendente i1 = new Impiegato("Mondir", "Badaoui");
		Dipendente d1 = new Dirigente("Maikol", "Mombelli");
		
		ctrl.addDipendente(f1);
		ctrl.addDipendente(i1);
		ctrl.addDipendente(d1);
		
		f1.setPagaBase(3);
		// questo perché Dipendente non ha setConsegneMese
		// devo fare cast
		if (f1 instanceof Fattorino)
			((Fattorino)f1).setConsegneMese(52);
		
		for (Dipendente d : ctrl.getDipendenti()) {
			System.out.println(d);
			
		}
	}

}
