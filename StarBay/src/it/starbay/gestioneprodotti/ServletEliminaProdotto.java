package it.starbay.gestioneprodotti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletEliminaProdotto
 */
@WebServlet("/ServletEliminaProdotto")
public class ServletEliminaProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String coordinate = request.getHeader("coordinate");
		String tipo = request.getHeader("tipo");
		HttpSession sessione = request.getSession();
		if(tipo.equals("stella"))
		{
			ManagerProdotti manager;
			try 
			{
				manager = new ManagerProdotti();
				manager.eliminaStella(coordinate);
				sessione.removeAttribute("carica_prodotti_stella");
			} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
