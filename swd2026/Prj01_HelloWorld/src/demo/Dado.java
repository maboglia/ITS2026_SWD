package demo;

public class Dado {

	int facce;
	
	public Dado(int nFacce) {
		facce = nFacce;
	}
	
	public int lancia() {
		//deve ritornare un intero casuale compreso tra 1 e il nro di facce del dado
		
		double casuale = Math.random();
		int result = (int) (casuale * facce ) + 1;
		return result;
	}
	
}
