package it.starbay.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.ProdottoCarrello;

public class ProdottoCarrelloTest {
	private ProdottoCarrello prodottoCarrello;
	@Before
	public void setUp() throws Exception 
	{
		prodottoCarrello = new ProdottoCarrello();
		prodottoCarrello.setNome("Telescopio Newton");
		prodottoCarrello.setQuantita("incrementa", 0);
		prodottoCarrello.setPrezzo(200);
		prodottoCarrello.setData("2016-01-11");
		assertNotNull(prodottoCarrello);
	}

	@After
	public void tearDown() throws Exception 
	{
		prodottoCarrello = null;
	}
	
	@Test
	public void TestGetNome()
	{
		String nome = prodottoCarrello.getNome();
		assertEquals("Telescopio Newton", nome);
	}
	
	@Test
	public void TestGetQuantita()
	{
		int quantita = prodottoCarrello.getQuantita();
		assertEquals(1, quantita);
	}
	
	@Test
	public void TestGetPrezzo()
	{
		double prezzo = prodottoCarrello.getPrezzo();
		assertEquals(200, prezzo, 200-prezzo);
	}
	
	@Test
	public void TestGetData()
	{
		String data = prodottoCarrello.getData();
		assertEquals("2016-01-11", data);
	}
	
	@Test
	  public void testSetNome()
	  {
	    String nome = "Telescopio Omegon";
	    prodottoCarrello.setNome(nome);
	    assertEquals("Telescopio Omegon", prodottoCarrello.getNome());
	  }
	
	@Test
	  public void testSetQuantita()
	  {
		prodottoCarrello.setQuantita("decrementa",0);
		assertEquals(0, prodottoCarrello.getQuantita());
	    prodottoCarrello.setQuantita("incrementa",0);
	    assertEquals(1, prodottoCarrello.getQuantita());
	    prodottoCarrello.setQuantita("cambio", 3);
	    assertEquals(3, prodottoCarrello.getQuantita());
	  }
	
	@Test
	  public void testSetPrezzo()
	  {
	    double prezzo = 35;
	    prodottoCarrello.setPrezzo(prezzo);
	    assertEquals(35, prezzo, 35-prezzo);
	  }
	
	@Test
	  public void testSetData()
	  {
	    String data = "2016-12-09";
	    prodottoCarrello.setData(data);
	    assertEquals("2016-12-09", prodottoCarrello.getData());
	  }

}
