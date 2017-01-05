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
 * Servlet implementation class ServletCaricaProdottiStella
 */
@WebServlet("/ServletCaricaProdottiStella")
public class ServletCaricaProdottiStella extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sessione = request.getSession();
		
			ManagerNavigazione manager;
			try 
			{
				manager = new ManagerNavigazione();
				ArrayList<Stella> stelle = manager.caricaProdottiStella();
				sessione.setAttribute("stelle",stelle);
			} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("stelle.jsp");
			rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
