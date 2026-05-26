package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Automobile;

@WebServlet({"/automobili", "/auto", "/cars"})
public class AutoSaloneCtrl extends HttpServlet {

	private AutomobiliCtrl autoCtrl = new AutomobiliCtrl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String titolo = "Le nostre ultime novità";
		request.setAttribute("sottotitolo", titolo);
		
		request.setAttribute("elenco", autoCtrl.getAutomobili());
		
		request.getRequestDispatcher("automobili.jsp").forward(request, response);


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if (request.getParameter("marca")!=null && request.getParameter("modello")!=null) {
			
			String marca = request.getParameter("marca");
			String modello = request.getParameter("modello");
			
			Automobile a= new Automobile("automobile", marca, modello);
			this.autoCtrl.addAutomobile(a);
			
		}
		
		doGet(request, response);
		
	}
	
	

	
	
}
