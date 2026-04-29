package todo;

public class Todo {

	String cosaDaFare;
	boolean completato;
	
	
	// costruttore oggetto è unico meotdo che non è obbligato a ritornare
	// niente quindi posso ometterlo (in realtà ritorna la posizione dell'oggetto 
	// in memoria)
	public Todo(String cosaDaFare) {
		this.cosaDaFare = cosaDaFare;
		this.completato = false;
	}
	
	public String stampa() {
		
		String risposta = " ";
		if(this.completato) {
			risposta += "[*] ";
		} else {
			risposta += "[] ";
		}
		risposta += this.cosaDaFare;
		
		return risposta;
	}
	
}
