package types;

public class Integer {

	public static void main(String[] args) {
		
		byte pippo = -128; // controllo a tempo di compilazione 
		// se scrivo -129 dà errore già in fase di scrittura
		short pippo2 = -12800;
		int pippo3 = -1_290_000_000;
		long pippo4 = -12_900_000_000L; // devo specificare L perché sennò lo vede come int
		// con quelli prima non c'è bisogno perché il byte ci sta nell'int,
		// anche lo short ci sta dentro l'int, mentre long no, quindi devo specificarlo
		
		System.out.println(pippo);
		System.out.println(pippo2);
		System.out.println(pippo3);
		System.out.println(pippo4);
	}

}
