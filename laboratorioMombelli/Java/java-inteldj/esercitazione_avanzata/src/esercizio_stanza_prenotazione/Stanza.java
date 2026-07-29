package esercizio_stanza_prenotazione;

import java.util.List;

public class Stanza {

    public List<Prenotazione> prenotazioni(Prenotazione p1,Prenotazione p2,Prenotazione p3,Prenotazione p4){
        return List.of(p1,p2,p3,p4);
    };

    public Prenotazione riserva(String nome, Integer startAt, Integer endAt){
        Prenotazione p = new Prenotazione(nome, startAt, endAt);
        return p;
    }


}
