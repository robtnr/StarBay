package it.starbay.gestioneprodotti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;

/**
 * ServletModificaProdotto
 * Classe control che si occupa della modifica di un prodotto store
 */
@WebServlet("/ServletModificaProdotto")
public class ServletModificaProdotto extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getHeader("tipo").equals("store"))
		{
			String nome = request.getHeader("nome");
			String descrizione = request.getHeader("descrizione");
			String src = request.getHeader("src");
			String prezzo_vendita = request.getHeader("prezzo_vendita");
			String prezzo_acquisto = request.getHeader("prezzo_acquisto");
			String quantita = request.getHeader("quantita");
			String data = request.getHeader("data");
			
			HttpSession sessione = request.getSession();
			Store prodotto_store = new Store();
			prodotto_store.setNome(nome);
			prodotto_store.setDescrizione(descrizione);
			prodotto_store.setSrc(src);
			prodotto_store.setPrezzoVendita(Double.parseDouble(prezzo_vendita));
			prodotto_store.setPrezzoAcquisto(Double.parseDouble(prezzo_acquisto));
			prodotto_store.setQuantita(Integer.parseInt(quantita));
			prodotto_store.setData(data);
			
			sessione.setAttribute("prodotto_store_daModificare", prodotto_store);
		
		}
		else
		{
			String nome = request.getHeader("nome");
			String descrizione = request.getHeader("descrizione");
			String coordinate = request.getHeader("coordinate");
			String prezzo= request.getHeader("prezzo");
			String data = request.getHeader("data");
			
			HttpSession sessione = request.getSession();
			Stella stella = new Stella();
			stella.setNome(nome);
			stella.setDescrizione(descrizione);
			stella.setCoordinate(coordinate);;
			stella.setPrezzo(Double.parseDouble(prezzo));
			stella.setData(data);
			
			sessione.setAttribute("stella_daModificare", stella);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
