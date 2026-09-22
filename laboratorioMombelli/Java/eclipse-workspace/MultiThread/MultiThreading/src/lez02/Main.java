package lez02;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Start!!!!!!!");
		//Runnable eclipse = new RaceThread("Eclipse", 1000);
		Thread t1 = new Thread(new RaceThread("Eclipse", 1000));
		t1.start();
		Thread t2 = new Thread(new RaceThread("IntellJ", 3000));
		t2.start();
		
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stop!!!!!!!");

	}

}
