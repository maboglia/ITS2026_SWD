package tipi;

public class Booleano {

	public static void main(String[] args) {

		boolean isTrue = true;

		int counter = 0;
		
		while(isTrue) {

			counter++;
			System.out.println("Oggi mi girano " +  counter);
			
			double test = Math.random();
			
			if (test > 0.95) {
				break;
			}
		}


	}

}
