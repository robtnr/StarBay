package it.starbay.manager;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Cliente;
import it.starbay.gestioneutenti.ManagerUtenti;

public class ManagerUtentiTest {

	private ManagerUtenti mu;
	private CallDatabase db;
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	private Cliente c;

	@Before
	public void setUp() throws Exception 
	{
		mu = new ManagerUtenti();
		db = new CallDatabase();
		connection = db.getConnection();
		statement = connection.createStatement();
		c = new Cliente();
	}

	@After
	public void tearDown() throws Exception 
	{
		mu = null;
		connection.close();
		db = null;
		connection = null;
		statement = null;
		result = null;
		c = null;
	}

	@Test
	public void testRegistraUtente() throws SQLException 
	{
		c.setNome("Angela");
		c.setCognome("Nappo");
		c.setComune("San Giuseppe Vesuviano");
		c.setIndirizzo("Via Nappi 25");
		c.setEmail("angnap@live.it");
		c.setUsername("angnap93");
		c.setPassword("consiglia");
		c.setIban("IT60X0542811101000000123456");
		assertFalse(mu.registraUtente(c));
		statement.executeUpdate("DELETE FROM UTENTI WHERE username='angnap93'");
	}

	@Test
	public void testControlloCredenziali() 
	{
		c = mu.controlloCredenziali("giandark", "giandark");
		assertFalse(c.getNome().equals("none"));
	}

	@Test
	public void testDammiClienti() 
	{
		assertFalse(mu.dammiClienti().isEmpty());
	}

	@Test
	public void testEliminaUtente() 
	{
		c = mu.controlloCredenziali("giandark", "giandark");
		mu.eliminaUtente("giandark");
		assertTrue(mu.controlloCredenziali("giandark", "giandark").getNome().equals("none"));
		mu.registraUtente(c);
	}
}