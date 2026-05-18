package figure;

public class Quadrato extends Rettangolo {
	
	private Segmento lato;
	
	public Quadrato(Segmento lato) {
		// chiama il costruttore del genitore
		super(lato, lato);
		this.lato = lato;
	}

	
	@Override
	public double perimetro() {
		System.out.println("Metodo perimetro del quadrato");
		return lato.lunghezza() * 4;
	}


	@Override
	public double area() {
		System.out.println("Metodo area del quadrato");
		return Math.pow(lato.lunghezza(), 2);
	}


	@Override
	public String toString() {
		return "Quadrato [lato=" + lato + ", perimetro()=" + perimetro() + ", area()=" + area() + "]";
	}
	
	

}
