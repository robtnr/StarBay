package it.starbay.gestionebean;

/**
 * Bean Stella 
 * Classe che rappresenta il prodotto stella all'interno del sistema
 *
 */

public class Stella 
{
	/**
	 * Costruttore vuoto
	 * 
	 */
	public Stella()
	{
		
	}
	
	public String getNome() 
	{
		return nome;
	}

	public double getPrezzo() 
	{
		return prezzo;
	}

	public String getCoordinate() 
	{
		return coordinate;
	}

	public String getDescrizione() 
	{
		return descrizione;
	}

	public String getSrc() 
	{
		return src;
	}

	public String getData() 
	{
		return data;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public void setPrezzo(double prezzo) 
	{
		this.prezzo = prezzo;
	}

	public void setCoordinate(String coordinate) 
	{
		this.coordinate = coordinate;
	}

	public void setDescrizione(String descrizione) 
	{
		this.descrizione = descrizione;
	}

	public void setSrc(String src) 
	{
		this.src = src;
	}

	public void setData(String data) 
	{
		this.data = data;
	}
	
	/**
	 * nome rappresenta il nome della stella
	 */
	private String nome;
	
	/**
	 * prezzo rappresenta il prezzo di vendita della stella
	 */
	private double prezzo;
	
	/**
	 * coordinate rappresenta le coordinate della stella
	 */
	private String coordinate;
	
	/**
	 * descrizione rappresenta una breve descrizione della stella
	 */
	private String descrizione;
	
	/**
	 * src rappresenta l'src dell'immagine rappresentante la stella
	 */
	private String src;
	
	/**
	 * data rappresenta la data di inserimento della stella
	 */
	private String data;
}
