package lez01;

public class RaceThread extends Thread {

	String nome;
	int time;
	
	public RaceThread(String nome, int time) {
		super();
		this.nome = nome;
		this.setName(nome);
		this.time = time;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			
			try {
				System.out.println("Sono il thread " + this.nome);
				System.out.println("Ho percorso " + (i + 1) + "mt");
				this.sleep(time);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	
	
}
