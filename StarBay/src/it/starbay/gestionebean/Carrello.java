package it.starbay.gestionebean;

import java.util.ArrayList;
/**
 * Bean Carrello
 * Classe che rappresenta il carrello del cliente
 *
 */

public class Carrello 
{
	/**
	 * Costruttore Vuoto
	 * 
	 */
	public Carrello()
	{
		
	}
	
	public String getUsername() 
	{
		return username;
	}
	
	public void setUsername(String username) 
	{
		this.username = username;
	}
	
	public ArrayList<ProdottoCarrello> getProdotti() 
	{
		return prodotti;
	}
	
	public void setProdotti(ProdottoCarrello prodottoCarrello) 
	{
		this.prodotti.add(prodottoCarrello);
	}
	
	public double getTotale() 
	{
		return totale;
	}
	
	public void setTotale(double totale,String tipo) 
	{
		if(tipo.equals("incrementa"))
		this.totale+= totale;
		else
		this.totale-= totale;
	}
	
	/**
	 * username rappresenta l'username del cliente che aggiunge i prodotti al carrello(settato a none se è un cliente non registrato o non loggato)
	 */
	private String username="none";
	
	/**
	 * prodotti rappresenta un'arraylist contenenti i prodotti del carrello
	 */
	private ArrayList<ProdottoCarrello> prodotti = new ArrayList<ProdottoCarrello>();
	
	/**
	 * totale rappresenta il prezzo totale del carrello
	 */
	private double totale=0;
}
