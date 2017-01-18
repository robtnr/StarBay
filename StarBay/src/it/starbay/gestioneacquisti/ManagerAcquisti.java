package it.starbay.gestioneacquisti;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Ordine;
import it.starbay.gestionebean.Stella;

/**
 * ManagerAcquisti
 * Classe manager riguardante il sottosistema degli acquisti
 *  
 */

public class ManagerAcquisti {

	private CallDatabase db;

	/**
	 * Costruisce ed inizializza un ManagerAcquisti chiamando il database
	 */
	public ManagerAcquisti()
	{
		db = new CallDatabase();
	}

	/**
	 * prende la quantità di un prodotto dal database
	 * @param nome nome del prodotto
	 * @param tipo tipo del prodotto
	 * @return quantità del prodotto
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int getQuantitaProdotto(String nome, String tipo) throws ClassNotFoundException, SQLException
	{
		Connection connection = db.getConnection();
		Statement statement = connection.createStatement();
		ResultSet result;
		int quantita = 0;

		if(tipo.equals("stella"))
			result = statement.executeQuery("SELECT quantita FROM STELLE WHERE nome='"+nome+"'");
		else
			result = statement.executeQuery("SELECT quantita FROM STORE WHERE nome='"+nome+"'");

		quantita = result.getInt(1);

		statement.close();
		connection.close();
		return quantita;
	}

	/**
	 * calcola il numero di ordini nel database
	 * @return numero di ordini
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int getCountOrdine() throws ClassNotFoundException, SQLException
	{
		Statement statement;
		Connection connection = db.getConnection();
		try 
		{
			int cont = 0;
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT count(idOrdine) FROM ORDINI");

			while(result.next())
			{
				cont = result.getInt(1);
			}
			statement.close();
			connection.close();
			return cont;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * inserisce un ordine nel database
	 * @param ordine oggetto ordine da inserire
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void creaOrdine(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO ORDINI VALUES(?,?,?,?)";
		Connection connection = db.getConnection();
		PreparedStatement inserter = connection.prepareStatement(query);
		try 
		{
			inserter.setInt(1, ordine.getIdOrdine());
			inserter.setString(2, ordine.getData());
			inserter.setString(3, ordine.getOra());
			inserter.setString(4, ordine.getUsername());
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
	 * conta il numero di dettagli ordine nel database
	 * @return numero di dettagli ordine
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int getCountDettaglioOrdine() throws ClassNotFoundException, SQLException
	{
		Statement statement = null;
		Connection connection = db.getConnection();
		try 
		{
			int cont = 0;
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT count(idDettaglioOrdine) FROM DETTAGLI_ORDINI");

			while(result.next())
			{
				cont = result.getInt(1);
			}
			statement.close();
			connection.close();

			return cont;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return 0;
	}
	
	/**
	 * prende gli ordini di un utente dal database
	 * @param username username dell'utente
	 * @return array di ordini
	 */
	public ArrayList<Ordine> dammiOrdiniUtente(String username)  
	{
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		try
		{
			Connection connection = db.getConnection();
			Statement statement = connection.createStatement();
			ResultSet result;

			Ordine ordine = null;
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT idOrdine, dataAcquisto, ora, idDettaglioOrdine, quantitaAcquistata, prezzo, coordinate, nome, descrizione FROM ORDINI NATURAL JOIN DETTAGLI_ORDINI NATURAL JOIN INCLUDE_STELLE NATURAL JOIN STELLE WHERE username = '"+username+"'");

			while(result.next())
			{
				ordine = new Ordine();
				ordine.setIdOrdine(Integer.parseInt(result.getString(1)));
				ordine.setData(result.getString(2));
				ordine.setOra(result.getString(3));
				ordine.setIdDettaglioOrdine(Integer.parseInt(result.getString(4)));
				ordine.setQuantita(Integer.parseInt(result.getString(5)));
				ordine.setPrezzo(Double.parseDouble(result.getString(6)));
				ordine.setIdProdotto(result.getString(7));
				ordine.setNomeProdotto(result.getString(8));
				ordine.setDescrizione(result.getString(9));
				ordine.setTipo("stella");

				ordini.add(ordine);
			}

			result = statement.executeQuery("SELECT idOrdine, dataAcquisto, ora, idDettaglioOrdine, quantitaAcquistata, prezzo, nome FROM ORDINI NATURAL JOIN DETTAGLI_ORDINI NATURAL JOIN INCLUDE_STORE NATURAL JOIN STORE WHERE username = '"+username+"'");

			while(result.next())
			{
				ordine = new Ordine();
				ordine.setIdOrdine(Integer.parseInt(result.getString(1)));
				ordine.setData(result.getString(2));
				ordine.setOra(result.getString(3));
				ordine.setIdDettaglioOrdine(Integer.parseInt(result.getString(4)));
				ordine.setQuantita(Integer.parseInt(result.getString(5)));
				ordine.setPrezzo(Double.parseDouble(result.getString(6)));
				ordine.setIdProdotto(result.getString(7));
				ordine.setTipo("store");

				ordini.add(ordine);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ordini;
	}

	/**
	 * inserisce un dettaglio ordine nel database
	 * @param ordine ordine da inserire
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void creaDettagliOrdine(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO DETTAGLI_ORDINI VALUES(?,?,?,?)";
		Connection connection = db.getConnection();
		PreparedStatement inserter = connection.prepareStatement(query);
		try 
		{
			inserter.setInt(1, ordine.getIdDettaglioOrdine());
			inserter.setDouble(2, ordine.getPrezzo());
			inserter.setInt(3, ordine.getQuantita());
			inserter.setInt(4, ordine.getIdOrdine());
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
	 * inserisce un include stella nel database
	 * @param ordine ordine da cui prendere l'id
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void creaIncludeStella(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO INCLUDE_STELLE VALUES(?,?)";

		String coordinate = getCoordinate(ordine.getIdProdotto());
		Connection connection = db.getConnection();
		PreparedStatement inserter = connection.prepareStatement(query);
		try 
		{
			inserter.setInt(1, ordine.getIdDettaglioOrdine());
			inserter.setString(2, coordinate);
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
	 * prende le coordinate dal database
	 * @param nomeProdotto
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getCoordinate(String nomeProdotto) throws ClassNotFoundException, SQLException 
	{
		Connection connection = db.getConnection();
		String query = "SELECT coordinate FROM STELLE WHERE nome=?";
		PreparedStatement inserter = null;
		try
		{
			String coordinate = null;
			inserter = connection.prepareStatement(query);
			inserter.setString(1,nomeProdotto);
			ResultSet result = inserter.executeQuery();
			while(result.next())
			{
				coordinate =  result.getString(1);
			}
			inserter.close();
			connection.close();
			return coordinate;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * inserisce un include store nel database
	 * @param ordine
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void creaIncludeStore(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO INCLUDE_STORE VALUES(?,?)";
		Connection connection = db.getConnection();
		PreparedStatement inserter = connection.prepareStatement(query);
		try 
		{
			inserter.setInt(1, ordine.getIdDettaglioOrdine());
			inserter.setString(2, ordine.getNomeProdotto());
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
	 * aggiorna la quantità ed eventualmente il nome di un prodotto stella nel database
	 * @param ordine ordine da cui prendere gli attributi
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void aggiornaQuantitaNomeProdotto(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		PreparedStatement inserter;
		Connection connection = db.getConnection();
		ResultSet result;
		String template;
		boolean cambiare_nome = false;
		if(ordine.getTipo().equals("store"))
			template = "UPDATE STORE SET quantita=quantita-? WHERE nome=?";
		else
		{
			if(ordine.getNomeProdotto().equals(ordine.getIdProdotto()))
			{
				template = "UPDATE STELLE SET quantita=quantita-? WHERE nome=?";
			}
			else
			{
				cambiare_nome = true;
				template = "UPDATE STELLE SET quantita=quantita-?, nome=? WHERE nome=?";
			}
		}

		try
		{
			inserter = connection.prepareStatement(template);
			inserter.setInt(1, ordine.getQuantita());
			if(cambiare_nome == true)
			{
				inserter.setString(2, ordine.getNomeProdotto());
				inserter.setString(3, ordine.getIdProdotto());
			}
			else
				inserter.setString(2, ordine.getNomeProdotto());

			inserter.executeUpdate();
			inserter.close();
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
