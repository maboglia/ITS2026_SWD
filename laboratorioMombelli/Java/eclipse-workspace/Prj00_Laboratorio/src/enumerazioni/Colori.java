package enumerazioni;

public enum Colori {

	RED ("#FF0000"), GREEN("#00FF00"), BLUE("#0000FF");
	
	String esa;

	private Colori(String esa) {
		this.esa = esa;
	}
	public String getEsa(){
		return "ciao";
		
	}
	
	
	
}
