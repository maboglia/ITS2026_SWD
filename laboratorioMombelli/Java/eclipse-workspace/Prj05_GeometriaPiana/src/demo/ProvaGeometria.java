package demo;

import figure.Punto;
import figure.Quadrato;
import figure.Rettangolo;
import figure.Segmento;
import figure.Triangolo;

public class ProvaGeometria {
	
	public static void main(String[] args) {
		
		Punto a = new Punto(3, 2);
		Punto b = new Punto(7, 2);
		Punto c = new Punto(3, 5);
		
		System.out.println("Il punto a: " +a);
		System.out.println("Il punto b: " +b);
		System.out.println("Il punto c: " +c);
		
		Segmento ab = new Segmento(a, b);
		Segmento ac = new Segmento(a, c);
		Segmento bc = new Segmento(b, c);
		
		System.out.println(ab);
		System.out.println(ac);
		System.out.println(bc);
		
		Triangolo t = new Triangolo(a, b, c);
		System.out.println(t);
		
		Rettangolo r = new Rettangolo(ab, ac);
		System.out.println(r);
		
		Quadrato q = new Quadrato(ab);
		System.out.println(q);
				
	}

}
