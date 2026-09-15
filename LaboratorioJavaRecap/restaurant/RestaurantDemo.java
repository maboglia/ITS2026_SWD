
import java.util.ArrayList;
import java.util.List;

public class RestaurantDemo {

    public static void main(String[] args) {
        
        Waiter roberto = new Waiter("roberto", "night");
        Waiter simona = new Waiter("simona", "night");
        Chef federico = new Chef("federico", "night");

        List<Staff> staff = new ArrayList<>();

        staff.add(roberto);
        staff.add(simona);
        staff.add(federico);

        for (Staff member : staff) {
            member.work();
        }

        // roberto.takeOrder();
        // simona.takeOrder();

        // roberto.assegnaTavolo(1);
        // roberto.assegnaTavolo(2);
        // roberto.assegnaTavolo(4);

        // simona.assegnaTavolo(3);
        // simona.assegnaTavolo(5);

        // roberto.getTavoli().forEach(System.out::println);
        // simona.getTavoli().forEach(System.out::println);

        // federico.work();
        // federico.cook("spaghetti");
        // roberto.work();

    }


}
