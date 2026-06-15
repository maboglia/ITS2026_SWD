package references;

public abstract class Libro {
	
	private static int contatoreLibri = 0;
	
	
	private int id; // 0
	private String titolo; // null
	private int pagine; // 0
	protected Genere genere;
	
	
	public Libro() {
		
		this.id = contatoreLibri++;
	}

	public Libro(String titolo, int pagine) {
		this();
		this.titolo = titolo;
		this.pagine = pagine;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public int getId() {
		return id;
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
		builder.append(", titolo=");
		builder.append(titolo);
		builder.append(", pagine=");
		builder.append(pagine);
		if (genere != null){
			builder.append(", genere=");
			builder.append(genere);
		}
		builder.append("]");
		return builder.toString();
	}
	

	
	
	

}
