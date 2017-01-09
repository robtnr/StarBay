package it.starbay.gestioneacquisti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Carrello;
import it.starbay.gestionebean.ProdottoCarrello;

/**
 * Servlet implementation class ServletRimozioneProdottoCarrello
 */
@WebServlet("/ServletRimozioneProdottoCarrello")
public class ServletRimozioneProdottoCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nome_prodotto = request.getHeader("nome_prodotto");
		String quantita = request.getHeader("quantita");
		String prezzo = request.getHeader("prezzo");
		
		HttpSession sessione = request.getSession();
		
		if(sessione.getAttribute("carrello")!=null)
		{
			if(sessione.getAttribute("stelle_inserite")!=null)
			{
				ArrayList<String> stelle_inserite = (ArrayList<String>)sessione.getAttribute("stelle_inserite");
		
				
				int indice=0;
				boolean stella_trovata = false;
				for(String s:stelle_inserite)
				{
					if(s.equals(nome_prodotto))
						stella_trovata = true;
				}
				
				if(stella_trovata==true)
				{
					for(int i=0;i<stelle_inserite.size();i++)
					{
						if(stelle_inserite.get(i).equals(nome_prodotto) || stelle_inserite.get(i+1).equals(nome_prodotto))
						{
							indice=i;
							break;
						}
					}
	
					if(indice!=0)
					{
					stelle_inserite.remove(indice);
					stelle_inserite.remove(indice);
					sessione.setAttribute("stelle_inserite",stelle_inserite);
					}
				}
			}
			int i=0;
			boolean elimina=false;
			int indice_eliminato=0;
			Carrello carrello = (Carrello)sessione.getAttribute("carrello");
			ArrayList<ProdottoCarrello> prodotti = carrello.getProdotti();
			for(ProdottoCarrello p: prodotti)
			{
				if(p.getNome().equals(nome_prodotto))
				{
					if(p.getQuantita()>1)
						carrello.getProdotti().get(i).setQuantita("decrementa",0);
					else
					{
						carrello.getProdotti().get(i).setQuantita("decrementa",0);
						indice_eliminato = i;
						elimina=true;
					}
				}
				i++;
			}
			
			if(elimina == true)
			{
				carrello.getProdotti().remove(indice_eliminato);
			}
			carrello.setTotale(Double.parseDouble(prezzo),"decrementa");
			sessione.setAttribute("carrello", carrello);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
