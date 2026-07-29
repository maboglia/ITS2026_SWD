package esercizio_curriculum;

public class ProvaEserc3 {

    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Umberto Eco");

        Job j1 = cv.addJob("Insegnante", 1980);
        Job j2 = cv.addJob("Scrittore", 1990);
        Job j3 = cv.addJob("Linguista", 2000);

        System.out.println(j2.next());
        System.out.println(j3.next());
    }
}
