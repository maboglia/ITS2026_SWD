package repos;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public interface ProductRepo {
	// interfaccia è come se fosse un'estremizzazione della classe astratta
	// metodo delle interfacce sono public
	Product getProductById(int id);
	List<Product> getProducts();
	Product addProduct(Product p);
	Product updateProduct(Product p);
	void deleteProduct(int id);


}
