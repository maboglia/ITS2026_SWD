package esercizio_curriculum;

public class Curriculum {

    private String nome;
    private Job first;
    private Job last;

    public Curriculum(String nome) {
        this.nome = nome;
    }

    public Job addJob(String descrizione, int annoInizio) {

        Job nuovoJob = new Job(descrizione, annoInizio);

        if (first == null) {
            first = nuovoJob;
        } else {
            last.setNext(nuovoJob);
        }

        last = nuovoJob;

        return nuovoJob;
    }

    public String getNome() {
        return nome;
    }
}
