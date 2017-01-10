package it.starbay.bean;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.Stella;

public class StellaTest 
{
	private Stella stella;
	@Before
	public void setUp() throws Exception 
	{
		stella = new Stella();
		stella.setCoordinate("267,98 -36,54 144,13 -41,67");
		stella.setNome("Urania");
		stella.setPrezzo(30);
		stella.setSrc("images/stelle/urania.jpg");
		stella.setData("2017-01-03");
		stella.setDescrizione("Nota anche come Nodus I, è una stella della costellazione del Dragone. Classificata come una gigante blu di classe spettrale B9 III, dista 300 anni luce dalla Terra.");
		assertNotNull(stella);
	}

	@After
	public void tearDown() throws Exception 
	{
		stella = null;
	}
	
	@Test
	public void TestGetCoordinate()
	{
		String coordinate = stella.getCoordinate();
		assertEquals("267,98 -36,54 144,13 -41,67", coordinate);
	}
	
	@Test
	public void TestGetNome()
	{
		String nome = stella.getNome();
		assertEquals("Urania", nome);
	}
	
	@Test
	public void TestGetPrezzo()
	{
		double prezzo = stella.getPrezzo();
		assertEquals(30, prezzo, 30-prezzo);
	}
	
	public void TestGetSrc()
	{
		String src = stella.getSrc();
		assertEquals("images/stelle/urania.jpg", src);
	}
	
	public void TestGetData()
	{
		String data = stella.getData();
		assertEquals("2017-01-03", data);
	}
	
	public void TestGetDescrizione()
	{
		String descrizione = stella.getDescrizione();
		assertEquals("Nota anche come Nodus I, è una stella della costellazione del Dragone. Classificata come una gigante blu di classe spettrale B9 III, dista 300 anni luce dalla Terra.", descrizione);
	}
	
	@Test
	  public void testSetCoordinate()
	  {
	    String coordinate = "220,98 +34,67 111,13 -44,67";
	    stella.setCoordinate(coordinate);
	    assertEquals("220,98 +34,67 111,13 -44,67", stella.getCoordinate());
	  }
	
	@Test
	  public void testSetNome()
	  {
	    String nome = "Melissa";
	    stella.setNome(nome);
	    assertEquals("Melissa", stella.getNome());
	  }
	
	@Test
	  public void testSetPrezzo()
	  {
	    double prezzo = 26;
	    stella.setPrezzo(prezzo);
	    assertEquals(26, stella.getPrezzo(),26-stella.getPrezzo());
	  }
	
	@Test
	  public void testSetSrc()
	  {
	    String src = "images/stelle/melissa.jpg";
	    stella.setSrc(src);
	    assertEquals("images/stelle/melissa.jpg", stella.getSrc());
	  }
	
	@Test
	  public void testSetData()
	  {
	    String data = "2016-08-09";
	    stella.setData(data);
	    assertEquals("2016-08-09", stella.getData());
	  }
	
	@Test
	  public void testSetDescrizione()
	  {
	    String descrizione = "È una stella australe che splende nella parte sud-est della costellazione del Cane, in corrispondenza della punta della coda. È ben visibile solo nelle zone temperate dell'emisfero boreale.";
	    stella.setDescrizione(descrizione);
	    assertEquals("È una stella australe che splende nella parte sud-est della costellazione del Cane, in corrispondenza della punta della coda. È ben visibile solo nelle zone temperate dell'emisfero boreale.", stella.getDescrizione());
	  }

}
