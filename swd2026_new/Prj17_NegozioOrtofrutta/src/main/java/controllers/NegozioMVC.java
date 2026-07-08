package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.NegozioService;
import services.NegozioServiceImpl;

@WebServlet({"/negozio", "/store"})
public class NegozioMVC extends HttpServlet {

	
	private NegozioService service;
	
	public NegozioMVC() {
		this.service = new NegozioServiceImpl();
		System.out.println("Negozio servlet costruita");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("prodotti", this.service.getProdotti());
		req.getRequestDispatcher("prodotti.jsp").forward(req, resp);
		
		System.out.println("Chiamata al metodo GET");
		System.out.println(this.service.getProdotti());
	}
	
}
