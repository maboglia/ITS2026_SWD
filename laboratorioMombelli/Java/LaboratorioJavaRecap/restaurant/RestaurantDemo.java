
import java.util.ArrayList;
import java.util.List;

public class RestaurantDemo {

    public static void main(String[] args) {

        Waiter roberto = new Waiter("Roberto");
        Waiter simona = new Waiter("Simona");
        Chef federico = new Chef("Federico", "mattina");


        List<Staff> staff = new ArrayList<>();

        staff.add(roberto);
        staff.add(simona);
        staff.add(federico);
        

        staff.forEach(Staff::work);
        //roberto.takeOrder();
        //simona.takeOrder();
//
        //roberto.assegnaTavolo(1);
        //roberto.assegnaTavolo(2);  
        //roberto.assegnaTavolo(3);
//
        //simona.assegnaTavolo(4);
        //simona.assegnaTavolo(5);
//
//
        //roberto.takeOrder();
        //simona.takeOrder();

        System.out.println("Tavoli di Roberto: " + roberto.getTavoli());
        System.out.println("Tavoli di Simona: " + simona.getTavoli());

        federico.cook("Pasta al pomodoro");
    }
}
