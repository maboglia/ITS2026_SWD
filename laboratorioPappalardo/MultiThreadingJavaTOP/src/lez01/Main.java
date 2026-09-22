public class Main {

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Current thread name: " + threadName);

        System.out.println("############# Race start #############");

        RaceThread eclipse = new RaceThread("Eclipse", 1000);
        RaceThread pitone = new RaceThread("Pitone", 1500);

        eclipse.start();
        pitone.start();

        try {
            eclipse.join();
            pitone.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("############# Race stop #############");
    }
}
