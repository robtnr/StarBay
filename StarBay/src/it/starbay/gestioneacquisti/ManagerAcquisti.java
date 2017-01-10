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
			int quantita = 0;
			statement = connection.createStatement();
			inserter = connection.prepareStatement("SELECT quantita FROM STELLE WHERE nome=?");
			inserter.setString(1, nome);
			result = inserter.executeQuery();
			
			while(result.next())
			{
				quantita = result.getInt(1);
			}
			statement.close();
			inserter.close();
			connection.close();
			return quantita;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
			int quantita = 0;
			connection = db.getConnection();
			statement = connection.createStatement();
			inserter = connection.prepareStatement("SELECT quantita FROM STORE WHERE nome=?");
			inserter.setString(1, nome);
			result = inserter.executeQuery();
			
			while(result.next())
			{
				quantita = result.getInt(1);
			}
			statement.close();
			inserter.close();
			connection.close();
			return quantita;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}
	
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
		}
	}
	
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
