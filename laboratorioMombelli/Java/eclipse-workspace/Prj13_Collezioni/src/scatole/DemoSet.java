package scatole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.Queue;

public class DemoSet {

	public static void main(String[] args) {
		
		String[] oldCities = {
				"Madrid",
				"Lisbona"
		};
		
		
		HashSet<String> capitali = new HashSet<String>(Arrays.asList(oldCities));
		TreeSet<String> capitali4 = new TreeSet<String>(Arrays.asList(oldCities));
		
		
		List<String> capitali1 = new Vector<String>();
		List<String> capitali2 = new Stack<String>();
		Collection<String> capitali3 = new LinkedList<String>();
		// da dopo java 7 si può omettere il secondo tipo
		
		capitali.add("Parigi");
		capitali.add("Roma");
		capitali.add("Berlino");
		capitali.add("Parigi");
		
		
		
		int totale = capitali.size();
		
		
		
		for (String capitale : capitali4) {
			System.out.println(capitale);
			
		}

	}

}
