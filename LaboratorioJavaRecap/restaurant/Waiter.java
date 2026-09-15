
import java.util.ArrayList;
import java.util.List;

public class Waiter extends Staff {

    private List<Integer> tavoli;

    public Waiter(String name, String shift) {
        super(name, shift);
        this.tavoli = new ArrayList<>();
    }

    public void takeOrder() {
        System.out.println(name + " is taking  order");
    }

    public void assegnaTavolo(int i){
        this.tavoli.add(i);
    }

    public List<Integer> getTavoli() {
        return tavoli;
    }

    @Override
    public void work() {
        this.takeOrder();
    }


    
}