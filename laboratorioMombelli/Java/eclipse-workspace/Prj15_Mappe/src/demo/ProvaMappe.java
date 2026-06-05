package demo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProvaMappe {

	public static void main(String[] args) {

		Map<String, String> regioni = new HashMap<String, String>();
		
		regioni.put("Piemonte", "Torino");
		regioni.put("Lombardia", "Milano");
		regioni.put("Liguria", "Genova");
		
		Set<String> keySet = regioni.keySet(); // esclusivo, non si può ripetere
		
		Collection<String> values = regioni.values();
		
		Set<Entry<String, String>> entrySet = regioni.entrySet();
		
		for (var x : values) {
			
			System.out.println(x);
			
		}
		
	}

}
