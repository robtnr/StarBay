package it.starbay.gestionestatistiche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Ordine;

/**
 * ManagerStatistiche
 * Classe manager riguardante il sottosistema delle statistiche
 */
public class ManagerStatistiche 
{
	private CallDatabase db;
	private Connection connection;
	private Statement statement;
	private ResultSet result;

	/**
	 * Costruisce ed inizializza un ManagerStatistiche chiamando il database
	 */
	public ManagerStatistiche() 
	{
		db = new CallDatabase();
		try 
		{
			connection = db.getConnection();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * calcola il guadagno totale dal database
	 * @return guadagno totale
	 */
	public String dammiGuadagnoTotale() 
	{
		String guadagnoTotale = null;
		try
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT sum(prezzo) FROM DETTAGLI_ORDINI");
			guadagnoTotale = result.getString(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(guadagnoTotale == null || guadagnoTotale.equals("")) return "0";
		
		return guadagnoTotale;
	}

	/**
	 * calcola il ricavo totale dal database
	 * @return ricavo totale
	 */
	public String dammiRicavoTotale() 
	{
		String guadagnoTotale = null;
		String spesa = null;
		
		try
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT sum(prezzo) FROM DETTAGLI_ORDINI");
			guadagnoTotale = result.getString(1);
			
			result = statement.executeQuery("SELECT (quantitaAcquistata*prezzoAcquisto) FROM DETTAGLI_ORDINI D NATURAL JOIN INCLUDE_STORE NATURAL JOIN STORE");
			if(result.next())
				spesa = result.getString(1);
			else
				spesa = "0";
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(guadagnoTotale == null || guadagnoTotale.equals("")) return "0";
		
		double ricavoTotale = Double.parseDouble(guadagnoTotale) - Double.parseDouble(spesa); 
		
		return "" + ricavoTotale;
	}

	/**
	 * calcola il guadagno totale per singolo prodotto dal database
	 * @return array di Ordini
	 */
	public ArrayList<Ordine> dammiGuadagnoSingoloProdotto() 
	{
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		Ordine o = new Ordine();
		
		try
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT coordinate, nome, sum(prezzo), data FROM DETTAGLI_ORDINI natural join INCLUDE_STELLE natural join STELLE GROUP BY coordinate, nome, data ORDER BY data");
			
			while(result.next())
			{
				o = new Ordine();
				o.setIdProdotto(result.getString(1));
				o.setNomeProdotto(result.getString(2));
				o.setPrezzo(Double.parseDouble(result.getString(3)));
				o.setData(result.getString(4));
				
				ordini.add(o);
			}
			
			result = statement.executeQuery("SELECT nome, sum(prezzo), data FROM DETTAGLI_ORDINI NATURAL JOIN INCLUDE_STORE NATURAL JOIN STORE GROUP BY nome, prezzoAcquisto, data ORDER BY data");
			
			while(result.next())
			{
				o = new Ordine();
				o.setIdProdotto(result.getString(1));
				o.setNomeProdotto("");
				o.setPrezzo(Double.parseDouble(result.getString(2)));
				o.setData(result.getString(3));
				ordini.add(o);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (ordini.isEmpty()) return null;

		return ordini;
	}
}
