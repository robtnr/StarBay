package it.starbay.gestioneacquisti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Manager;

import it.starbay.gestionebean.Carrello;
import it.starbay.gestionebean.Ordine;
import it.starbay.gestionebean.ProdottoCarrello;

/**
 * Servlet implementation class ServletAcquistaCarrello
 */
@WebServlet("/ServletAcquistaCarrello")
public class ServletAcquistaCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<String> stelle_inserite;
    private HttpSession sessione;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		sessione = request.getSession();
		boolean errore = false;
		boolean trovata_stella = false;
		int quantita_esatta = 0;
		ArrayList quantita_nome = new ArrayList();
		ArrayList quantita_nome_header = new ArrayList();
		Carrello carrello = (Carrello)sessione.getAttribute("carrello");
		if(carrello.getUsername().equals("none"))
			response.setHeader("mex_acquisto","errore_non_loggato");
		else
		{
			ArrayList<ProdottoCarrello> prodotti = carrello.getProdotti();
			boolean stelle_presenti = false;
			if(sessione.getAttribute("stelle_inserite")!=null)
			{
				stelle_inserite = (ArrayList<String>)sessione.getAttribute("stelle_inserite");
				stelle_presenti = true;
			}
			
			//Richiama le quantità
			for(ProdottoCarrello p:prodotti)
			{
				ManagerAcquisti manager;
				try 
				{
					manager = new ManagerAcquisti();
					if(stelle_presenti == true)
					{
						for(int i=0;i<stelle_inserite.size();i=i+2)
						{
							if(stelle_inserite.get(i).equals(p.getNome()) || stelle_inserite.get(i+1).equals(p.getNome()))
							{
								quantita_esatta = manager.getQuantitaProdotto(stelle_inserite.get(i),"stella");
								quantita_nome.add(p.getNome());
								quantita_nome.add(quantita_esatta);
								trovata_stella = true;
							}
							if(trovata_stella == true)
								break;
						}
					}
					if(trovata_stella == false)
					{
						quantita_esatta = manager.getQuantitaProdotto(p.getNome(),"store");
						quantita_nome.add(p.getNome());
						quantita_nome.add(quantita_esatta);
					}
					trovata_stella = false;
				} catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
			
			//Controllo quantità
			for(int i=0;i<prodotti.size();i++)
			{
				for(int j=0;j<quantita_nome.size(); j=j+2)
				{
					String nome = (String)quantita_nome.get(j);
					int quantita_trovata = (Integer) quantita_nome.get(j+1);
					if(prodotti.get(i).getNome().equals(nome))
					{
						if(prodotti.get(i).getQuantita()>quantita_trovata)
						{
							errore = true;
							int quantita_vecchia = prodotti.get(i).getQuantita();
							carrello.getProdotti().get(i).setQuantita("cambio",quantita_trovata);
							carrello.setTotale((quantita_vecchia-quantita_trovata)*prodotti.get(i).getPrezzo(), "decrementa");
							//verrà inserito all'interno degli header
							if(quantita_vecchia==1 && quantita_trovata==0)
							{
								
							}
							else
							{
							quantita_nome_header.add("quantita_sottratta");
							quantita_nome_header.add(nome);
							quantita_nome_header.add(quantita_trovata);
							quantita_nome_header.add(quantita_vecchia);
							}
						}
						
						if(quantita_trovata==0)
						{
							quantita_nome_header.add("quantita_eliminata");
							quantita_nome_header.add(nome);
							quantita_nome_header.add(quantita_trovata);
							quantita_nome_header.add(prodotti.get(i).getQuantita());
							carrello.getProdotti().remove(i);
						}
							
					}
				}
			}
			
			
			for(int i=0;i<quantita_nome_header.size();i=i+4)
			{
				String tipo = (String)quantita_nome_header.get(i);
				String nome = (String)quantita_nome_header.get(i+1);
				int quantita_trovata = (Integer)quantita_nome_header.get(i+2);
				int quantita_vecchia = (Integer)quantita_nome_header.get(i+3);
			}
			
			
			if(errore == false)
			{
				response.setHeader("mex_acquisto", "ok");
				creaOrdine();
				sessione.removeAttribute("carrello");
				sessione.removeAttribute("stelle_inserite");
				sessione.removeAttribute("stelle");
				sessione.removeAttribute("prodotti_store");
				sessione.removeAttribute("store_ultimi_prodotti");
				sessione.removeAttribute("stelle_ultimi_prodotti");
				sessione.removeAttribute("ordini");
			}
			else
			{
				sessione.setAttribute("carrello", carrello);
				response.setHeader("mex_acquisto", "nok");
				int y = 1;
				for(int i=0;i<quantita_nome_header.size();i=i+4)
				{
					String tipo = (String)quantita_nome_header.get(i);
					String nome = (String)quantita_nome_header.get(i+1);
					int quantita_trovata = (Integer)quantita_nome_header.get(i+2);
					int quantita_vecchia = (Integer)quantita_nome_header.get(i+3);
					response.setHeader("tipo"+y, tipo);
					response.setHeader("nome"+y, nome);
					response.addIntHeader("quantita_trovata"+y, quantita_trovata);
					response.addIntHeader("quantita_vecchia"+y, quantita_vecchia);
					y++;
				}
				response.addIntHeader("lunghezza_header", y);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	public void creaOrdine()
	{
		ManagerAcquisti manager;
		try 
		{
			manager = new ManagerAcquisti();
			int idOrdine = manager.getCountOrdine();
			
			salvaOrdine(idOrdine);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	public void salvaOrdine(int idOrdine) 
	{ 
		ArrayList<String> stelle_inserite;
		Carrello carrello = (Carrello)sessione.getAttribute("carrello");
		boolean trovata_stella = false;
		
		Ordine ordine = new Ordine();
		ordine.setIdOrdine(++idOrdine);
		
		GregorianCalendar oggi = new GregorianCalendar();
		int gg = oggi.get(Calendar.DAY_OF_MONTH);
		int mm = oggi.get(Calendar.MONTH);
		int aa = oggi.get(Calendar.YEAR);
		ordine.setData("" + aa + "-" + (mm+1) + "-" + gg);
		
		int ore = oggi.get(Calendar.HOUR);
		int min = oggi.get(Calendar.MINUTE);
		int sec = oggi.get(Calendar.SECOND);
		ordine.setOra(""+ore+":"+min+":"+sec);
		
		ordine.setUsername(carrello.getUsername());
		
		ManagerAcquisti manager;
		try 
		{
			manager = new ManagerAcquisti();
			manager.creaOrdine(ordine);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		for(ProdottoCarrello p: carrello.getProdotti())
		{
			ordine.setPrezzo(p.getPrezzo());
			ordine.setQuantita(p.getQuantita());
			ordine.setNomeProdotto(p.getNome());
			if(sessione.getAttribute("stelle_inserite")!=null)
			{
				stelle_inserite = (ArrayList<String>)sessione.getAttribute("stelle_inserite");
				for(int i=0;i<stelle_inserite.size();i=i+2)
				{
					if(stelle_inserite.get(i).equals(p.getNome()) || stelle_inserite.get(i+1).equals(p.getNome()))
					{
						trovata_stella = true;
						ordine.setIdProdotto(stelle_inserite.get(i));
					}
					if(trovata_stella == true)
						break;
				}
			}
			if(trovata_stella==true)
				ordine.setTipo("stella");
			else
				ordine.setTipo("store");
			trovata_stella = false;
			creaDettaglioOrdine(ordine);
		}
		
	}

	public void creaDettaglioOrdine(Ordine ordine) 
	{
		int idDettaglioOrdine;
		try 
		{
			ManagerAcquisti manager = new ManagerAcquisti();
			idDettaglioOrdine = manager.getCountDettaglioOrdine();
			ordine.setIdDettaglioOrdine(++idDettaglioOrdine);
			manager.creaDettagliOrdine(ordine);
			
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(ordine.getTipo().equals("stella"))
			creaIncludeStella(ordine);
		else
			creaIncludeStore(ordine);
		
		aggiornaQuantitaENome(ordine);
	}

	public void creaIncludeStella(Ordine ordine) 
	{
		ManagerAcquisti manager;
		try 
		{
			manager = new ManagerAcquisti();
			manager.creaIncludeStella(ordine);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
			
	}

	public void creaIncludeStore(Ordine ordine) 
	{
		ManagerAcquisti manager;
		try 
		{
			manager = new ManagerAcquisti();
			manager.creaIncludeStore(ordine);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
			
	}
	
	private void aggiornaQuantitaENome(Ordine ordine) 
	{
		ManagerAcquisti manager;
		try 
		{
			manager = new ManagerAcquisti();
			manager.aggiornaQuantitaNomeProdotto(ordine);;
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
}
