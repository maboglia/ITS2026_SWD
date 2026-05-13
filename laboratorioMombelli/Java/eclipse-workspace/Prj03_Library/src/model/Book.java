package model;
// i file nello stesso package si possono vedere
// chi è fuori dal pacchetto non vede
// se non specifico i modoficatori di accesso funziona così
// posso specificare private e a quel punto solo all'interno della stessa classe vedo
// pubblic vedo sia dentro che fuori dal package
// protected in caso di ereditarietà le proprietà protected sono viste solo da chi eredita ma non dal resto del mondo

public class Book {

	public String title;
	public int pages;
	public double prize;
	
	// costruttore
	public Book(String title, int pages, double prize) {
		// this = puntatore auto-refenziante
		this.title = title;
		this.pages = pages;
		this.prize = prize;
		
	}
	
	public String printInfoBook() {
		
		return "The book" + this.title + "prize" + this.prize + "£";
	}
	
}
