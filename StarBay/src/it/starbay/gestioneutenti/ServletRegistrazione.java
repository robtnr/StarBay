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
 * Servlet implementation class ServletRegistrazione
 */
@WebServlet("/ServletRegistrazione")
public class ServletRegistrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		comune = request.getParameter("comune");
		indirizzo = request.getParameter("indirizzo");
		email = request.getParameter("email");
		username = request.getParameter("username");
		password = request.getParameter("password");
		iban = request.getParameter("iban");
		System.out.println(email);
		System.out.println(nome);
		Cliente cliente = creazioneBeanCliente();
		ManagerUtenti manager;
		try 
		{
			manager = new ManagerUtenti();
			manager.registraUtente(cliente);
		} catch (ClassNotFoundException | SQLException e) 
		{

			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	public Cliente creazioneBeanCliente()
	{
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCognome(cognome);
		cliente.setComune(comune);
		cliente.setIndirizzo(indirizzo);
		cliente.setEmail(email);
		cliente.setUsername(username);
		cliente.setPassword(password);
		cliente.setIban(iban);
		return cliente;
	}
	private String nome;
	private String cognome;
	private String comune;
	private String indirizzo;
	private String email;
	private String username;
	private String password;
	private String iban;
	private HttpSession sessione;
	
}
