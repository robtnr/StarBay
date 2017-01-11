package it.starbay.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.Carrello;
import it.starbay.gestionebean.ProdottoCarrello;

public class CarrelloTest {
	
	private Carrello carrello;
	@Before
	public void setUp() throws Exception 
	{
		carrello = new Carrello();
		carrello.setProdotti(new ProdottoCarrello());
		carrello.setTotale(30, "incrementa");
		carrello.setUsername("robtnr");
		assertNotNull(carrello);
		
	}

	@After
	public void tearDown() throws Exception 
	{
		carrello = null;
	}


	@Test
	public void testGetUsername() 
	{
		String username = carrello.getUsername();
		assertEquals("robtnr", username);
	}

	@Test
	public void testSetUsername() 
	{
		String username = "giandark";
		carrello.setUsername(username);
		assertEquals("giandark", carrello.getUsername());
	}

	@Test
	public void testGetProdotti() 
	{
		ArrayList<ProdottoCarrello> prodotti = carrello.getProdotti();
		assertEquals(1, prodotti.size());
	}

	@Test
	public void testSetProdotti() 
	{
		ProdottoCarrello prodotto = new ProdottoCarrello();
		carrello.setProdotti(prodotto);
		assertEquals(2, carrello.getProdotti().size());
	}

	@Test
	public void testGetTotale() 
	{
		double totale = carrello.getTotale();
		assertEquals(30, totale, 30-totale);
	}

	@Test
	public void testSetTotale() 
	{
		double prezzo = 30;
		carrello.setTotale(prezzo,"decrementa");;
		assertEquals(0, carrello.getTotale(), 0-carrello.getTotale());
	}

}
