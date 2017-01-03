package it.starbay.gestionebean;

public class Store 
{
	/**
	 * Costruttore vuoto
	 * 
	 */
	public Store()
	{
		
	}
	
	public String getNome() 
	{
		return nome;
	}

	public double getPrezzoAcquisto() 
	{
		return prezzoAcquisto;
	}
	
	public double getPrezzoVendita() 
	{
		return prezzoVendita;
	}

	public int getQuantita() 
	{
		return quantita;
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

	public void setPrezzoAcquisto(double prezzoAcquisto) 
	{
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public void setPrezzoVendita(double prezzoVendita) 
	{
		this.prezzoVendita = prezzoVendita;
	}
	
	public void setQuantita(int quantita) 
	{
		this.quantita = quantita;
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
	 * prezzoAcquisto rappresenta il prezzo d'acquisto di un prodotto dello store
	 */
	private double prezzoAcquisto;
	
	/**
	 * prezzoVendita rappresenta il prezzo di vendita di un prodotto dello store
	 */
	private double prezzoVendita;
	
	/**
	 * quantita rappresenta le quantita di un prodotto dello store
	 */
	private int quantita;
	
	/**
	 * descrizione rappresenta una breve descrizione di un prodotto dello store
	 */
	private String descrizione;
	
	/**
	 * src rappresenta l'src dell'immagine rappresentante il prodotto dello store
	 */
	private String src;
	
	/**
	 * data rappresenta la data di inserimento della stella
	 */
	private String data;
}
