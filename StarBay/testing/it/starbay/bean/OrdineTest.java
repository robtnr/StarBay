package it.starbay.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.Ordine;

public class OrdineTest {
	
	private Ordine ordine;
	@Before
	public void setUp() throws Exception 
	{
		ordine = new Ordine();
		ordine.setIdOrdine(1);
		ordine.setUsername("robtnr94");
		ordine.setDescrizione("Prodotto di prezzo accessibile con una distanza focale di 500 mm, quindi con un notevole zoom standard senza ingrandimenti e un diametro dell’ottica di 50 mm.");
		ordine.setData("2016-12-09");
		ordine.setOra("20:45:20");
		ordine.setIdDettaglioOrdine(1);
		ordine.setQuantita(700);
		ordine.setPrezzo(35);
		ordine.setIdProdotto("Telescopio Omegon");
		ordine.setNomeProdotto("");
		ordine.setTipo("store");
		assertNotNull(ordine);
	}

	@After
	public void tearDown() throws Exception 
	{
		ordine = null;
	}

	@Test
	public void testGetUsername() 
	{
		String username = ordine.getUsername();
		assertEquals("robtnr94", username);
	}

	@Test
	public void testGetDescrizione() 
	{
		String descrizone = ordine.getDescrizione();
		assertEquals("Prodotto di prezzo accessibile con una distanza focale di 500 mm, quindi con un notevole zoom standard senza ingrandimenti e un diametro dell’ottica di 50 mm.", descrizone);
	}

	@Test
	public void testSetUsername() 
	{
		String username = "giandark";
		ordine.setUsername(username);
		assertEquals("giandark", ordine.getUsername());
	}

	@Test
	public void testSetDescrizione() 
	{
		String descrizione = "giandark";
		ordine.setDescrizione("Telescopio ultraleggero PowerSeeker 70AZ, con accessori e treppiede in alluminio, ultraleggero progettato per i principianti.");
		assertEquals("Telescopio ultraleggero PowerSeeker 70AZ, con accessori e treppiede in alluminio, ultraleggero progettato per i principianti.", ordine.getDescrizione());
	}

	@Test
	public void testGetNomeProdotto() 
	{
		if(ordine.getTipo().equals("store"))
		{
			String nomeProdotto = ordine.getNomeProdotto();
			assertEquals("", nomeProdotto);
		}
		else
		{
			String nomeProdotto = ordine.getNomeProdotto();
			assertEquals("Urania", nomeProdotto);
		}
	}

	@Test
	public void testSetNomeProdotto() 
	{
		if(ordine.getTipo().equals("store"))
		{
			String nomeProdotto = "";
			ordine.setNomeProdotto(nomeProdotto);
			assertEquals("", ordine.getNomeProdotto());
		}
		else
		{
			String nomeProdotto = "Urania";
			ordine.setNomeProdotto(nomeProdotto);
			assertEquals("Urania", ordine.getNomeProdotto());
		}
	}

	@Test
	public void testGetIdOrdine() 
	{
		int idOrdine = ordine.getIdOrdine();
		assertEquals(1, idOrdine);
	}

	@Test
	public void testSetIdOrdine() 
	{
		int idOrdine = 1;
		ordine.setIdOrdine(idOrdine);
		assertEquals(1, ordine.getIdOrdine());
	}

	@Test
	public void testGetData() 
	{
		String data = ordine.getData();
		assertEquals("2016-12-09", data);
	}

	@Test
	public void testSetData() 
	{
		String data = "2017-01-05";
		ordine.setData(data);
		assertEquals("2017-01-05",ordine.getData());
	}

	@Test
	public void testGetOra() 
	{
		String ora = ordine.getOra();
		assertEquals("20:45:20", ora);
	}

	@Test
	public void testSetOra() 
	{
		String ora = "12:32:30";
		ordine.setOra(ora);
		assertEquals("12:32:30",ordine.getOra());
	}

	@Test
	public void testGetIdDettaglioOrdine() 
	{
		int idDettagliOrdine = ordine.getIdDettaglioOrdine();
		assertEquals(1, idDettagliOrdine);
	}

	@Test
	public void testSetIdDettaglioOrdine() 
	{
		int idDettagliOrdine = 1;
		ordine.setIdDettaglioOrdine(idDettagliOrdine);
		assertEquals(1,ordine.getIdDettaglioOrdine());
	}

	@Test
	public void testGetQuantita() 
	{
		int quantita = ordine.getQuantita();
		assertEquals(700, quantita);
	}

	@Test
	public void testSetQuantita() 
	{
		int quantita = 550;
		ordine.setQuantita(quantita);
		assertEquals(550,ordine.getQuantita());
	}

	@Test
	public void testGetPrezzo() 
	{
		double prezzo = ordine.getPrezzo();
		assertEquals(35, prezzo, 35-prezzo);
	}

	@Test
	public void testSetPrezzo() 
	{
		double prezzo = 110;
		ordine.setPrezzo(prezzo);
		assertEquals(110,ordine.getPrezzo(),110-ordine.getPrezzo());
	}

	@Test
	public void testGetIdProdotto() 
	{
		if(ordine.getTipo().equals("store"))
		{
			String idProdotto = ordine.getIdProdotto();
			assertEquals("Telescopio Omegon", idProdotto);
		}
		else
		{
			String idProdotto = ordine.getIdProdotto();
			assertEquals("267,98 -36,54 144,13", idProdotto);
		}
	}

	@Test
	public void testSetIdProdotto() 
	{
		if(ordine.getTipo().equals("store"))
		{
			String idProdotto = "Telescopio Optics";
			ordine.setIdProdotto(idProdotto);
			assertEquals("Telescopio Optics", ordine.getIdProdotto());
		}
		else
		{
			String idProdotto = "220,98 +34,67 111,13";
			ordine.setIdProdotto(idProdotto);
			assertEquals("220,98 +34,67 111,13", ordine.getIdProdotto());
		}
	}

	@Test
	public void testGetTipo() 
	{
		String tipo = ordine.getTipo();
		assertEquals("store", tipo);
	}

	@Test
	public void testSetTipo() 
	{
		String tipo = "stella";
		ordine.setTipo(tipo);
		assertEquals("stella", ordine.getTipo());
	}


}
