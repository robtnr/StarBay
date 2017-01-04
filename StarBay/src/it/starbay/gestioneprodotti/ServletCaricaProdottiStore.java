package it.starbay.gestioneprodotti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;
import it.starbay.gestionenavigazione.ManagerNavigazione;

/**
 * Servlet implementation class ServletCaricaProdottiStore
 */
@WebServlet("/ServletCaricaProdottiStore")
public class ServletCaricaProdottiStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession sessione = request.getSession();
		
		ManagerNavigazione manager;
		try 
		{
			manager = new ManagerNavigazione();
			ArrayList<Store> prodotti_store = manager.caricaProdottiStore();
			sessione.setAttribute("prodotti_store",prodotti_store);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("store.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
