package it.starbay.gestionebean;

public class Ordine 
{
	private int idOrdine;
	private String data;
	private String ora;
	private int idDettaglioOrdine;
	private int quantita;
	private double prezzo;
	private String idProdotto;
	private String nomeProdotto;
	public String getNomeProdotto() {
		return nomeProdotto;
	}

	public void setNomeProdotto(String nomeProdotto) {
		this.nomeProdotto = nomeProdotto;
	}

	private String tipo;
	
	public Ordine() {}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public int getIdDettaglioOrdine() {
		return idDettaglioOrdine;
	}

	public void setIdDettaglioOrdine(int idDettaglioOrdine) {
		this.idDettaglioOrdine = idDettaglioOrdine;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public String getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(String idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
