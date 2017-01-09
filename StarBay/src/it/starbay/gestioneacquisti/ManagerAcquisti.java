package it.starbay.gestioneacquisti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.starbay.gestionebean.CallDatabase;

public class ManagerAcquisti {

	private CallDatabase db;
	private Connection connection;
	
	public ManagerAcquisti() throws ClassNotFoundException, SQLException
	{
		db = new CallDatabase();
		connection = db.getConnection();
	}
	
	public int getQuantitaProdotto(String nome, String tipo)
	{
		
		Statement statement;
		PreparedStatement inserter;
		ResultSet result;
		
		if(tipo.equals("stella"))
		{
			try 
			{
			statement = connection.createStatement();
			inserter = connection.prepareStatement("SELECT quantita FROM STELLE WHERE nome=?");
			inserter.setString(1, nome);
			result = inserter.executeQuery();
			
			while(result.next())
			{
				return result.getInt(1);
			}
			statement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
			statement = connection.createStatement();
			inserter = connection.prepareStatement("SELECT quantita FROM STORE WHERE nome=?");
			inserter.setString(1, nome);
			result = inserter.executeQuery();
			
			while(result.next())
			{
				return result.getInt(1);
			}
			statement.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
}
