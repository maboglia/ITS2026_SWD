
import java.util.List;

public class TestPredicate {


    public static void main(String[] args) {
        
        List.of("fragole", "banane", "lamponi", "mele")
            .stream()
            .filter( t->t.length() > 4)
            .forEach(t -> System.out.println(t));
    }




}
