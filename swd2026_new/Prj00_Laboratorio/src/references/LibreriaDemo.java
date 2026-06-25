package references;

import java.util.List;

public class LibreriaDemo {

	public static void main(String[] args) {
		Libro l = new LibroGiallo("Io robot", 123);
		Libro rr = new RomanzoRosa("Amo un robot", 123);
		Libro rr2 = new RomanzoRosa("Io amo lo stesso robot tuo", 123);
		Libro lf = new LibroFantascienza("La guerra dei mondi", 50);
		Libro lfy = new LibroFantasy("La pace dei mondi", 70);
		
		List<Libro> tuttiLibri = List.of(l, rr, rr2, lf, lfy);
		List<Fantasticable> libriFantastici = List.of(
				(Fantasticable) lf,
				(Fantasticable)lfy
				);
		
//		LibroRecord lr = new LibroRecord(1, "Tu robot", 321);
//		System.out.println(lr);
		
		libriFantastici.forEach(System.out::println);
		
		
		
	}

}
