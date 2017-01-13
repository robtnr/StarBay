package it.starbay.gestionestatistiche;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starbay.gestionebean.Ordine;
import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;

/**
 * ServletVisualizzaGuadagnoSingoloProdotto
 * Classe control che si occupa della visualizzazione del guadagno per singolo prodotto
 */
@WebServlet("/ServletVisualizzaGuadagnoSingoloProdotto")
public class ServletVisualizzaGuadagnoSingoloProdotto extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ManagerStatistiche ms = new ManagerStatistiche();
		ArrayList<Ordine> ordini = ms.dammiGuadagnoSingoloProdotto();

		if (ordini == null) response.addHeader("tbody", "nok");
		else
		{
			String tbody = "";

			for(Ordine o: ordini)
				tbody += "<tr><td>"+o.getIdProdotto()+"</td><td>"+o.getNomeProdotto()+"</td><td>"+o.getPrezzo()+"</td><td>"+o.getData()+"</td></tr>";

			response.addHeader("tbody", tbody);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
