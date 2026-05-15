package repos;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductRepoImpl implements ProductRepo {
	// devo implementare per forza i metodi che ci sono nelle interfacce
	
	private List<Product> products = new ArrayList<>();
	
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts() {
		
		// query al DB
		// scorro il resultSET
		// per ogni record creo un oggetto di tipo prodotto
		
		
		// aggiungo il prodotto alla lista di prodotti
		products.add(new Product(1, "Bici", "Rossa", 150, 10));
		products.add(new Product(2,"T-shirt Uomo Cotone", "Uomo", 19.99, 50));
		products.add(new Product(3,"T-shirt Uomo Cotone", "Uomo", 19.99, 50));
		products.add(new Product(4,"Giacca Uomo Invernale", "Uomo", 79.99, 30));
		products.add(new Product(5,"Pantaloni Uomo Slim", "Uomo", 39.99, 40));
		products.add(new Product(6,"Maglione Donna Cashmere", "Donna", 99.99, 20));
		products.add(new Product(7,"Gonna Donna Estate", "Donna", 34.99, 25));
		// ritorno la lista di prodotti
		return products;
	}

	@Override
	public Product addProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
