package it.starbay.gestionestatistiche;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			
			result = statement.executeQuery("SELECT sum(prezzoAcquisto) FROM INCLUDE_STORE natural join STORE");
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


}
