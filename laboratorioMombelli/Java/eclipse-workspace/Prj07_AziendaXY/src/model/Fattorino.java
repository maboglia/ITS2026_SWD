package model;

public class Fattorino extends Dipendente implements Stipendiato{

	private int consegneMese;
	// vale per tutta la classe
	
	public Fattorino(String nome, String cognome) {
		super(nome, cognome);
		this.mansione = "Fattorino";
	}
	
	public int getConsegneMese() {
		return consegneMese;
		// variabile locale al metodo
		// si deve per forza inizializzare
	}
	
	public void setConsegneMese(int consegneMese) {
		this.consegneMese = consegneMese;
	}

	@Override
	public double calcolaStipendio() {
		// TODO Auto-generated method stub
		return this.getPagaBase() * this.consegneMese;
	}
	
	
	

}
