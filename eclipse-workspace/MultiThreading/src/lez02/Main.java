package lez02;

import lez02.RaceThread;

public class Main {

	public static void main(String[] args) {

//		Runnable eclipse = new RaceThread("Eclipse", 1000);
		
		System.out.println("Start");
		Thread t1 = new Thread(new RaceThread("Eclipse", 1000));
		t1.start();
		Thread t2 = new Thread(new RaceThread("IntelliJ", 3000));
		t2.start();

		try {
		t1.join();
		t2.join();
		} catch (InterruptedException e) {
			System.err.println("Interruzione del main thread");
		}
		System.out.println("Stop");
		
	}

}
