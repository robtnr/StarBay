package it.starbay.gestionebean;

/**
 * Bean ProdottoCarrello
 * Classe che rappresenta il prodotto inserito nel carrello
 *
 */

public class ProdottoCarrello 
{
	/**
	 * Costruttore vuoto
	 * 
	 */
	public ProdottoCarrello()
	{
		
	}
	
	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public int getQuantita()
	{
		return quantita;
	}

	public void setQuantita(String tipo, int numero) 
	{
		if(tipo.equals("incrementa"))
		this.quantita++;
		else if(tipo.equals("decrementa"))
		this.quantita--;
		else if(tipo.equals("cambio"))
		this.quantita = numero;
	}

	public String getData() 
	{
		return data;
	}
	
	public void setData(String data) 
	{
		this.data = data;
	}
	
	public double getPrezzo() 
	{
		return prezzo;
	}
	
	public void setPrezzo(double prezzo) 
	{
		this.prezzo = prezzo;
	}
	
	/**
	 * data rappresenta la data di inserimento nel carrello di un prodotto
	 */
	private String data;
	
	/**
	 * nome rappresenta il nome del prodotto inserito nel carrello
	 */
	private String nome;
	
	/**
	 * prezzo rappresenta il prezzo del/i prodotto/i inserito nel carrello
	 */
	private double prezzo;
	
	/**
	 * quantita rappresenta la quantita del prodotto inserito nel carrello
	 */
	private int quantita=0;
	
}
