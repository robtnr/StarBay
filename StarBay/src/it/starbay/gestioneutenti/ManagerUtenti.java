package it.starbay.gestioneutenti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Cliente;

public class ManagerUtenti 
{
	private CallDatabase db;
	private Connection connection;
	private PreparedStatement inserter;
	private Statement statement;
	private ResultSet result;

	public ManagerUtenti()
	{
		try 
		{
			db = new CallDatabase();
			connection = db.getConnection();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public boolean registraUtente(Cliente c)
	{
		boolean errore=false;
		String query = "INSERT INTO UTENTI VALUES(?,?,?,?,?,?,?,?)";
		try {
			inserter = connection.prepareStatement(query);
			inserter.setString(1, c.getEmail());
			inserter.setString(2, c.getNome());
			inserter.setString(3, c.getCognome());
			inserter.setString(4, c.getComune());
			inserter.setString(5, c.getIndirizzo());
			inserter.setString(6, c.getUsername());
			inserter.setString(7, c.getPassword());
			inserter.setString(8, c.getIban());
			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} catch (SQLException e) 
		{

			errore=true;
		}
		return errore;
	}

	public Cliente controlloCredenziali(String username,String password)
	{
		Cliente cliente= new Cliente();
		cliente.setNome("none");
		try 
		{
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM UTENTI");
			while(result.next())
			{			
				if(username.equals(result.getString(6)) && password.equals(result.getString(7)))
				{
					cliente.setEmail(result.getString(1));
					cliente.setNome(result.getString(2));
					cliente.setCognome(result.getString(3));
					cliente.setComune(result.getString(4));
					cliente.setIndirizzo(result.getString(5));
					cliente.setUsername(result.getString(6));
					cliente.setPassword(result.getString(7));
					cliente.setIban(result.getString(8));
				}
			}
			statement.close();
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return cliente;
	}

	public ArrayList<String> dammiOrdiniUtente(String username) 
	{
		ArrayList<String> righe = new ArrayList<String>();
		try
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT idOrdine, nome, prezzo, quantitaAcquistata FROM ORDINI NATURAL JOIN DETTAGLI_ORDINI NATURAL JOIN INCLUDE_STELLE NATURAL JOIN STELLE WHERE username = "+username);

			while(result.next())
				righe.add("<tr><td>" + result.getString(1) + "</td><td>" + result.getString(2) + "</td><td>" + result.getString(3) + "</td><td>" + result.getString(4) + "</td></tr>");

			result = statement.executeQuery("SELECT idOrdine, nome, prezzo, quantitaAcquistata FROM ORDINI NATURAL JOIN DETTAGLI_ORDINI NATURAL JOIN INCLUDE_STORE NATURAL JOIN STORE WHERE username = "+username);

			while(result.next())
				righe.add("<tr><td>" + result.getString(1) + "</td><td>" + result.getString(2) + "</td><td>" + result.getString(3) + "</td><td>" + result.getString(4) + "</td></tr>");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		if (righe.isEmpty()) return null;

		return righe;
	}

	public ArrayList<Cliente> dammiClienti() 
	{
		ArrayList<Cliente> clienti = new ArrayList<>();
		Cliente c = new Cliente();
		try
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT cognome, nome, username, email FROM UTENTI");

			while(result.next())
			{
				c.setCognome(result.getString(1));
				c.setNome(result.getString(2));
				c.setUsername(result.getString(3));
				c.setEmail(result.getString(4));
				clienti.add(c);
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return clienti;
	}
}
