import java.util.ArrayList;
import java.util.List;

public class Waiter extends Staff {

    private String name;
    private List<Integer> tavoli;

    //public Waiter(String name){
    //    this.name = name;
    //    this.tavoli = new ArrayList<>();
    //}

    public Waiter(String name){
        super(name, "mattina");
        this.tavoli = new ArrayList<>();
    }

    public void takeOrder(){
        System.out.println(name + " prende l'ordine");
    }

    public void assegnaTavolo(int i){
        this.tavoli.add(i);
    }

    public List<Integer> getTavoli(){
        return tavoli;
    }

    @Override 
    public void work() {
        this.takeOrder();
    }
}
