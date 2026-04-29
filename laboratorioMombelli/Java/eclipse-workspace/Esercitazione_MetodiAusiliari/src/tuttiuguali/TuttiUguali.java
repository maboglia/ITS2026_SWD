package tuttiuguali;

public class TuttiUguali {
	
	int Numero1;
	int Numero2;
	int Numero3;
	
	public void setNumero1(int Numero1) {
		this.Numero1 = Numero1;
	}
	public void setNumero2(int Numero2) {
		this.Numero2 = Numero2;		
	}
	public void setNumero3(int Numero3) {
		this.Numero3 = Numero3;		
	}
	
	public String Stampa(boolean uguaglianza) {
		if (uguaglianza) {
			return "TuttiUguali";
		}
		return "Almeno uno è diverso";
	}

}
