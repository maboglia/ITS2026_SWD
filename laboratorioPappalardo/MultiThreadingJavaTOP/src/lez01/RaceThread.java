public class RaceThread extends Thread {
    private String threadName;
    private int time;

    public RaceThread(String name, int time) {
        this.threadName = name;
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Thread " + threadName + " - Iteration: " + i);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
