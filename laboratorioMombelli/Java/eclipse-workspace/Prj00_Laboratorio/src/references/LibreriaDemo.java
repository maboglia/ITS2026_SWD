package references;

import java.util.List;

public class LibreriaDemo {

	public static void main(String[] args) {
		Libro l = new LibroGiallo("Io robot", 123);
//		LibroRecord lr = new LibroRecord(1, "Tu robot", 321);
		Libro rr = new RomanzoRosa("Amo un robot", 234);
		Libro rr2 = new RomanzoRosa("Io amo lo stesso robot tuo", 345);
		Libro lf = new LibroFantascienza("La guerre dei mondi", 50);
		Libro lfy = new LibroFantasy("La guerre dei mondi 2 ", 500);
		
		List<Libro> tuttiLibri = List.of(l, rr, rr2, lf, lfy);
		List<Fantasticable> libriFantastici = List.of((Fantasticable)lf, (Fantasticable)lfy);
		
		
	//	System.out.println(l);
//		System.out.println(lr);
		//System.out.println(rr);
		//System.out.println(rr2);

		
		tuttiLibri.forEach(System.out:: println);
		libriFantastici.forEach(System.out:: println);
	}

}
