package enumerazioni;

public class TShirt {

	private double prezzo;
	private Colori colore;
	private Taglie taglia;
	public TShirt(double prezzo, Colori colore, Taglie taglia) {
		super();
		this.prezzo = prezzo;
		this.colore = colore;
		this.taglia = taglia;
	}
	
	public static void main(String[] args) {
		TShirt bianca = new TShirt(10, Colori.BLUE, Taglie.L);
		
		System.out.println(bianca.colore.getEsa());
	}
}
