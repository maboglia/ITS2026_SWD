package lez01;

public class Main {

	public static void main(String[] args) {

		String name = Thread.currentThread().getName();
		System.out.println("Il nome del thread: " + name);
		System.out.println("#########Race start#######");
		
		RaceThread eclipse = new RaceThread("Eclipse", 1000);
		RaceThread pitone = new RaceThread("Python", 2000);
		
		eclipse.start();
		pitone.start();
		
		try {
			eclipse.join();
			pitone.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("#########Race stop#######");
		
	}

}
