package references;

public class LibroGiallo extends Libro {
	
	public LibroGiallo(String titolo, int pagine) {
		super(titolo, pagine);
		this.genere = Genere.GIALLO;
	}

//	@Override
//	public String toString() {
//		return "LibroGiallo [getId()=" + getId() + ", getTitolo()=" + getTitolo() + ", getPagine()=" + getPagine()
//				+ "]";
//	}

	
	
}
