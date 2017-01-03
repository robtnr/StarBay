package it.starbay.gestioneutenti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Cliente;

public class ManagerUtenti 
{
	private CallDatabase db;
	private Connection connection;
	private PreparedStatement inserter;
	
	public ManagerUtenti() throws ClassNotFoundException, SQLException
	{
		db = new CallDatabase();
		connection = db.getConnection();
	}
	
	public void registraUtente(Cliente c)
	{
		System.out.println("sono passato di qui1");
		System.out.println(c.getEmail());
		String query = "INSERT INTO UTENTI VALUES(?,?,?,?,?,?,?,?)";
		try {
			inserter = connection.prepareStatement(query);
			inserter.setString(1, c.getEmail());
			inserter.setString(2, c.getNome());
			inserter.setString(3, c.getCognome());
			inserter.setString(4, c.getComune());
			inserter.setString(5, c.getIndirizzo());
			inserter.setString(6, c.getUsername());
			inserter.setString(7, c.getPassword());
			inserter.setString(8, c.getIban());
			inserter.executeUpdate();
			inserter.close();
			connection.close();
			System.out.println("sono passato di qui2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
