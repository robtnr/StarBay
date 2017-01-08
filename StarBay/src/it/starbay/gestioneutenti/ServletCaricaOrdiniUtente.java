package it.starbay.gestioneutenti;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletCaricaOrdiniUtente")
public class ServletCaricaOrdiniUtente extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ManagerUtenti mu = new ManagerUtenti();
		String username = request.getHeader("username");
		ArrayList<String> righe = mu.dammiOrdiniUtente(username);
		
		if (righe == null) response.addHeader("tbody", "nok");
		else
		{
			response.addHeader("totale", righe.get(0));
			righe.remove(0);
			
			String tbody = "";

			for(String tr: righe)
				tbody += tr;

			response.addHeader("tbody", tbody);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
