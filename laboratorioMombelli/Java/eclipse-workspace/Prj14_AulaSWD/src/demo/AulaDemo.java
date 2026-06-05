package demo;

import controller.AulaController;
import repos.StudenteRepo;
import repos.StudenteRepoImpl;

public class AulaDemo {

	public static void main(String[] args) {
		
		AulaController ctrl = new AulaController();
		
		ctrl.faiAppello();
		
		ctrl.writeFile("documenti/assenti.txt", ctrl.getAssenti());
		ctrl.writeFile("documenti/presenti.txt", ctrl.getPresenti());
		
		

	}

}
