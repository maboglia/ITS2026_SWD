package scatole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class DemoSet {

	public static void main(String[] args) {
		
		String[] oldCities = {"Madrid", "Lisbona"};
		
		
		TreeSet<String> capitali = new TreeSet<>(Arrays.asList(oldCities));

		capitali.add("Parigi");
		capitali.add("Roma");
		capitali.add("Berlino");
		capitali.add("Parigi");

		
		
		int totale = capitali.size();
		
		
		
		for (String capitale : capitali) {
			System.out.println(capitale);
		}
		
		
		
		
	}

}
