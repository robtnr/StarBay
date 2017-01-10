package it.starbay.gestionestatistiche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.starbay.gestionebean.CallDatabase;

public class ManagerStatistiche 
{
	private CallDatabase db;
	private Connection connection;
	private Statement statement;
	private ResultSet result;

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
			spesa = result.getString(1);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if(guadagnoTotale == null || guadagnoTotale.equals("")) return "0";
		
		double ricavoTotale = Double.parseDouble(guadagnoTotale) - Double.parseDouble(spesa); 
		
		return "" + ricavoTotale;
	}

	public ArrayList<String> dammiGuadagnoSingoloProdotto() 
	{
		ArrayList<String> righe = new ArrayList<>();
		try
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT coordinate, nome, sum(prezzo) FROM DETTAGLI_ORDINI natural join INCLUDE_STELLE natural join STELLE GROUP BY coordinate, nome");
			
			while(result.next())
				righe.add("<tr><td>" + result.getString(1) + "</td><td>" + result.getString(2) + "</td><td>" + result.getString(3) + "</td></tr>");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		if (righe.isEmpty()) return null;

		return righe;
	}
}
