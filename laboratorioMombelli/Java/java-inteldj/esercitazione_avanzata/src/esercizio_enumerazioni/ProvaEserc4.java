package esercizio_enumerazioni;

public class ProvaEserc4 {

    public static void main(String[] args) {

        Status a = Status.BUSY;
        Status b = Status.HIDDEN;

        System.out.println(a.isVisible());
        System.out.println(a.canContact(b));
    }
}
