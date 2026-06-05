package scatole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class DemoListe {

	public static void main(String[] args) {
		
		String[] oldCities = {"Madrid", "Lisbona"};
		
		
		ArrayList<String> capitali = new ArrayList<>(Arrays.asList(oldCities));

		capitali.add("Parigi");
		capitali.add("Roma");
		capitali.add("Berlino");
		capitali.add("Parigi");
		capitali.addFirst("Londra");
		
		int totale = capitali.size();
		
//		Collections.sort(capitali);
//		

		capitali
			.stream()
			.sorted()
			.forEach(c -> System.out.println(c));
		System.out.println("---------------------");
		
		for (String capitale : capitali) {
		System.out.println(capitale);
	}
			
		
		
	}

}
