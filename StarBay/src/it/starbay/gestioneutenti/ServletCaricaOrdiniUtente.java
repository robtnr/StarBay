package it.starbay.gestioneutenti;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.Ordine;


@WebServlet("/ServletCaricaOrdiniUtente")
public class ServletCaricaOrdiniUtente extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ManagerUtenti mu = new ManagerUtenti();
		HttpSession session = request.getSession();
		Cliente c = (Cliente) session.getAttribute("cliente");
		ArrayList<Ordine> ordini = mu.dammiOrdiniUtente(c.getUsername());
		session.setAttribute("ordini", ordini);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
