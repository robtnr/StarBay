package it.starbay.gestionestatistiche;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletVisualizzaGuadagnoTotale")
public class ServletVisualizzaGuadagnoTotale extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ManagerStatistiche ms = new ManagerStatistiche();
		String guadagnoTotale = ms.dammiGuadagnoTotale();
		response.addHeader("guadagnoTotale", guadagnoTotale);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
