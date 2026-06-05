package scatole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
import java.util.Queue;

public class DemoListe {

	public static void main(String[] args) {
		
		String[] oldCities = {
				"Madrid",
				"Lisbona"
		};
		
		
		
		// tutte collezioni
		// qua puoi passare solo object, non tipi primitivi
		List<String> capitali = new ArrayList<String>(Arrays.asList(oldCities));
		List<String> capitali1 = new Vector<String>();
		List<String> capitali2 = new Stack<String>();
		Collection<String> capitali3 = new LinkedList<String>();
		// da dopo java 7 si può omettere il secondo tipo
		
		capitali.add("Parigi");
		capitali.add("Roma");
		capitali.add("Berlino");
		capitali.add("Parigi");
		capitali.addFirst("Londra");
		
		int totale = capitali.size();
		//solo metodi statici
//		Collections.sort(capitali);
		
	

		capitali
			.stream()
			.sorted()
			.forEach(c -> System.out.println(c));
		
		System.out.println("--------------------");
		
		for (String capitale : capitali) {
				System.out.println(capitale);
				
			}
		
	}

}
