package it.starbay.manager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionestatistiche.ManagerStatistiche;

public class ManagerStatisticheTest {

	private ManagerStatistiche ms;

	@Before
	public void setUp() throws Exception 
	{
		ms = new ManagerStatistiche();
	}

	@After
	public void tearDown() throws Exception 
	{
		ms = null;
	}

	@Test
	public void testDammiGuadagnoTotale() 
	{
		assertNotNull(ms.dammiGuadagnoTotale());
	}

	@Test
	public void testDammiRicavoTotale() 
	{
		assertNotNull(ms.dammiRicavoTotale());
	}

	@Test
	public void testDammiGuadagnoSingoloProdotto() 
	{
		assertNotNull(ms.dammiGuadagnoSingoloProdotto());
	}

}
