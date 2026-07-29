package esercizio_curriculum;

public class Job {

    private String descrizione;
    private int annoInizio;
    private Job next;

    public Job(String descrizione, int annoInizio) {
        this.descrizione = descrizione;
        this.annoInizio = annoInizio;
    }

    public Job next() {
        return next;
    }

    public void setNext(Job next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return descrizione + ": " + annoInizio;
    }
}

