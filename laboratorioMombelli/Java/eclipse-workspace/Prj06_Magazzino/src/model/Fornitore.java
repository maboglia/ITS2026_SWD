package model;

public class Fornitore {

	private int idFornitore;
    private String ragioneSociale;
    private String citta;
    private String email;
	
    public Fornitore() {
		// serve a springboot
    	// overload avere due funzioni con lo stesso nome nello stesso file
	}
    
    public Fornitore(int idFornitore, String ragioneSociale, String citta, String email) {
		this.idFornitore = idFornitore;
		this.ragioneSociale = ragioneSociale;
		this.citta = citta;
		this.email = email;
	}

	public int getIdFornitore() {
		return idFornitore;
	}

	public void setIdFornitore(int idFornitore) {
		this.idFornitore = idFornitore;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Fornitore [idFornitore=" + idFornitore + ", ragioneSociale=" + ragioneSociale + ", citta=" + citta
				+ ", email=" + email + "]";
	}
    
    
    
    
}
