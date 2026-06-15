package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.NegozioServiceImpl;
import services.NegozioServices;

@WebServlet("/negozio")
public class NegozioMVC extends HttpServlet {
	
	private NegozioServices service;
	
	public NegozioMVC() {
	
		this.service = new NegozioServiceImpl();
		System.out.println("Negozio servlet costruito");
	}
	
	@Override // un solo doGet
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(this.service.getProdotti());
	}
	

}
