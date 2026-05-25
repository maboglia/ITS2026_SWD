package controller;

import java.util.ArrayList;
import java.util.List;

import model.Dipendente;

public class AziendaController {

	List<Dipendente> dipendenti = new ArrayList<>();

	public Dipendente addDipendente(Dipendente d) {
		this.dipendenti.add(d);
		return d;
	}
	
	public List<Dipendente> getDipendenti(){
		return this.dipendenti;
	}
	
	public Dipendente getDipendenteById(int id) {
		for (Dipendente d : dipendenti) {
			if (d.getNMatricola() == id)
				return d;
		}
		return null;
	}
	
	
}
