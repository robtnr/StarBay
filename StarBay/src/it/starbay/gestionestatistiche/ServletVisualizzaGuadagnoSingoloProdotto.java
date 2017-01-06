package it.starbay.gestionestatistiche;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.starbay.gestionebean.Stella;
import it.starbay.gestionebean.Store;


@WebServlet("/ServletVisualizzaGuadagnoSingoloProdotto")
public class ServletVisualizzaGuadagnoSingoloProdotto extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ManagerStatistiche ms = new ManagerStatistiche();
		ArrayList<String> righe = ms.dammiGuadagnoSingoloProdotto();

		if (righe == null) response.addHeader("tableGuadagni", "nok");
		else
		{
			String tbody = "";

			for(String tr: righe)
				tbody += tr;

			response.addHeader("tbody", tbody);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
