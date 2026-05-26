package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Automobile;

@WebServlet({"/automobili", "/auto", "/cars"}) //endpoint
public class AutoSaloneCtrl extends HttpServlet {
	// generica classe di comunicazioni tra due parti
	
	private AutomobiliCtrl autoCtrl = new AutomobiliCtrl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titolo = "Le nostre ultime novità";
		request.setAttribute("sottotitolo", titolo);
		
		request.setAttribute("elenco", autoCtrl.getAutomobili());
		
		//response.setContentType("text/html");
		//response.getWriter().print("<h1>automobili</h1>"); // strumento in grado di scrivere Writer
		request.getRequestDispatcher("automobili.jsp").forward(request, response); // forward inoltra la richiesta a automobili.jsp
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("marca")!= null && request.getParameter("modello")!= null) {
			
			
			String marca = request.getParameter("marca");
			String modello = request.getParameter("modello");
			
			Automobile a = new Automobile("automobile", marca, modello);
			this.autoCtrl.addAutomobile(a);
		}
		
		doGet(request,response);
	}
	
	
	

}
