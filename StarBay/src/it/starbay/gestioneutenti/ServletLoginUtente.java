package it.starbay.gestioneutenti;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starbay.gestionebean.CallDatabase;

/**
 * Servlet Login Utente
 * Servlet che viene richiamata quando un utente tenta di fare il login
 */
@WebServlet("/ServletLoginUtente")
public class ServletLoginUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		CallDatabase db = new CallDatabase();
		System.out.println(db.ciao());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
