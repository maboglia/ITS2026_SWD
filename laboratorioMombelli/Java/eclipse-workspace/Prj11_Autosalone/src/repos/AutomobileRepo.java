package repos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Automobile;

public class AutomobileRepo {

	List<Automobile> automobili = new ArrayList<>();
	// ArrayList implements list
	// classe concreta
	
	public AutomobileRepo() {
		try {
			leggiFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void leggiFile() throws FileNotFoundException {
		
		File f = new File("veicoli/auto.csv");
		
		Scanner input = new Scanner(f);
		int i = 0;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (i == 0) {
				i++;
				continue;
			}
			
			line = line.replaceAll("\"", "");
			String[] splittaggio = line.split(",");
			String marca = splittaggio[0];
			String modello = splittaggio[1];
			int cilindrata = Integer.parseInt(splittaggio[2]);
			double prezzo = Double.parseDouble(splittaggio[3]);
			
			this.automobili.add(new Automobile(marca, modello, cilindrata, prezzo));
			//System.out.println(line);
			
		}
	}
	
	public static void main(String[] args) {
		try {
			AutomobileRepo ar = new AutomobileRepo();
			
			// scritto in pipeline
			List<Automobile> list = ar
				.automobili
				.stream()
				.filter(a -> a.getPrezzo() > 20_000)
				.sorted((a,b) -> Double.compare(a.getPrezzo(), b.getPrezzo()))
				.limit(3)
				//.forEach(a -> System.out.println(a));
				.toList();
			
			list.forEach(System.out::println);
//			for (Automobile a : ar.automobili) {
	//			System.out.println(a);
				
		//	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
