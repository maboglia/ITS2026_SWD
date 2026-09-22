package lez02;

public class RaceThread implements Runnable {

	String nome;
	int time;
	
	public RaceThread(String nome, int time) {
		super();
		this.nome = nome;
		
		this.time = time;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			try {
				System.out.println("Sono il thread " + this.nome);
				System.out.println("Ho percorso " + (i + 1) + "mt");
				Thread.sleep(time);
				if (i == 3 && this.nome.equals("IntelliJ")) {
					throw new InterruptedException();
				}
				
			} catch (InterruptedException e) {
				System.err.println("Spiacenti si è verificata un'interruzione di corrente");
			}
			
		}
		
	}

	
	
}
