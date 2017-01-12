package it.starbay.manager;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestioneacquisti.ManagerAcquisti;
import it.starbay.gestionebean.CallDatabase;
import it.starbay.gestionebean.Ordine;

public class ManagerAcquistiTest {

	private ManagerAcquisti ma;
	private Ordine o;
	private CallDatabase db;
	private Connection connection;
	private Statement statement;
	private ResultSet result;

	@Before
	public void setUp() throws Exception 
	{
		db = new CallDatabase();
		connection = db.getConnection();
		statement = connection.createStatement();
		ma = new ManagerAcquisti();
		o = new Ordine();
	}

	@After
	public void tearDown() throws Exception 
	{
		connection.close();
		db = null;
		connection = null;
		statement = null;
		result = null;
		ma = null;
		o = null;
	}

	@Test
	public void testGetQuantitaProdotto() throws ClassNotFoundException, SQLException 
	{
		assertEquals(449, ma.getQuantitaProdotto("Binocolo Nikon", "store"));
	}

	@Test
	public void testGetCountOrdine() throws ClassNotFoundException, SQLException 
	{
		assertEquals(2, ma.getCountOrdine());
	}

	@Test
	public void testCreaOrdine() throws ClassNotFoundException, SQLException 
	{
		o.setIdOrdine(300);
		o.setData("2020-01-01");
		o.setOra("12:30");
		o.setUsername("giandark");
		ma.creaOrdine(o);
		result = statement.executeQuery("SELECT idOrdine, dataAcquisto, ora, username FROM ORDINI WHERE idOrdine='300'");
		Ordine newO = new Ordine();
		newO.setIdOrdine(result.getInt(1));
		newO.setData(result.getString(2));
		newO.setOra(result.getString(3));
		newO.setUsername(result.getString(4));
		assertEquals(o.getIdOrdine(), newO.getIdOrdine());
		assertEquals(o.getData(), newO.getData());
		assertEquals(o.getOra(), newO.getOra());
		assertEquals(o.getUsername(), newO.getUsername());
		statement.executeUpdate("DELETE FROM ORDINI WHERE idOrdine=300");
	}

	@Test
	public void testGetCountDettaglioOrdine() throws ClassNotFoundException, SQLException 
	{
		assertEquals(6, ma.getCountDettaglioOrdine());
	}

	@Test
	public void testCreaDettagliOrdine() throws ClassNotFoundException, SQLException 
	{
		o.setIdDettaglioOrdine(300);
		o.setPrezzo(500);
		o.setQuantita(10);
		o.setIdOrdine(2);
		ma.creaDettagliOrdine(o);
		result = statement.executeQuery("SELECT idDettaglioOrdine, prezzo, quantitaAcquistata, idOrdine FROM DETTAGLI_ORDINI WHERE idDettaglioOrdine=300");
		Ordine newO = new Ordine();
		newO.setIdDettaglioOrdine(result.getInt(1));
		newO.setPrezzo(result.getDouble(2));
		newO.setQuantita(result.getInt(3));
		newO.setIdOrdine(result.getInt(4));
		assertEquals(o.getIdDettaglioOrdine(), newO.getIdDettaglioOrdine());
		assertEquals(""+o.getPrezzo(), ""+newO.getPrezzo());
		assertEquals(o.getQuantita(), newO.getQuantita());
		assertEquals(o.getIdOrdine(), newO.getIdOrdine());
		statement.executeUpdate("DELETE FROM DETTAGLI_ORDINI WHERE idDettaglioOrdine=300");
	}

	@Test
	public void testCreaIncludeStella() throws ClassNotFoundException, SQLException 
	{	
		o.setIdProdotto("Melissa");
		o.setIdDettaglioOrdine(300);
		ma.creaIncludeStella(o);
		result = statement.executeQuery("SELECT idDettaglioOrdine, coordinate FROM INCLUDE_STELLE WHERE coordinate='220,98 +34,67 111,13 -44,67'");
		Ordine newO = new Ordine();
		newO.setIdDettaglioOrdine(result.getInt(1));
		newO.setIdProdotto(result.getString(2));
		assertEquals("220,98 +34,67 111,13 -44,67", newO.getIdProdotto());
		assertEquals(""+o.getIdDettaglioOrdine(), ""+newO.getIdDettaglioOrdine());
		statement.executeUpdate("DELETE FROM INCLUDE_STELLE WHERE coordinate='220,98 +34,67 111,13 -44,67'");
	}

	@Test
	public void testGetCoordinate() throws ClassNotFoundException, SQLException 
	{
		assertEquals("220,98 +34,67 111,13 -44,67", ma.getCoordinate("Melissa"));
	}

	@Test
	public void testCreaIncludeStore() throws ClassNotFoundException, SQLException 
	{	
		o.setIdDettaglioOrdine(300);
		o.setNomeProdotto("Binocolo Canon");
		ma.creaIncludeStore(o);
		result = statement.executeQuery("SELECT idDettaglioOrdine, nome FROM INCLUDE_STORE WHERE idDettaglioOrdine=300 AND nome='Binocolo Canon'");
		Ordine newO = new Ordine();
		newO.setIdDettaglioOrdine(result.getInt(1));
		newO.setNomeProdotto(result.getString(2));
		assertEquals(o.getIdDettaglioOrdine(), newO.getIdDettaglioOrdine());
		assertEquals(o.getNomeProdotto(), newO.getNomeProdotto());
		statement.executeUpdate("DELETE FROM INCLUDE_STORE WHERE idDettaglioOrdine=300 AND nome='Binocolo Canon'");
	}

	@Test
	public void testAggiornaQuantitaNomeProdotto() throws ClassNotFoundException, SQLException 
	{	
		o.setTipo("store");
		o.setNomeProdotto("Telescopio Omegon");
		o.setIdProdotto("Telescopio Omegon");
		o.setQuantita(1);
		ma.aggiornaQuantitaNomeProdotto(o);
	}
}
