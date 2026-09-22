public abstract class Staff {

    protected String name;
    protected String shift;

    public Staff(String name, String shift){
        this.name = name;
        this.shift = shift;
    }

    public abstract void work();

}
