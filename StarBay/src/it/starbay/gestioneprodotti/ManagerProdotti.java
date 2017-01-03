package it.starbay.gestioneprodotti;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.Stella;

public class ManagerProdotti {
	private CallDatabase db;
	private Connection connection;
	private PreparedStatement inserter;

	public ManagerProdotti() throws ClassNotFoundException, SQLException {
		db = new CallDatabase();
		connection = db.getConnection();
	}

	public void registraProdottoStella(Stella s) 
	{
		String query = "INSERT INTO UTENTI VALUES(?,?,?,?,?,?,?,?)";
		
		try 
		{
			inserter = connection.prepareStatement(query);
			inserter.setString(1, s.getCoordinate());
			inserter.setString(2, s.getDescrizione());
			inserter.setString(3, s.getSrc());
			inserter.setDouble(4, s.getPrezzo());
			inserter.setString(5, s.getNome());
			inserter.setString(6, "1");
			inserter.setString(7, s.getData());
			inserter.setString(8, null);
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
