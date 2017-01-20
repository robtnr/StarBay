package it.starbay.gestioneutenti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.Ordine;

/**
 * ManagerUtenti
 * Classe manager riguardante il sottosistema degli utenti
 */
public class ManagerUtenti 
{
	private CallDatabase db;
	private Connection connection;
	private PreparedStatement inserter;
	private Statement statement;
	private ResultSet result;

	/**
	 * Costruisce ed inizializza un ManagerUtenti chiamando il database
	 */
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

	/**
	 * inserisce un cliente nel database
	 * @param c cliente da inserire
	 * @return true se l'inserimento è avvenuto, false altrimenti
	 */
	public boolean registraUtente(Cliente c)
	{
		boolean errore=false;
		String query = "INSERT INTO UTENTI (email, nome, cognome, comune, indirizzo, username, password, iban) VALUES(?,?,?,?,?,?,?,?)";
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

	/**
	 * controlla credenziali nel database
	 * @param username username da controllare
	 * @param password password da controllare
	 * @return oggetto Cliente se il controllo è andato a buon fine
	 */
	public Cliente controlloCredenziali(String username,String password)
	{
		Cliente cliente= new Cliente();
		cliente.setNome("none");
		try 
		{
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT email, nome, cognome, comune, indirizzo, username, password, iban FROM UTENTI");
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
	
	/**
	 * prende i clienti dal database
	 * @return array di clienti
	 */
	public ArrayList<Cliente> dammiClienti() 
	{
		ArrayList<Cliente> clienti = new ArrayList<>();
		Cliente c = null;
		try
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT cognome, nome, username, email FROM UTENTI");
			
			while(result.next())
			{
				c = new Cliente();
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
	
	/**
	 * elimina un cliente dal database
	 * @param utente username del cliente da eliminare
	 */
	public void eliminaUtente(String utente) 
	{
		try 
		{
			statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM UTENTI WHERE username='" + utente+"'");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
