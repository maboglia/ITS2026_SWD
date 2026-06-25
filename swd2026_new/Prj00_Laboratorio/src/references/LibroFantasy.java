package references;

public class LibroFantasy extends Libro implements Fantasticable {

	public LibroFantasy(String titolo, int pagine) {
		super(titolo, pagine);
		this.genere = Genere.FANTASY;

	}
	
}
