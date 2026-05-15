package presentation;

import entities.Prodotto;
import services.ProdottiService;
import services.ProdottiServiceImpl;

public class MagazzinoMVC {

	public static void main(String[] args) {
		
		ProdottiService service = new ProdottiServiceImpl();
		
		for (Prodotto p : service.findaAll()) {
			System.out.println(p);
		}

	}

}
