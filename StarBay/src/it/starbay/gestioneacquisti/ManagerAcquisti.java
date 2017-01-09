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
	
	public ManagerAcquisti() throws ClassNotFoundException, SQLException
	{
		db = new CallDatabase();
	}
	
	public int getQuantitaProdotto(String nome, String tipo) throws ClassNotFoundException, SQLException
	{
		Connection connection = db.getConnection();
		Statement statement;
		PreparedStatement inserter = null;
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
			inserter.close();
			connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				inserter.close();
				connection.close();
			}
		}
		else
		{
			try 
			{
			connection = db.getConnection();
			statement = connection.createStatement();
			inserter = connection.prepareStatement("SELECT quantita FROM STORE WHERE nome=?");
			inserter.setString(1, nome);
			result = inserter.executeQuery();
			
			while(result.next())
			{
				return result.getInt(1);
			}
			statement.close();
			inserter.close();
			connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				inserter.close();
				connection.close();
			}
		}
		return 0;
	}
	
	public int getCountOrdine() throws ClassNotFoundException, SQLException
	{
		Statement statement = null;
		Connection connection = db.getConnection();
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
		}finally 
		{
			statement.close();
			connection.close();
		}
		
		return 0;
	}
	
	public void creaOrdine(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO ORDINI VALUES(?,?,?,?)";
		Connection connection = db.getConnection();
		PreparedStatement inserter = connection.prepareStatement(query);
		try 
		{
			
			System.out.println(ordine.getIdOrdine());
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
		}finally 
		{
			inserter.close();
			connection.close();
		}
		
	}
	
	public int getCountDettaglioOrdine() throws ClassNotFoundException, SQLException
	{
		Statement statement = null;
		Connection connection = db.getConnection();
		try 
		{
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT count(idDettaglioOrdine) FROM DETTAGLI_ORDINI");
			
			while(result.next())
			{
				return result.getInt(1);
			}
			statement.close();
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}finally 
		{
			statement.close();
			connection.close();
		}
		
		return 0;
	}
	
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
		}finally 
		{
			inserter.close();
			connection.close();
		}
	}
	
	public void creaIncludeStella(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO INCLUDE_STELLE VALUES(?,?)";
		
		String coordinate = getCoordinate(ordine.getNomeProdotto());
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
		}finally 
		{
			inserter.close();
			connection.close();
		}
		
	}

	public String getCoordinate(String nomeProdotto) throws ClassNotFoundException, SQLException 
	{
		Connection connection = db.getConnection();
		String query = "SELECT coordinate FROM STELLE WHERE nome=?";
		PreparedStatement inserter = null;
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
		}finally 
		{
			inserter.close();
			connection.close();
		}
		
		return null;
	}
	
	public void creaIncludeStore(Ordine ordine) throws ClassNotFoundException, SQLException
	{
		String query = "INSERT INTO INCLUDE_STORE VALUES(?,?)";
		
		String coordinate = getCoordinate(ordine.getNomeProdotto());
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
		}finally 
		{
			inserter.close();
			connection.close();
		}
	}
	
}
