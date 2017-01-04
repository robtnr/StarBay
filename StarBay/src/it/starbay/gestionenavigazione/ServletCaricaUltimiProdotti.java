package it.starbay.gestionenavigazione;

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

/**
 * Servlet implementation class ServletCaricaUltimiProdotti
 */
@WebServlet("/ServletCaricaUltimiProdotti")
public class ServletCaricaUltimiProdotti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sessione = request.getSession();
		try 
		{
			ManagerNavigazione manager = new ManagerNavigazione();
			ArrayList<Stella> stelle = manager.caricaUltimiProdotti("stella");
			ArrayList<Store> prodotti_store = manager.caricaUltimiProdotti("store");
			
			sessione.setAttribute("stelle_ultimi_prodotti",stelle);
			sessione.setAttribute("store_ultimi_prodotti",prodotti_store);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
 		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
