package services;

import java.util.List;

import entities.Product;
import repos.ProductRepo;
import repos.ProductRepoImpl;

public class ProductsServiceImpl implements ProductsService {

	ProductRepo repo = new ProductRepoImpl();
	
	@Override
	public List<Product> findAll(){
		// è il service che parla con il repo
		return repo.getProducts();
	}
}
