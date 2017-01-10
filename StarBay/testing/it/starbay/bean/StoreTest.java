package it.starbay.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.Store;

public class StoreTest {
	
	private Store store;
	@Before
	public void setUp() throws Exception 
	{
		store = new Store();
		store.setNome("Telescopio Omegon");
		store.setDescrizione("Prodotto di prezzo accessibile con una distanza focale di 500 mm, quindi con un notevole zoom standard senza ingrandimenti e un diametro dell’ottica di 50 mm.");
		store.setSrc("images/store/telescopio_omegeon.jpg");
		store.setPrezzoVendita(35);
		store.setQuantita(700);
		store.setPrezzoAcquisto(20);
		store.setData("2016-12-09");
		assertNotNull(store);
	}

	@After
	public void tearDown() throws Exception
	{
		store = null;
	}
	
	@Test
	public void TestGetNome()
	{
		String nome = store.getNome();
		assertEquals("Telescopio Omegon", nome);
	}
	
	@Test
	public void TestGetDescrizione()
	{
		String descrizione = store.getDescrizione();
		assertEquals("Prodotto di prezzo accessibile con una distanza focale di 500 mm, quindi con un notevole zoom standard senza ingrandimenti e un diametro dell’ottica di 50 mm.", descrizione);
	}

	@Test
	public void TestGetSrc()
	{
		String src = store.getSrc();
		assertEquals("images/store/telescopio_omegeon.jpg", src);
	}
	
	@Test
	public void TestGetPrezzoVendita()
	{
		double prezzoVendita = store.getPrezzoVendita();
		assertEquals(35,prezzoVendita, 35 - prezzoVendita);
	}
	
	@Test
	public void TestGetQuantita()
	{
		int quantita = store.getQuantita();
		assertEquals(700,quantita, 700 - quantita);
	}
	
	@Test
	public void TestGetPrezzoAcquisto()
	{
		double prezzoAcquisto = store.getPrezzoAcquisto();
		assertEquals(20,prezzoAcquisto, 20 - prezzoAcquisto);
	}
	
	@Test
	public void TestGetData()
	{
		String data = store.getData();
		assertEquals("2016-12-09", data);
	}
	
	@Test
	  public void testSetNome()
	  {
	    String nome = "Telescopio Optics";
	    store.setNome(nome);
	    assertEquals("Telescopio Optics", store.getNome());
	  }
	
	@Test
	  public void testSetDescrizione()
	  {
	    String descrizione = "Telescopio ultraleggero PowerSeeker 70AZ, con accessori e treppiede in alluminio, ultraleggero progettato per i principianti.";
	    store.setDescrizione(descrizione);
	    assertEquals("Telescopio ultraleggero PowerSeeker 70AZ, con accessori e treppiede in alluminio, ultraleggero progettato per i principianti.", store.getDescrizione());
	  }
	
	@Test
	  public void testSetSrc()
	  {
	    String src = "images/store/telescopio_optics.jpg";
	    store.setSrc(src);
	    assertEquals("images/store/telescopio_optics.jpg", store.getSrc());
	  }
	
	@Test
	  public void testSetPrezzoVendita()
	  {
	    double prezzoVendita = 110;
	    store.setPrezzoVendita(prezzoVendita);
	    assertEquals(110, store.getPrezzoVendita(),110-store.getPrezzoVendita());
	  }
	
	@Test
	  public void testSetQuantita()
	  {
	    int quantita = 550;
	    store.setQuantita(quantita);
	    assertEquals(550, store.getQuantita(),550-store.getQuantita());
	  }
	
	@Test
	  public void testSetPrezzoAcquisto()
	  {
	    double prezzoAcquisto = 70;
	    store.setPrezzoVendita(70);
	    assertEquals(70, store.getPrezzoAcquisto(),70-store.getPrezzoAcquisto());
	  }
	
	@Test
	  public void testSetData()
	  {
	    String data = "2016-11-22";
	    store.setData(data);
	    assertEquals("2016-11-22", store.getData());
	  }
}
