package it.starbay.gestionebean;

/**
 * Bean Cliente 
 * Classe che rappresenta il cliente all'interno del sistema
 *
 */

public class Cliente 
{
	/**
	 * Costruttore vuoto
	 */
	
	public Cliente()
	{
		
	}
	
	public String getNome() 
	{
		return nome;
	}

	public String getCognome() 
	{
		return cognome;
	}

	public String getComune() 
	{
		return comune;
	}

	public String getIndirizzo() 
	{
		return indirizzo;
	}

	public String getEmail() 
	{
		return email;
	}

	public String getUsername() 
	{
		return username;
	}

	public String getPassword() 
	{
		return password;
	}

	public String getIban() 
	{
		return iban;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}
	
	public void setComune(String comune) 
	{
		this.comune = comune;
	}
	
	public void setIndirizzo(String indirizzo) 
	{
		this.indirizzo = indirizzo;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public void setIban(String iban) 
	{
		this.iban = iban;
	}	
	
	/**
	 * nome rappresenta il nome del cliente
	 */
	private String nome;
	
	/**
	 * cognome rappresenta il cognome del cliente
	 */
	private String cognome;
	
	/**
	 * comunue rappresenta il comune di residenza del cliente
	 */
	private String comune;
	
	/**
	 * indirizzo rappresenta l'indirizzo di residenza del cliente
	 */
	private String indirizzo;
	
	/**
	 * email rappresenta l'email del cliente
	 */
	private String email;
	
	/**
	 * username rappresenta l'username con il quale il cliente accederà al sito
	 */
	private String username;
	
	/**
	 * password rappresenta la password con il quale il cliente accederà al sito
	 */
	private String password;
	
	/**
	 * iban rappresenta le coordinate bancarie per poter acquistare prodotti
	 */
	private String iban;
}
