
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





class ComparatoreTitolo implements Comparator<Libro>{
    @Override
    public int compare(Libro libro1, Libro libro2) {
        return libro1.getTitolo().compareTo(libro2.getTitolo());
    }
}


public class Biblioteca {

    public static void main(String[] args) {
        
        Libro l1 = new Libro(100, 20, "Amore mio");
        Libro l2 = new Libro(50, 30, "Macchina bella");
        Libro l3 = new Libro(150, 10, "Walter è morto");
        
        List<Libro> libri = new ArrayList<>();
        List<String> autori = new ArrayList<>();
        
        autori.add("primo");
        autori.add("secondo");
        autori.add("contorno");

        libri.add(l1);
        libri.add(l2);
        libri.add(l3);

        //Comparator<Libro> cp = (libro1, libro2) -> Double.compare(libro1.getPrezzo(), libro2.getPrezzo());

        Collections.sort(libri, (libro1, libro2) -> Double.compare(libro1.getPrezzo(), libro2.getPrezzo()));

        // for (Libro l : libri) {
        //     System.out.println(l);
        // }

        libri
            .stream()
            .sorted( (libro1, libro2) -> Double.compare(libro1.getPrezzo(), libro2.getPrezzo()))
            .forEach(l -> System.out.println(l));

        libri.forEach(System.out::println);


    }


}
