package fondamenti.codice;

public class StudenteDemo {
    
    public static void main(String[] args) {
        
        Studente s1 = new Studente();
        Studente s2 = new Studente();

        s1.nome = "Federico";
        s1.cognome = "Grimaldi";
        s1.setOreLezione(4);

        s2.nome = "Caterina";
        s2.cognome = "Seccia";
        s2.setOreLezione(8);

        System.out.println(s1.presentazione());

        System.out.println(s2.presentazione());






    }

}
