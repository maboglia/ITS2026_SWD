public class Chef extends Staff {

    public Chef(String name, String shift){
        super(name, shift);
    }

    public void cook(String dish){
        System.out.println(this.name + " cucina " + dish);
    }

    @Override
    public void work() {
        this.cook(name);
    }
}
