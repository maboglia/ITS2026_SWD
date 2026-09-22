
import java.util.List;

public class TestPredicate{
    public static void main(String[] args){

        

        //Predicate filtro = new Predicate<String>(){
        //    @Override 
        //    public boolean test(String t){
        //        System.out.println(t);
        //    }
//
        //};
//
        //Consumer stampa = new Consumer<String>(){
        //    @Override
        //    public void accept(String t){
        //        System.out.println(t);
        //    }
        //};

       // Consumer<String> stampa =  t -> System.out.println(t);

        List.of("Mela", "Banana", "Pera", "Arancia", "Kiwi")
            .stream()
            .filter(t -> t.length() > 4)
            .forEach(t -> System.out.println(t));
    }
}