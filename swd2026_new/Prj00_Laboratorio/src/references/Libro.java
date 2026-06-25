package references;

public abstract class Libro extends Object {

	private static int contatoreLibri = 1;
	
	private int id;//0
	private String titolo;//null
	private int pagine;//0
	protected Genere genere;
	
	public Libro() {
		this.id = contatoreLibri++;
	}
	
	public Libro(String titolo, int pagine) {
		this();
		this.titolo = titolo;
		this.pagine = pagine;
	}

	public int getId() {
		return id;
	}

	
	
//	public void setId(int id) {
//		this.id = id;
//	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Libro [id=");
		builder.append(id);
		if (genere != null) {
			builder.append(", genere=");
			builder.append(genere);
		}
		builder.append(", titolo=");
		builder.append(titolo);
		builder.append(", pagine=");
		builder.append(pagine);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
