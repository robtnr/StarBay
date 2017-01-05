package it.starbay.gestioneprodotti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;
import sun.util.calendar.Gregorian;

/**
 * Servlet implementation class ServletModificaProdottoSingolo
 */
@WebServlet("/ServletModificaProdottoSingolo")
public class ServletModificaProdottoSingolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getHeader("tipo").equals("store"))
		{
			String nome = request.getHeader("nome");
			String descrizione = request.getHeader("descrizione");
			String prezzo_vendita = request.getHeader("prezzo_vendita");
			String prezzo_acquisto = request.getHeader("prezzo_acquisto");
			String quantita = request.getHeader("quantita");
			
			HttpSession sessione = request.getSession();
			Store prodotto_nuovo = new Store();
			prodotto_nuovo.setNome(nome);
			prodotto_nuovo.setDescrizione(descrizione);
			prodotto_nuovo.setPrezzoVendita(Double.parseDouble(prezzo_vendita));
			prodotto_nuovo.setPrezzoAcquisto(Double.parseDouble(prezzo_acquisto));
			prodotto_nuovo.setQuantita(Integer.parseInt(quantita));
			
			Store prodotto_vecchio = (Store)sessione.getAttribute("prodotto_store_daModificare");
			prodotto_nuovo.setData(prodotto_vecchio.getData());
			if(prodotto_nuovo.getQuantita()==prodotto_vecchio.getQuantita())
			{
				try 
				{
					ManagerProdotti manager = new ManagerProdotti();
					manager.modificaProdottoStore(prodotto_vecchio, prodotto_nuovo);
					sessione.removeAttribute("prodotto_store_daModificare");
					sessione.removeAttribute("carica_prodotti_store");
				} catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				GregorianCalendar oggi = new GregorianCalendar();
				int gg = oggi.get(Calendar.DAY_OF_MONTH);
				int mm = oggi.get(Calendar.MONTH);
				int aa = oggi.get(Calendar.YEAR);
				
				prodotto_nuovo.setData("" + aa + "-" + (mm+1) + "-" + gg);
				
				try 
				{
					ManagerProdotti manager = new ManagerProdotti();
					manager.modificaProdottoStore(prodotto_vecchio, prodotto_nuovo);
					sessione.removeAttribute("prodotto_store_daModificare");
					sessione.removeAttribute("carica_prodotti_store");
				} catch (ClassNotFoundException | SQLException e) 
				{
					e.printStackTrace();
				}
				
				
			}
			
			
			sessione.setAttribute("prodotto_store_daModificare", prodotto_nuovo);
			response.setHeader("tipo_daModificare","store");
		
		}
		else
		{
			String nome = request.getHeader("nome");
			String descrizione = request.getHeader("descrizione");
			String prezzo = request.getHeader("prezzo");
			String coordinate = request.getHeader("coordinate");
			
			HttpSession sessione = request.getSession();
			Stella stella_nuova = new Stella();
			stella_nuova.setNome(nome);
			stella_nuova.setDescrizione(descrizione);
			stella_nuova.setPrezzo(Double.parseDouble(prezzo));
			stella_nuova.setCoordinate(coordinate);
			
			Stella stella_vecchia = (Stella)sessione.getAttribute("stella_daModificare");
			stella_nuova.setData(stella_vecchia.getData());
			try
			{
				ManagerProdotti manager = new ManagerProdotti();
				manager.modificaProdottoStella(stella_vecchia, stella_nuova);
				sessione.removeAttribute("stella_daModificare");
				sessione.removeAttribute("carica_prodotti_stella");
			} catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
