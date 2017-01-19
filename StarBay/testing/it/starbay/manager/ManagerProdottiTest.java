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
import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;
import it.starbay.gestioneprodotti.ManagerProdotti;
import it.starbay.gestionestatistiche.ManagerStatistiche;

public class ManagerProdottiTest {

	private ManagerProdotti mp;
	private Stella stella;
	private Store store;
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
		mp = new ManagerProdotti();
		stella = new Stella();
		store = new Store();
	}

	@After
	public void tearDown() throws Exception 
	{
		connection.close();
		db = null;
		connection = null;
		statement = null;
		result = null;
		mp = null;
		stella = null;
		store = null;
	}

	@Test
	public void testRegistraProdottoStella() throws Exception 
	{
		stella.setCoordinate("111,1 -111,1 111,1");
		stella.setData(" ");
		stella.setDescrizione(" ");
		stella.setNome(" ");
		stella.setPrezzo(0);
		stella.setSrc(" ");
		mp.registraProdottoStella(stella);
		result = statement.executeQuery("SELECT coordinate FROM STELLE WHERE coordinate='111,1 -111,1 111,1'");
		Stella newStella = new Stella();
		newStella.setCoordinate(result.getString(1));
		assertEquals(stella.getCoordinate(), newStella.getCoordinate());
		statement.executeUpdate("DELETE FROM STELLE WHERE coordinate='111,1 -111,1 111,1'");
	}

	@Test
	public void testRegistraProdottoStore() throws Exception 
	{
		store.setNome("Binocolo Angel");
		store.setData(" ");
		store.setDescrizione(" ");
		store.setSrc(" ");
		store.setPrezzoAcquisto(0);
		store.setPrezzoVendita(0);
		store.setQuantita(0);
		mp.registraProdottoStore(store);
		result = statement.executeQuery("SELECT nome FROM STORE WHERE nome='Binocolo Angel'");
		Store newStore = new Store();
		newStore.setNome(result.getString(1));
		assertEquals(store.getNome(), newStore.getNome());
		statement.executeUpdate("DELETE FROM STORE WHERE nome='Binocolo Angel'");
	}

	@Test
	public void testModificaProdottoStore() throws SQLException, ClassNotFoundException 
	{
		Store oldStore = new Store();
		oldStore.setNome("Telescopio Omegon");
		oldStore.setData("2016-12-09");
		oldStore.setDescrizione("Prodotto di prezzo accessibile con una distanza focale di 500 mm, quindi con un notevole zoom standard senza ingrandimenti e un diametro dell’ottica di 50 mm.");
		oldStore.setSrc("images/store/telescopio_omegeon.jpg");
		oldStore.setPrezzoAcquisto(20);
		oldStore.setPrezzoVendita(35);
		oldStore.setQuantita(410);
		
		Store newStore = new Store();
		newStore.setNome("BinoTest");
		newStore.setData(" ");
		newStore.setDescrizione(" ");
		newStore.setSrc(" ");
		newStore.setPrezzoAcquisto(0);
		newStore.setPrezzoVendita(0);
		newStore.setQuantita(0);
		
		mp.modificaProdottoStore(oldStore, newStore);
		(new ManagerProdotti()).registraProdottoStore(oldStore);	
		
		result = statement.executeQuery("SELECT nome, data, descrizione, src, prezzoAcquisto, prezzoVendita, quantita FROM STORE WHERE nome='BinoTest'");
		
		Store checkStore = new Store();
		checkStore.setNome(result.getString(1));
		checkStore.setData(result.getString(2));
		checkStore.setDescrizione(result.getString(3));
		checkStore.setSrc(result.getString(4));
		checkStore.setPrezzoAcquisto(result.getInt(5));
		checkStore.setPrezzoVendita(result.getInt(6));
		checkStore.setQuantita(result.getInt(7));

		statement.executeUpdate("DELETE FROM  STORE WHERE nome='BinoTest'");
		
		assertEquals(newStore.getNome(), checkStore.getNome());
		assertEquals(newStore.getData(), checkStore.getData());
		assertEquals(newStore.getDescrizione(), checkStore.getDescrizione());
		assertEquals(""+newStore.getPrezzoVendita(), ""+checkStore.getPrezzoVendita());
		assertEquals(""+newStore.getPrezzoAcquisto(), ""+checkStore.getPrezzoAcquisto());
		assertEquals(""+newStore.getQuantita(), ""+checkStore.getQuantita());	
	}

	@Test
	public void testModificaProdottoStella() throws SQLException, ClassNotFoundException 
	{
		Stella oldStella = new Stella();
		oldStella.setCoordinate("220,98 +34,67 11,13");
		oldStella.setDescrizione("È una stella australe che splende nella parte sud-est della costellazione del Cane, in corrispondenza della punta della coda. È ben visibile solo nelle zone temperate dell'emisfero boreale.");
		oldStella.setSrc("images/stelle/melissa.jpg");
		oldStella.setPrezzo(26);
		oldStella.setNome("Melissa");
		oldStella.setData("2016-08-09");
		
		Stella newStella = new Stella();
		newStella.setCoordinate("111 111 111");
		newStella.setDescrizione(" ");
		newStella.setSrc(" ");
		newStella.setPrezzo(0);
		newStella.setNome(" ");
		newStella.setData(" ");
		
		mp.modificaProdottoStella(oldStella, newStella);
		(new ManagerProdotti()).registraProdottoStella(oldStella);	
		
		result = statement.executeQuery("SELECT coordinate, descrizione, src, prezzoVendita, nome, data FROM STELLE WHERE coordinate='111 111 111'");

		Stella checkStella = new Stella();
		checkStella.setCoordinate(result.getString(1));
		checkStella.setDescrizione(result.getString(2));
		checkStella.setSrc(result.getString(3));
		checkStella.setPrezzo(result.getInt(4));
		checkStella.setNome(result.getString(5));
		checkStella.setData(result.getString(6));
		
		statement.executeUpdate("DELETE FROM STELLE WHERE coordinate='111 111 111'");
		
		assertEquals(newStella.getCoordinate(), checkStella.getCoordinate());
		assertEquals(newStella.getDescrizione(), checkStella.getDescrizione());
		assertEquals(""+newStella.getPrezzo(), ""+checkStella.getPrezzo());
		assertEquals(newStella.getNome(), checkStella.getNome());
		assertEquals(newStella.getData(), checkStella.getData());
	}

	@Test
	public void testEliminaStella() throws SQLException, ClassNotFoundException 
	{
		Stella oldStella = new Stella();
		oldStella.setCoordinate("220,98 +34,67 111,13");
		oldStella.setDescrizione("È una stella australe che splende nella parte sud-est della costellazione del Cane, in corrispondenza della punta della coda. È ben visibile solo nelle zone temperate dell'emisfero boreale.");
		oldStella.setSrc("images/stelle/melissa.jpg");
		oldStella.setPrezzo(26);
		oldStella.setNome("Melissa");
		oldStella.setData("2016-08-09");
		
		mp.eliminaStella("220,98 +34,67 111,13");
		
		result = statement.executeQuery("SELECT coordinate FROM STELLE WHERE coordinate LIKE '220,98 +34,67 111,13'");
		new ManagerProdotti().registraProdottoStella(oldStella);
		assertFalse(result.next());
	}

	@Test
	public void testEliminaProdottoStore() throws SQLException, ClassNotFoundException 
	{
		Store oldStore = new Store();
		oldStore.setNome("Telescopio Omegon");
		oldStore.setData("2016-12-09");
		oldStore.setDescrizione("Prodotto di prezzo accessibile con una distanza focale di 500 mm, quindi con un notevole zoom standard senza ingrandimenti e un diametro dell’ottica di 50 mm.");
		oldStore.setSrc("images/store/telescopio_omegeon.jpg");
		oldStore.setPrezzoAcquisto(20);
		oldStore.setPrezzoVendita(35);
		oldStore.setQuantita(410);
		
		mp.eliminaProdottoStore("Telescopio Omegon");
		
		result = statement.executeQuery("SELECT nome FROM STORE WHERE nome LIKE 'Telescopio Omegon'");
		new ManagerProdotti().registraProdottoStore(oldStore);
		assertFalse(result.next());
	}
}
