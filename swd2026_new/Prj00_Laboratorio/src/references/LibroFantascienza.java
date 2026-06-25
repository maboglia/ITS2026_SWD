package references;

public class LibroFantascienza extends Libro implements Fantasticable {

	public LibroFantascienza(String titolo, int pagine) {
		super(titolo, pagine);
		this.genere = Genere.FANTASCIENZA;
	}
	
}
