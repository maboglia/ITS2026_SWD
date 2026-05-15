package presentation;

import entities.Product;
import services.ProductsService;
import services.ProductsServiceImpl;

public class WarehouseMVC {
	
	public static void main(String[] args) {
		
		ProductsService service = new ProductsServiceImpl();
		
		for (Product p : service.findAll()) {
			System.out.println(p);
		}
	}

}
