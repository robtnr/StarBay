package it.starbay.gestioneutenti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Cliente;


/**
 * Servlet Login Utente
 * Servlet che viene richiamata quando un utente tenta di fare il login
 */
@WebServlet("/ServletLoginUtente")
public class ServletLoginUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		username = request.getHeader("username");
		password = request.getHeader("password");
		sessione = request.getSession();
		if(username.equals("admin") && password.equals("admin"))
		{
			response.setHeader("esito_login","admin");
			System.out.println("admin");
		}
		else
		{
			ManagerUtenti manager;
			try 
			{
				System.out.println("entrato");
				manager = new ManagerUtenti();
				Cliente cliente = manager.controlloCredenziali(username, password);
				if(cliente.getNome().equals("none"))
				{
					response.setHeader("esito_login", "false");
				}
				else
				{
					response.setHeader("esito_login","true");
					sessione.setAttribute("cliente", cliente);
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
	
	private String password;
	private String username;
	private HttpSession sessione;
}
