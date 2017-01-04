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
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return prodotti_store;
	}
}
