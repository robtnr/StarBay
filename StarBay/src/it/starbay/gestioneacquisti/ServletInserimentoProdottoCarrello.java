package it.starbay.gestioneacquisti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Carrello;
import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.ProdottoCarrello;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class ServletInserimentoCarrello
 */
@WebServlet("/ServletInserimentoProdottoCarrello")
public class ServletInserimentoProdottoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Carrello carrello;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sessione = request.getSession();
		String tipo = request.getHeader("tipo");
		//Calcolare la pagina di reindirizzamento
		calcoloHeaderIndirizzamento(request,response);
		if(sessione.getAttribute("carrello")==null)
		{
			//Se il carrello è vuoto
			carrello = new Carrello();
			if(tipo.equals("stella"))
			{	
				//Inserimento di una stella
				String nome_stella_nuova = request.getHeader("nome_stella_nuova");
				String nome_stella =(String) sessione.getAttribute("nome_stella");
				ProdottoCarrello prodotto = new ProdottoCarrello();
				//Controllo dei nomi delle stelle per vedere se è cambiato
				if(nome_stella.equals(nome_stella_nuova))
				{
					//Non cambia
					prodotto.setNome(nome_stella);
					//Array di nomi delle stelle
				}
				else
				{
					//nome stella cambia
					prodotto.setNome(nome_stella_nuova);
					//Array di nomi delle stelle
				}
				ArrayList<String> stelle_inserite = new ArrayList<String>();
				stelle_inserite.add(nome_stella);
				stelle_inserite.add(nome_stella_nuova);
				sessione.setAttribute("stelle_inserite", stelle_inserite);
				
				GregorianCalendar oggi = new GregorianCalendar();
				int gg = oggi.get(Calendar.DAY_OF_MONTH);
				int mm = oggi.get(Calendar.MONTH);
				int aa = oggi.get(Calendar.YEAR);
				
				prodotto.setData("" + aa + "-" + (mm+1) + "-" + gg);
				prodotto.setQuantita("incrementa",0);
				prodotto.setPrezzo(Double.parseDouble((String)sessione.getAttribute("prezzo")));
				carrello.setProdotti(prodotto);
				carrello.setTotale(Double.parseDouble((String)sessione.getAttribute("prezzo")),"incrementa");
				sessione.setAttribute("carrello",carrello);
				
				response.setHeader("verificato","true");
			}
			else
			{
				//store
				String nome_prodotto_store = request.getHeader("nome_prodotto_store");
				Double prezzo = Double.parseDouble(request.getHeader("prezzo"));
				Integer quantita = Integer.parseInt(request.getHeader("quantita"));
				ProdottoCarrello prodotto = new ProdottoCarrello();
				
				prodotto.setNome(nome_prodotto_store);
				GregorianCalendar oggi = new GregorianCalendar();
				int gg = oggi.get(Calendar.DAY_OF_MONTH);
				int mm = oggi.get(Calendar.MONTH);
				int aa = oggi.get(Calendar.YEAR);
				prodotto.setData("" + aa + "-" + (mm+1) + "-" + gg);
				prodotto.setQuantita("incrementa",0);
				prodotto.setPrezzo(prezzo);
				carrello.setProdotti(prodotto);
				carrello.setTotale(prezzo,"incrementa");
				sessione.setAttribute("carrello",carrello);
				
				response.setHeader("verificato","true");
			}
		}
		else
		{
			if(tipo.equals("stella"))
			{
				//Se il carrello esiste
				carrello = (Carrello)sessione.getAttribute("carrello");
				ArrayList<ProdottoCarrello> prodotti = (ArrayList<ProdottoCarrello>) carrello.getProdotti();
				String nome_stella_nuova = request.getHeader("nome_stella_nuova");
				String nome_stella =(String) sessione.getAttribute("nome_stella");
				ProdottoCarrello prodotto = new ProdottoCarrello();
				if(sessione.getAttribute("stelle_inserite")==null)
				{
					ArrayList<String> stelle_inserite = new ArrayList<String>();
					if(nome_stella.equals(nome_stella))
					{
						//non cambia il nome
						prodotto.setNome(nome_stella);
					}
					else
					{
						//cambia il nome
						prodotto.setNome(nome_stella_nuova);
					}
					stelle_inserite.add(nome_stella);
					stelle_inserite.add(nome_stella_nuova);
					sessione.setAttribute("stelle_inserite", stelle_inserite);
					
					GregorianCalendar oggi = new GregorianCalendar();
					int gg = oggi.get(Calendar.DAY_OF_MONTH);
					int mm = oggi.get(Calendar.MONTH);
					int aa = oggi.get(Calendar.YEAR);
					
					prodotto.setData("" + aa + "-" + (mm+1) + "-" + gg);
					prodotto.setQuantita("incrementa",0);
					prodotto.setPrezzo(Double.parseDouble((String)sessione.getAttribute("prezzo")));
					carrello.setProdotti(prodotto);
					carrello.setTotale(Double.parseDouble((String)sessione.getAttribute("prezzo")),"incrementa");
					sessione.setAttribute("carrello",carrello);
					
					response.setHeader("verificato","true");
				}
				else
				{
					boolean trovata_stella = false;
					ArrayList<String> stelle_inserite = (ArrayList<String>)sessione.getAttribute("stelle_inserite");
					for(String s: stelle_inserite)
					{
						if(s.equals(nome_stella))
						{
							trovata_stella=true;
						}
					}
					
					if(trovata_stella == true)
					{
						response.setHeader("verificato","false");
					}
					else
					{
						if(nome_stella.equals(nome_stella_nuova))
							prodotto.setNome(nome_stella);
						else
							prodotto.setNome(nome_stella_nuova);
						
						stelle_inserite.add(nome_stella);
						stelle_inserite.add(nome_stella_nuova);
						sessione.setAttribute("stelle_inserite", stelle_inserite);
						GregorianCalendar oggi = new GregorianCalendar();
						int gg = oggi.get(Calendar.DAY_OF_MONTH);
						int mm = oggi.get(Calendar.MONTH);
						int aa = oggi.get(Calendar.YEAR);
						
						prodotto.setData("" + aa + "-" + (mm+1) + "-" + gg);
						prodotto.setQuantita("incrementa",0);
						prodotto.setPrezzo(Double.parseDouble((String)sessione.getAttribute("prezzo")));
						carrello.setProdotti(prodotto);
						carrello.setTotale(Double.parseDouble((String)sessione.getAttribute("prezzo")),"incrementa");
						sessione.setAttribute("carrello",carrello);
						
						response.setHeader("verificato","true");
					}
				}
				
			}
			else
			{
				boolean errore = false;
				boolean trovato = false;
				
				carrello = (Carrello)sessione.getAttribute("carrello");
				String nome_prodotto_store = request.getHeader("nome_prodotto_store");
				Double prezzo = Double.parseDouble(request.getHeader("prezzo"));
				Integer quantita = Integer.parseInt(request.getHeader("quantita"));
				
				
				ArrayList<ProdottoCarrello> prodotti = carrello.getProdotti();	
				int indice=0;
				int i=0;
				for(ProdottoCarrello p:prodotti)
				{
					if(p.getNome().equals(nome_prodotto_store))
					{
						if(p.getQuantita()+1>quantita)
						{
							errore=true;
							trovato = true;
						}
						else
							trovato=true;
						indice=i;
					}
					i++;
				}
				
				if(trovato==false)
				{
					ProdottoCarrello prodotto = new ProdottoCarrello();
					prodotto.setNome(nome_prodotto_store);
					GregorianCalendar oggi = new GregorianCalendar();
					int gg = oggi.get(Calendar.DAY_OF_MONTH);
					int mm = oggi.get(Calendar.MONTH);
					int aa = oggi.get(Calendar.YEAR);
					prodotto.setData("" + aa + "-" + (mm+1) + "-" + gg);
					prodotto.setQuantita("incrementa",0);
					prodotto.setPrezzo(prezzo);
					carrello.setProdotti(prodotto);
					carrello.setTotale(prezzo,"incrementa");
					sessione.setAttribute("carrello",carrello);
					response.setHeader("verificato","true");
				}
				else if(trovato==true && errore==false)
				{
					carrello.getProdotti().get(indice).setQuantita("incrementa",0);
					carrello.setTotale(prezzo, "incrementa");
					sessione.setAttribute("carrello",carrello);
					response.setHeader("verificato","true");
				}
				else if(trovato==true && errore==true)
				{
					response.setHeader("verificato","false");
				}
			}
		}
		if(sessione.getAttribute("cliente")!=null)
			carrello.setUsername(((Cliente)sessione.getAttribute("cliente")).getNome());
	}


	public void calcoloHeaderIndirizzamento(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession sessione = request.getSession();
		if(sessione.getAttribute("pagina_da_reindirizzare")==null)
			sessione.setAttribute("pagina_da_reindirizzare", request.getHeader("pagina_da_reindirizzare"));
		
		String nome = (String)sessione.getAttribute("pagina_da_reindirizzare");
		
		if(nome.equals("StarBay"))
			response.setHeader("pagina_da_reindirizzare", "index.jsp");
		else if(nome.equals("Stelle"))
			response.setHeader("pagina_da_reindirizzare", "stelle.jsp");
		else if(nome.equals("Store"))
			response.setHeader("pagina_da_reindirizzare", "store.jsp");
		
		sessione.removeAttribute("pagina_da_reindirizzare");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		doGet(request, response);
	}

}
