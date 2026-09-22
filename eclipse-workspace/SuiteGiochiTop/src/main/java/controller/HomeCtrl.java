package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//resp.getWriter().print("Hai chiamato la servlet via GET");
		
//		resp.sendRedirect("index.jsp");
		
		if (req.getParameter("pagina")!=null) {
			String pagina = req.getParameter("pagina");
			resp.getWriter().print("Hai richiesto la pagina: " + pagina);
		
		
		} else {
			
			req.getRequestDispatcher("index.jsp").include(req, resp);
			
		}
		
		
	}

	
	
}
