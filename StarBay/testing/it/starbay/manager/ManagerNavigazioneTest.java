package it.starbay.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;
import it.starbay.gestionenavigazione.ManagerNavigazione;

public class ManagerNavigazioneTest {

	private ManagerNavigazione mn;

	@Before
	public void setUp() throws Exception {
		mn = new ManagerNavigazione();
	}

	@After
	public void tearDown() throws Exception {
		mn = null;
	}

	@Test
	public void testCaricaUltimiProdotti() 
	{
		ArrayList<Store> store = new ArrayList<Store>();
		store = mn.caricaUltimiProdotti("store");
		assertNotNull(store);
	}

	@Test
	public void testCaricaProdottiStella() 
	{
		ArrayList<Stella> stelle = new ArrayList<Stella>();
		stelle = mn.caricaProdottiStella();
		assertNotNull(stelle);
	}

	@Test
	public void testCaricaProdottiStore() 
	{
		ArrayList<Store> store = new ArrayList<Store>();
		store = mn.caricaProdottiStore();
		assertNotNull(store);
	}

	@Test
	public void testCaricaProdotti() 
	{
		ArrayList<Store> store = new ArrayList<Store>();
		store = mn.caricaProdotti("store");
		assertNotNull(store);
	}

	@Test
	public void testCercaProdotti() 
	{
		ArrayList prodotti_trovati = new ArrayList(); 
		prodotti_trovati = mn.cercaProdotti("Melissa");
		assertNotNull(prodotti_trovati);
	}
}