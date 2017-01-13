package it.starbay.gestioneacquisti;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.Ordine;
import it.starbay.gestioneutenti.ManagerUtenti;

/**
 * ServletCaricaOrdiniUtente
 * Classe control che gestisce il caricamento degli ordini di un utente
 */
@WebServlet("/ServletCaricaOrdiniUtente")
public class ServletCaricaOrdiniUtente extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		ManagerAcquisti ma = new ManagerAcquisti();
		Cliente c = (Cliente) session.getAttribute("cliente");
		ArrayList<Ordine> ordini = ma.dammiOrdiniUtente(c.getUsername());
		session.setAttribute("ordini", ordini);
		RequestDispatcher disp = request.getRequestDispatcher("/profilo_utente.jsp");
		disp.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
