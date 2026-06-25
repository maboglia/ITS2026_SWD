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
		
		List<Studente> studenti = 
				StudentsBuilder.creaStudenti("documenti/studenti.csv");
		
		studenti.forEach(ctrl::addStudente);

		//ctrl.getStudenti().stream().forEach(System.out::println);
	
		System.out.println(ctrl.interroga());
		
	
//		
//		for (int i : new int[]{1,2,3,4,5,6}) {
//			if (i % 2 == 0)
//				System.out.println(i);
//		}
		
		
		
		
	}

}
