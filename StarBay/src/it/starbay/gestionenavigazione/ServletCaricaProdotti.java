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
 * Servlet implementation class ServletCaricaProdotti
 */
@WebServlet("/ServletCaricaProdotti")
public class ServletCaricaProdotti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sessione = request.getSession();
		if(request.getAttribute("mex_carica").equals("stella"))
		{
			try 
			{
				ManagerNavigazione manager = new ManagerNavigazione();
				ArrayList<Stella> carica_prodotti_stella = manager.caricaProdotti("stella");
				sessione.setAttribute("carica_prodotti_stella", carica_prodotti_stella);
				if(request.getAttribute("pagina").equals("modifica"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("modifica_prodotto_stella.jsp");
					rd.forward(request, response);
				}
				else if(request.getAttribute("pagina").equals("elimina"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("elimina_prodotto_stella.jsp");
					rd.forward(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}	
		}
		else
		{
			try 
			{
				ManagerNavigazione manager = new ManagerNavigazione();
				ArrayList<Store> carica_prodotti_store = manager.caricaProdotti("store");
				sessione.setAttribute("carica_prodotti_store", carica_prodotti_store);
				
				if(request.getAttribute("pagina").equals("modifica"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("modifica_prodotto_store.jsp");
					rd.forward(request, response);
				}
				else if(request.getAttribute("pagina").equals("elimina"))
				{
					RequestDispatcher rd = request.getRequestDispatcher("elimina_prodotto_store.jsp");
					rd.forward(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
