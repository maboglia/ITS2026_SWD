package fondamenti.codice;

public class Studente {
    
    String nome;
    String cognome;
    int oreLezione = 0;
    final String NOME_CORSO = "ITS SWD";

    void setOreLezione(int oreLezione){
        this.oreLezione += oreLezione;
    }

    String presentazione(){

        String dati = nome + " " + cognome + " ore lezione: " + oreLezione; 
        return dati;


    }

}
