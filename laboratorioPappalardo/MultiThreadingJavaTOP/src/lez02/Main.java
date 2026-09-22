import lez02.RaceThread;

public class Main {
    public static void main(String[] args) {
        // Runnable eclipse = () -> new RaceThread("Eclipse", 1000);
        // Runnable pitone = () -> new RaceThread("Pitone", 1500);

        Thread t1 = new Thread(new RaceThread("Eclipse", 1000));
        Thread t2 = new Thread(new RaceThread("Pitone", 1500));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");

    }
}
