package esercizio_stanza_prenotazione;

public class ProvaEserc2 {

    public static void main(String[] args) {
        Stanza r = new Stanza();
        Prenotazione p1 = r.riserva("Mario Rossi", 105, 120);
        Prenotazione p2 = r.riserva("Giuseppe Verdi", 5, 20);
        Prenotazione p3 = r.riserva("Brad Pitt", 20, 22);
        Prenotazione p4 = r.riserva("Angiolina Jolie", 200, 222);
        for (Prenotazione p : r.prenotazioni(p1,p2,p3,p4)) {
            System.out.println(p.getName());
        }
    }

}
