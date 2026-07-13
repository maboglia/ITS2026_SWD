package model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Bicicletta {

    public static final String MARCA = "Bianchi";
    private String modello;
    private double prezzo;

    private final int RUOTE = 2;

	public Bicicletta(String modello, double prezzo) {
		this.modello = modello;
		this.prezzo = prezzo;
	}
	
	public Bicicletta(double prezzo) {
		this.modello = "City Bike";
		this.prezzo = prezzo;
	}
    
	public static void main(String[] args) {
		Bicicletta bici1 = new Bicicletta("MTB", 500);
		Bicicletta bici2 = new Bicicletta("MTB", 500);
		Bicicletta bici3 = new Bicicletta("MTB", 500);
		Bicicletta bici4 = new Bicicletta("MTB", 500);
		
		System.out.println(bici1 instanceof Bicicletta);
		
		System.out.println(bici1.getClass().getSimpleName());
		
		Constructor<?>[] constructors = bici1.getClass().getConstructors();
		
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		
		Field[] fields = bici1.getClass().getFields();
		
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		List<Bicicletta> biciclette  = new ArrayList<>(); 
		
		
	}
}


