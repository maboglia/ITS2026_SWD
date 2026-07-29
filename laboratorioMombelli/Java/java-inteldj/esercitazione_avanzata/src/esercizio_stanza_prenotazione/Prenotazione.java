package esercizio_stanza_prenotazione;

public class Prenotazione {
    private String utente;
    private Integer dataInizio;
    private Integer dataFine;

    public Prenotazione(String utente, Integer dataInizio, Integer dataFine) {
        this.utente = utente;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public Integer getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Integer dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Integer getDataFine() {
        return dataFine;
    }

    public void setDataFine(Integer dataFine) {
        this.dataFine = dataFine;
    }

    public String getName() {
        return this.utente;
    }
}
