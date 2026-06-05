package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Studente;
import repos.StudenteRepo;
import repos.StudenteRepoImpl;

public class AulaController {
	
	private StudenteRepo repo = new StudenteRepoImpl();
	private List<Studente> presenti = new ArrayList<Studente>();
	private List<Studente> assenti = new ArrayList<Studente>();
	
	public List<Studente> getStudenti(){
		return repo.getStudenti();
		
	}
	
	public List<Studente> getStudentiByCognome(){
		return repo.getStudenti().stream().sorted().toList();
	}
	
	public Studente interrogaStudente() {
		
		Random r = new Random();
		return repo.getStudenti().get(r.nextInt(repo.getStudenti().size()));
	}
	
	public void faiAppello() {
		Scanner input = new Scanner(System.in);
		
		for (Studente s : getStudenti()) {
			System.out.println("E' presente lo studente?");
			System.out.println(s.getCognome());
			
			String risposta = input.nextLine();
			
			if (risposta.equalsIgnoreCase("N")){
				assenti.add(s);
			}else {
				presenti.add(s);
			}
			
		}
		input.close();
	}
	
	public void writeFile(String fileName, List<Studente> studenti) {
		try {
			PrintWriter output = new PrintWriter(new File(fileName));
			
			output.println("-------------------");
			output.println("Appello del: " + LocalDateTime.now());
			output.println("-------------------");
			
			
			for (Studente studente : studenti) {
				output.println(studente);
				
			}
			output.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Studente> getAssenti(){
		return assenti;
	}
	public List<Studente> getPresenti(){
		return presenti;
	}

}
