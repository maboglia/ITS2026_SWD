package model;

public abstract class Dipendente { 
	// serve da modello la classe astratta
	// per evitare che venga creato un generico Dipendente
	// per usare Dipendente serviranno delle classi che la estendono
	// non si può essere sia final che abstract
	
	private static int contatore = 1;
	
	
	private int nMatricola;
	private String nome;
	private String cognome;
	protected String mansione;
	private double pagaBase;
	
	
	public Dipendente(String nome, String cognome) {
		this.nMatricola = contatore++;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public int getNMatricola(){
		return this.nMatricola;
	}

	
	public String getMansione() {
		return mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public double getPagaBase() {
		return pagaBase;
	}

	public void setPagaBase(double pagaBase) {
		this.pagaBase = pagaBase;
	}

	public static int getContatore() {
		return contatore;
	}

	public int getnMatricola() {
		return nMatricola;
	}

	@Override
	public String toString() {
		return "Dipendente " + this.mansione + " [nMatricola=" + nMatricola + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	

}
