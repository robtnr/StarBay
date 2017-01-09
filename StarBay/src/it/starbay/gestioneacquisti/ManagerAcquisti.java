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
	
	public int getCountOrdine()
	{
		Statement statement;
		try 
		{
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT count(idOrdine) FROM ORDINI");
			
			while(result.next())
			{
				return result.getInt(1);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void creaOrdine(Ordine ordine)
	{
		String query = "INSERT INTO ORDINI VALUES(?,?,?,?)";
		
		try 
		{
			PreparedStatement inserter = connection.prepareStatement(query);
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
	
	public int getCountDettaglioOrdine()
	{
		Statement statement;
		try 
		{
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT count(idDettaglioOrdine) FROM DETTAGLI_ORDINI");
			
			while(result.next())
			{
				return result.getInt(1);
			}
			statement.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void creaDettagliOrdine(Ordine ordine)
	{
		String query = "INSERT INTO DETTAGLI_ORDINI VALUES(?,?,?,?)";
		
		try 
		{
			PreparedStatement inserter = connection.prepareStatement(query);
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
	
	public void creaIncludeStella(Ordine ordine)
	{
		String query = "INSERT INTO INCLUDE_STELLE VALUES(?,?)";
		
		String coordinate = getCoordinate(ordine.getNomeProdotto());
		try 
		{
			PreparedStatement inserter = connection.prepareStatement(query);
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

	public String getCoordinate(String nomeProdotto) 
	{
		String query = "SELECT coordinate FROM STELLE WHERE nome=?";
		PreparedStatement inserter;
		try
		{
			inserter = connection.prepareStatement(query);
			inserter.setString(1,nomeProdotto);
			ResultSet result = inserter.executeQuery();
			while(result.next())
			{
				return result.getString(1);
			}
			inserter.close();
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void creaIncludeStore(Ordine ordine)
	{
		String query = "INSERT INTO INCLUDE_STORE VALUES(?,?)";
		
		String coordinate = getCoordinate(ordine.getNomeProdotto());
		try 
		{
			PreparedStatement inserter = connection.prepareStatement(query);
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
	
}
