package it.starbay.gestioneutenti;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starbay.gestionebean.Cliente;


@WebServlet("/ServletCaricaUtenti")
public class ServletCaricaUtenti extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ManagerUtenti mu = new ManagerUtenti();
		ArrayList<Cliente> clienti = mu.dammiClienti();
		System.out.println("ok");
		if (clienti.isEmpty()) response.addHeader("tbody", "nok");
		else
		{
			String tbody = "";

			for(Cliente c: clienti)
				tbody += "<tr><td>" + c.getCognome() + "</td><td>" + c.getNome() + "</td><td>" + c.getUsername() + "</td><td>" + c.getEmail() + "</td></tr>";

			response.addHeader("tbody", tbody);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
