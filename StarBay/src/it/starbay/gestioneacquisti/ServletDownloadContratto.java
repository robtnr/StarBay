package it.starbay.gestioneacquisti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletDownloadContratto")
public class ServletDownloadContratto extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nome_cognome = request.getHeader("nome_cognome");
		String idOrdine = request.getHeader("idOrdine");
		String nome = request.getHeader("nome");
		String prezzo = request.getHeader("prezzo");
		String data = request.getHeader("data");
		String ora = request.getHeader("ora");
		String coordinate = request.getHeader("coordinate");
		String descrizione = request.getHeader("descrizione");
		
		//CreaPDF
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
