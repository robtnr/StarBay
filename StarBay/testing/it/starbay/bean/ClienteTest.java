package it.starbay.bean;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.starbay.gestionebean.Cliente;

public class ClienteTest {
	private Cliente cliente;
	@Before
	public void setUp() throws Exception 
	{
		cliente = new Cliente();
		cliente.setNome("Roberto");
		cliente.setCognome("Contaldo");
		cliente.setEmail("roberto.cont@gmail.com");
		cliente.setComune("Nocera Inferiore");
		cliente.setIndirizzo("Via gennaro orlando 41");
		cliente.setUsername("robtnr");
		cliente.setPassword("juventus");
		cliente.setIban("IT05G9636699139646736576803");
		assertNotNull(cliente);
	}

	@After
	public void tearDown() throws Exception 
	{
		cliente = null;
	}
	
	@Test
	public void TestGetNome()
	{
		String nome = cliente.getNome();
		assertEquals("Roberto", nome);
	}
	
	@Test
	public void TestGetCognome()
	{
		String cognome = cliente.getCognome();
		assertEquals("Contaldo", cognome);
	}
	
	@Test
	public void TestGetEmail()
	{
		String email = cliente.getEmail();
		assertEquals("roberto.cont@gmail.com", email);
	}
	
	@Test
	public void TestGetComune()
	{
		String comune = cliente.getComune();
		assertEquals("Nocera Inferiore", comune);
	}
	
	@Test
	public void TestGetIndirizzo()
	{
		String indirizzo = cliente.getIndirizzo();
		assertEquals("Via gennaro orlando 41", indirizzo);
	}
	
	@Test
	public void TestGetUsername()
	{
		String username = cliente.getUsername();
		assertEquals("robtnr", username);
	}
	
	@Test
	public void TestGetPassword()
	{
		String password = cliente.getPassword();
		assertEquals("juventus", password);
	}
	
	@Test
	public void TestGetIban()
	{
		String iban = cliente.getIban();
		assertEquals("IT05G9636699139646736576803", iban);
	}
	
	@Test
	  public void testSetNome()
	  {
	    String nome = "Gianluca";
	    cliente.setNome(nome);
	    assertEquals("Gianluca", cliente.getNome());
	  }
	
	@Test
	  public void testSetCognome()
	  {
	    String cognome = "De Luca Fiscone";
	    cliente.setCognome(cognome);
	    assertEquals("De Luca Fiscone", cliente.getCognome());
	  }
	
	@Test
	  public void testSetEmail()
	  {
	    String email = "gianluca.delucafiscone@gmail.com";
	    cliente.setEmail(email);
	    assertEquals("gianluca.delucafiscone@gmail.com", cliente.getEmail());
	  }
	
	@Test
	  public void testSetComune()
	  {
	    String comune = "Scafati";
	    cliente.setComune(comune);
	    assertEquals("Scafati", cliente.getComune());
	  }
	
	@Test
	  public void testSetIndirizzo()
	  {
	    String indirizzo = "via giuseppe vitiello 49";
	    cliente.setIndirizzo(indirizzo);
	    assertEquals("via giuseppe vitiello 49", cliente.getIndirizzo());
	  }
	
	@Test
	  public void testSetUsername()
	  {
	    String username = "giandark";
	    cliente.setUsername(username);
	    assertEquals("giandark", cliente.getUsername());
	  }
	
	@Test
	  public void testSetPassword()
	  {
	    String password = "giandark1";
	    cliente.setPassword(password);
	    assertEquals("giandark1", cliente.getPassword());
	  }
	
	@Test
	  public void testSetIban()
	  {
	    String iban = "IT06A1578001505955903068149";
	    cliente.setIban(iban);
	    assertEquals("IT06A1578001505955903068149", cliente.getIban());
	  }

}
