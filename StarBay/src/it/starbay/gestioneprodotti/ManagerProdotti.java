package it.starbay.gestioneprodotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;

/**
 * ManagerProdotti
 * Classe manager riguardante il sottosistema dei prodotti
 */
public class ManagerProdotti {
	private CallDatabase db;
	private Connection connection;
	private PreparedStatement inserter;

	/**
	 * Costruisce ed inizializza un ManagerProdotti chimando il database 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ManagerProdotti() throws ClassNotFoundException, SQLException {
		db = new CallDatabase();
		connection = db.getConnection();
	}

	/**
	 * inserisce un prodotto stella nel database
	 * @param s oggetto Stella da inserire
	 */
	public void registraProdottoStella(Stella s) 
	{
		String query = "INSERT INTO STELLE VALUES(?,?,?,?,?,?,?)";
	
		try 
		{
			inserter = connection.prepareStatement(query);
			inserter.setString(1, s.getCoordinate());
			inserter.setString(2, s.getDescrizione());
			inserter.setString(3, s.getSrc());
			inserter.setDouble(4, s.getPrezzo());
			inserter.setString(5, s.getNome());
			inserter.setInt(6, 1);
			inserter.setString(7, s.getData());
			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * inserisce un prodotto store nel database
	 * @param s oggetto Store da inserire
	 */
	public void registraProdottoStore(Store s) 
	{
		String query = "INSERT INTO STORE VALUES(?,?,?,?,?,?,?)";
		
		try 
		{
			inserter = connection.prepareStatement(query);
			inserter.setString(1, s.getNome());
			inserter.setString(2, s.getDescrizione());
			inserter.setString(3, s.getSrc());
			inserter.setDouble(4, s.getPrezzoVendita());
			inserter.setInt(5, s.getQuantita());
			inserter.setDouble(6, s.getPrezzoAcquisto());
			inserter.setString(7, s.getData());
			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * modifica un prodotto store dal database
	 * @param prodotto_vecchio rappresenta il prodotto da modificare
	 * @param prodotto_nuovo rappresenta il prodotto modificato
	 */
	public void modificaProdottoStore(Store prodotto_vecchio, Store prodotto_nuovo)
	{
	    PreparedStatement inserter;
		ResultSet result;
		String template = "UPDATE STORE SET nome=?, descrizione=?, prezzoVendita=?, quantita=?, prezzoAcquisto=?, data=? WHERE nome=?";
		try
		{
			inserter = connection.prepareStatement(template);
			//SET prodotto nuovo
			inserter.setString(1, prodotto_nuovo.getNome());
			inserter.setString(2, prodotto_nuovo.getDescrizione());
			inserter.setDouble(3, prodotto_nuovo.getPrezzoVendita());
			inserter.setInt(4, prodotto_nuovo.getQuantita());
			inserter.setDouble(5, prodotto_nuovo.getPrezzoAcquisto());
			inserter.setString(6, prodotto_nuovo.getData());
			//WHERE prodotto vecchio
			inserter.setString(7, prodotto_vecchio.getNome());
			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * modifica un prodotto stella dal database
	 * @param stella_vecchia rappresenta il prodotto da modificare
	 * @param stella_nuova rappresenta il prodotto modificato
	 */
	public void modificaProdottoStella(Stella stella_vecchia, Stella stella_nuova)
	{
	    PreparedStatement inserter;
		ResultSet result;
		String template = "UPDATE STELLE SET coordinate=?, descrizione=?, prezzoVendita=?, nome=?, data=? WHERE coordinate=?";
		try
		{
			inserter = connection.prepareStatement(template);
			//SET stella nuova
			inserter.setString(1, stella_nuova.getCoordinate());
			inserter.setString(2, stella_nuova.getDescrizione());
			inserter.setDouble(3, stella_nuova.getPrezzo());
			inserter.setString(4, stella_nuova.getNome());
			inserter.setString(5, stella_nuova.getData());
			//WHERE prodotto vecchio
			inserter.setString(6, stella_vecchia.getCoordinate());
			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Elimina un prodotto stella dal database
	 * @param coordinate rappresenta l'id della stella
	 */
	public void eliminaStella(String coordinate)
	{
		PreparedStatement inserter;
		
		String template="DELETE FROM STELLE WHERE coordinate=?";
		try
		{
			inserter = connection.prepareStatement(template);
			inserter.setString(1, coordinate);
			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Elimina un prodotto store dal database
	 * @param nome rappresenta l'id del prodotto store
	 */
	public void eliminaProdottoStore(String nome)
	{
		PreparedStatement inserter;
		
		String template="DELETE FROM STORE WHERE nome=?";
		try
		{
			inserter = connection.prepareStatement(template);
			inserter.setString(1, nome);
			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
