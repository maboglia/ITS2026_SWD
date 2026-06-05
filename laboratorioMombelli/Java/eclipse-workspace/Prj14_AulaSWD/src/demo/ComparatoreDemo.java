package demo;

import java.util.Comparator;
import java.util.List;

import controller.AulaController;
import model.Studente;


//class ComparatorePerNome implements Comparator<Studente>{
	// fatta per essere usata in un altra classe
	// prende in argomento due studenti

	//@Override
	//public int compare(Studente o1, Studente o2) {
		
		//return o1.getNome().compareTo(o2.getNome());
	//}
	
//}




public class ComparatoreDemo {
	
	public static void main(String[] args) {
		AulaController aulaController = new AulaController();
		
		List<Studente> studenti = aulaController.getStudenti();
		
		//Comparator<Studente> cpn = new Comparator<Studente>() {
			
			//@Override
			//public int compare(Studente o1, Studente o2) {
			//	return o1.getNome().compareTo(o2.getNome());
			//}
		//};
		
		studenti
			.stream()
			.sorted((o1,o2) -> o1.getNome().compareTo(o2.getNome()))
			.forEach(System.out::println);
	}

}
