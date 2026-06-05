package model;

public class Comune {
	
	private String nome;

	public Comune () {}
	public Comune(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Comune [nome=" + nome + "]";
	}
	
	

}
