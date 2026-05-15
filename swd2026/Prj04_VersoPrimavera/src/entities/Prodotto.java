package entities;

public class Prodotto {

	private int id;
	private String nome;
	private String categoria;
	private double prezzo;
	private int giacenza;
	
	/**
	 * Costruttore del prodotto senza argomenti
	 */
	public Prodotto() {}

	/**
	 * Costruttore del prodotto 3 args
	 * @param nome inserire il nome del prodotto
	 * @param prezzo inserire il prezzo con il separatore '.'
	 * @param giacenza inserire la giacenza...
	 */
	public Prodotto(String nome, double prezzo, int giacenza) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.giacenza = giacenza;
		this.id = 0;
		this.categoria = "Articoli vari";
	}

	public Prodotto(int id, String nome, String categoria, double prezzo, int giacenza) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.prezzo = prezzo;
		this.giacenza = giacenza;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}

	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", prezzo=" + prezzo + ", giacenza=" + giacenza + "]";
	}
	
	
	
	
	
}
