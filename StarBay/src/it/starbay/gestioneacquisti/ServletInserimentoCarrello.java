package it.starbay.gestioneacquisti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Carrello;
import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.ProdottoCarrello;

/**
 * Servlet implementation class ServletInserimentoCarrello
 */
@WebServlet("/ServletInserimentoCarrello")
public class ServletInserimentoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Carrello carrello;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession sessione = request.getSession();
		if(sessione.getAttribute("cliente")!=null)
			carrello.setUsername(((Cliente)sessione.getAttribute("cliente")).getNome());
		String tipo = request.getHeader("tipo");
		if(sessione.getAttribute("carrello")==null)
		{
			//Se il carrello è vuoto
			carrello = new Carrello();
			if(tipo.equals("stella"))
			{
				//Inserimento di una stella
				String nome_stella_nuova = request.getHeader("nome_stella_nuova");
				ProdottoCarrello prodotto = new ProdottoCarrello();
				//Controllo dei nomi delle stelle per vedere se è cambiato
				if(sessione.getAttribute("nome_stella").equals(nome_stella_nuova))
				{
					//Non cambia
					prodotto.setNome((String) sessione.getAttribute("nome_stella"));
					//Array di nomi delle stelle nuove
					if(sessione.getAttribute("stelle_nuove")==null)
					{
						//se non cambia il nome il valore è "no"
						ArrayList<String> stelle_nuove = new ArrayList<String>();
						stelle_nuove.add("no");
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
					else
					{
						ArrayList<String> stelle_nuove = (ArrayList<String>)sessione.getAttribute("stelle_nuove");
						stelle_nuove.add("no");
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
				}
				else
				{
					//nome stella cambia
					prodotto.setNome((String) sessione.getAttribute("nome_stella_nuova"));
					if(sessione.getAttribute("stelle_nuove")==null)
					{
						//ArrayList di stelle nuove
						ArrayList<String> stelle_nuove = new ArrayList<String>();
						stelle_nuove.add((String) sessione.getAttribute("nome_stella_nuova"));
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
					else
					{
						ArrayList<String> stelle_nuove = (ArrayList<String>)sessione.getAttribute("stelle_nuove");
						stelle_nuove.add((String) sessione.getAttribute("nome_stella_nuova"));
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
				}
				GregorianCalendar oggi = new GregorianCalendar();
				int gg = oggi.get(Calendar.DAY_OF_MONTH);
				int mm = oggi.get(Calendar.MONTH);
				int aa = oggi.get(Calendar.YEAR);
				
				prodotto.setData("" + aa + "-" + (mm+1) + "-" + gg);
				prodotto.setQuantita("incrementa");
				prodotto.setPrezzo(Double.parseDouble((String)sessione.getAttribute("prezzo")));
				carrello.setProdotti(prodotto);
				sessione.setAttribute("carrello",carrello);
				
				response.setHeader("verificato","true");
			}
			else
			{
				
			}
		}
		else
		{
			if(tipo.equals("stella"))
			{
				//Se il carrello esiste
				Carrello carrello = (Carrello)sessione.getAttribute("carrello");
				ArrayList<ProdottoCarrello> prodotti = (ArrayList<ProdottoCarrello>) carrello.getProdotti();
				String nome_stella_nuova = request.getHeader("nome_stella_nuova");
				ProdottoCarrello prodotto = new ProdottoCarrello();
				ArrayList<String> stelle_attuali = (ArrayList<String>) sessione.getAttribute("stelle_attuali");
				int n_stelle_attuali = stelle_attuali.size();
				if(nome_stella_nuova.equals(stelle_attuali.get(n_stelle_attuali-1)))
				{
					prodotto.setNome(nome_stella_nuova);
					if(sessione.getAttribute("stelle_nuove")==null)
					{
						//se non cambia il nome il valore è "no"
						ArrayList<String> stelle_nuove = new ArrayList<String>();
						stelle_nuove.add("no");
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
					else
					{
						ArrayList<String> stelle_nuove = (ArrayList<String>)sessione.getAttribute("stelle_nuove");
						stelle_nuove.add("no");
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
				}
				else
				{
					prodotto.setNome(nome_stella_nuova);
					if(sessione.getAttribute("stelle_nuove")==null)
					{
						//se cambia il nome della stella
						ArrayList<String> stelle_nuove = new ArrayList<String>();
						stelle_nuove.add(nome_stella_nuova);
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
					else
					{
						ArrayList<String> stelle_nuove = (ArrayList<String>)sessione.getAttribute("stelle_nuove");
						stelle_nuove.add(nome_stella_nuova);
						sessione.setAttribute("stelle_nuove", stelle_nuove);
					}
				}
				boolean trovata_stella = false;
				
				for(int i=0;i<stelle_attuali.size()-1;i++)
				{
					if(stelle_attuali.get(i).equals(prodotto.getNome()))
					{
						trovata_stella = true;
					}
				}
				
				ArrayList<String> stelle_nuove = (ArrayList<String>)sessione.getAttribute("stelle_nuove");
				for(int i=0;i<stelle_nuove.size()-1;i++)
				{
					if(stelle_nuove.get(i).equals(prodotto.getNome()))
					{
						trovata_stella = true;
					}
				}
				
				if(trovata_stella = true)
				{
					response.setHeader("verificato","false");
				}
				else
				{
					GregorianCalendar oggi = new GregorianCalendar();
					int gg = oggi.get(Calendar.DAY_OF_MONTH);
					int mm = oggi.get(Calendar.MONTH);
					int aa = oggi.get(Calendar.YEAR);
					
					prodotto.setData("" + aa + "-" + (mm+1) + "-" + gg);
					prodotto.setQuantita("incrementa");
					prodotto.setPrezzo(Double.parseDouble((String)sessione.getAttribute("prezzo")));
					carrello.setProdotti(prodotto);
					sessione.setAttribute("carrello",carrello);
					
					response.setHeader("verificato","true");
				}
			}
			else
			{
				
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		doGet(request, response);
	}

}
