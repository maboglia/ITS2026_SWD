package todo;

public class Todo {

	String cosaDaFare;
	boolean completato;
	
	public Todo(String cosaDaFare) {
		this.cosaDaFare = cosaDaFare;
		this.completato = false;
	}

	@Override
	public String toString() {
		
		String risposta = "";
		
		if (this.completato) {
			risposta += "[*] ";
		} else {
			risposta += "[ ] ";
		}
		
		risposta += this.cosaDaFare;
		
		return  risposta;
	}
	
}
