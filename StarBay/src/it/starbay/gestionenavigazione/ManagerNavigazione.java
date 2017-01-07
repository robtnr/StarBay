package it.starbay.gestionenavigazione;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;

public class ManagerNavigazione 
{
	private CallDatabase db;
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	
	public ManagerNavigazione() throws ClassNotFoundException, SQLException
	{
		db = new CallDatabase();
		connection = db.getConnection();
	}
	
	public ArrayList caricaUltimiProdotti(String tipo)
	{
		ArrayList<Stella> stelle = new ArrayList<Stella>();
		ArrayList<Store> prodotti_store = new ArrayList<Store>();
		if(tipo.equals("stella"))
			{
			try 
			{
				statement = connection.createStatement();
				result = statement.executeQuery("SELECT * FROM STELLE WHERE quantita>0 ORDER BY data DESC LIMIT 3");
				
				while(result.next())
				{
					Stella stella = new Stella();
					stella.setCoordinate(result.getString(1));
					stella.setDescrizione(result.getString(2));
					stella.setSrc(result.getString(3));
					stella.setPrezzo(result.getDouble(4));
					stella.setNome(result.getString(5));
					stella.setData(result.getString(7));
					stelle.add(stella);
				}
				statement.close();
				connection.close();
				return stelle;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				connection = db.getConnection();
				statement = connection.createStatement();
				result = statement.executeQuery("SELECT* FROM STORE WHERE quantita>0 ORDER BY data DESC LIMIT 3");
				
				while(result.next())
				{
					Store store = new Store();
					store.setNome(result.getString(1));
					store.setDescrizione(result.getString(2));
					store.setSrc(result.getString(3));
					store.setPrezzoVendita(result.getDouble(4));
					store.setQuantita(result.getInt(5));
					store.setPrezzoAcquisto(result.getDouble(6));
					store.setData(result.getString(7));
					prodotti_store.add(store);
				}
				statement.close();
				connection.close();
				return prodotti_store;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			} catch (ClassNotFoundException e) 
			{

				e.printStackTrace();
			}
			
		}
		return prodotti_store;
	}
	
	public ArrayList<Stella> caricaProdottiStella()
	{
		ArrayList<Stella> stelle = new ArrayList<Stella>();
		try 
		{
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM STELLE WHERE quantita>0 ORDER BY data DESC");
				
			while(result.next())
			{
				Stella stella = new Stella();
				stella.setCoordinate(result.getString(1));
				stella.setDescrizione(result.getString(2));
				stella.setSrc(result.getString(3));
				stella.setPrezzo(result.getDouble(4));
				stella.setNome(result.getString(5));
				stella.setData(result.getString(7));
				stelle.add(stella);
			}
			statement.close();
			connection.close();
			
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		return stelle;
	}
	
	public ArrayList<Store> caricaProdottiStore()
	{
		ArrayList<Store> prodotti_store = new ArrayList<Store>();
		try 
		{
			connection = db.getConnection();
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT* FROM STORE WHERE quantita>0 ORDER BY data");
			
			while(result.next())
			{
				Store store = new Store();
				store.setNome(result.getString(1));
				store.setDescrizione(result.getString(2));
				store.setSrc(result.getString(3));
				store.setPrezzoVendita(result.getDouble(4));
				store.setQuantita(result.getInt(5));
				store.setPrezzoAcquisto(result.getDouble(6));
				store.setData(result.getString(7));
				prodotti_store.add(store);
			}
			statement.close();
			connection.close();
			return prodotti_store;
		} catch (SQLException e) 
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) 
		{

			e.printStackTrace();
		}
		return prodotti_store;
	}
	
	public ArrayList caricaProdotti(String tipo)
	{
		ArrayList<Stella> stelle = new ArrayList<Stella>();
		ArrayList<Store> prodotti_store = new ArrayList<Store>();
		if(tipo.equals("stella"))
			{
			try 
			{
				statement = connection.createStatement();
				result = statement.executeQuery("SELECT * FROM STELLE ORDER BY data DESC");
				
				while(result.next())
				{
					Stella stella = new Stella();
					stella.setCoordinate(result.getString(1));
					stella.setDescrizione(result.getString(2));
					stella.setSrc(result.getString(3));
					stella.setPrezzo(result.getDouble(4));
					stella.setNome(result.getString(5));
					stella.setData(result.getString(7));
					stelle.add(stella);
				}
				statement.close();
				connection.close();
				return stelle;
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
				result = statement.executeQuery("SELECT * FROM STORE ORDER BY data DESC");
				
				while(result.next())
				{
					Store store = new Store();
					store.setNome(result.getString(1));
					store.setDescrizione(result.getString(2));
					store.setSrc(result.getString(3));
					store.setPrezzoVendita(result.getDouble(4));
					store.setQuantita(result.getInt(5));
					store.setPrezzoAcquisto(result.getDouble(6));
					store.setData(result.getString(7));
					prodotti_store.add(store);
				}
				statement.close();
				connection.close();
				return prodotti_store;
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return prodotti_store;
	}
	
	public ArrayList cercaProdotti(String chiave)
	{
		String template;
		PreparedStatement inserter;
		ResultSet result;
		ArrayList prodotti_trovati = new ArrayList(); 
		
		template = "SELECT * FROM STELLE WHERE nome LIKE ?";
		try
		{
			inserter = connection.prepareStatement(template);
			inserter.setString(1, "%"+chiave+"%");
			result = inserter.executeQuery();
		
			while(result.next())
			{
				Stella stella = new Stella();
				stella.setCoordinate(result.getString(1));
				stella.setDescrizione(result.getString(2));
				stella.setSrc(result.getString(3));
				stella.setPrezzo(result.getDouble(4));
				stella.setNome(result.getString(5));
				stella.setData(result.getString(7));
				prodotti_trovati.add("stella");
				prodotti_trovati.add(stella);
			}
			inserter.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		template = "SELECT * FROM STORE WHERE nome LIKE ?";
		try
		{
			inserter = connection.prepareStatement(template);
			inserter.setString(1, "%"+chiave+"%");
			result = inserter.executeQuery();
			while(result.next())
			{
				Store prodotto_store = new Store();
				prodotto_store.setNome(result.getString(1));
				prodotto_store.setDescrizione(result.getString(2));
				prodotto_store.setSrc(result.getString(3));
				prodotto_store.setPrezzoVendita(result.getDouble(4));
				prodotto_store.setQuantita(result.getInt(5));
				prodotto_store.setPrezzoAcquisto(result.getDouble(6));
				prodotto_store.setData(result.getString(7));
				prodotti_trovati.add("store");
				prodotti_trovati.add(prodotto_store);
			}
			inserter.close();
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		try 
		{
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return prodotti_trovati;
	}
}
