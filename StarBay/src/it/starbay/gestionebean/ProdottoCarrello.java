package it.starbay.gestionebean;

public class ProdottoCarrello 
{
	
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

	public void setQuantita(String tipo) 
	{
		if(tipo.equals("incrementa"))
		this.quantita++;
		else
		this.quantita--;
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
