package it.starbay.gestionenavigazione;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;

/**
 * Servlet implementation class ServletRicercaProdotto
 */
@WebServlet("/ServletRicercaProdotto")
public class ServletRicercaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String chiave = request.getHeader("chiave");
		ArrayList prodotti = new ArrayList<>(); 
		
		ManagerNavigazione manager;
		try 
		{
			manager = new ManagerNavigazione();
			prodotti = manager.cercaProdotti(chiave);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		HttpSession sessione = request.getSession();
		sessione.setAttribute("prodotti_ricercati", prodotti);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
