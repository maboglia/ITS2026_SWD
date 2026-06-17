package demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import controller.AulaController;
import model.Studente;
import service.StudentsBuilder;

public class Interrogatorio {

	public static void main(String[] args) {
		
		AulaController ctrl = new AulaController();
		
		List<Studente> studenti=
				StudentsBuilder.creaStudenti("documenti/studenti.csv");
		
		studenti.forEach(s -> ctrl.addStudente(s));
		
		//ctrl.getStudenti().stream().forEach(System.out::println);
		//System.out.println(Studente.getCounter());
		
		System.out.println(ctrl.interroga());
		
//		int[] numeri = {1,2,3,4,5,6};
	
	//	for (int i : numeri) {
		//	if(i % 2 == 0)
			//	System.out.println(i);
			
		//}
	}
}
