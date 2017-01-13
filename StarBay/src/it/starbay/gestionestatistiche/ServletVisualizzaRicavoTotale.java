package it.starbay.gestionestatistiche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletVisualizzaRicavoTotale
 * Classe control che si occupa della visualizzazione del ricavo totale
 */
@WebServlet("/ServletVisualizzaRicavoTotale")
public class ServletVisualizzaRicavoTotale extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ManagerStatistiche ms = new ManagerStatistiche();
		String ricavoTotale = ms.dammiRicavoTotale();
		response.addHeader("ricavoTotale", ricavoTotale);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
