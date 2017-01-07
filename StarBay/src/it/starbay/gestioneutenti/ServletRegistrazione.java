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
		nome = request.getHeader("nome");
		cognome = request.getHeader("cognome");
		comune = request.getHeader("comune");
		indirizzo = request.getHeader("indirizzo");
		email = request.getHeader("email");
		username = request.getHeader("username");
		password = request.getHeader("password");
		iban = request.getHeader("iban");
		Cliente cliente = creazioneBeanCliente();
		ManagerUtenti manager;
		try 
		{
			manager = new ManagerUtenti();
			if(manager.registraUtente(cliente))
				response.setHeader("errore","true");
			else
				response.setHeader("errore","false");
		} catch (Exception e) 
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
