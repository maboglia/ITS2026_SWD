package demo;

import controller.AulaController;

public class AulaDemo {

	public static void main(String[] args) {

		AulaController ctrl = new AulaController();
		
//		ctrl.faiAppello();
//		
//		ctrl.writeFile("documenti/assenti.txt", ctrl.getAssenti());
//		ctrl.writeFile("documenti/presenti.txt", ctrl.getPresenti());
		
		System.out.println(ctrl.interrogaStudente());
		
		

	}

}
