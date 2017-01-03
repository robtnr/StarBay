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
import it.starbay.gestionebean.Stella;

@WebServlet("/ServletInserimentoProdottoStella")
public class ServletInserimentoProdottoStella extends HttpServlet {

	private String nome;
	private double prezzo;
	private String coordinate;
	private String descrizione;
	private String src;
	private Stella s;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		nome = request.getHeader("nome");
		prezzo = Double.parseDouble(request.getHeader("prezzo"));
		coordinate = request.getHeader("coordinate");
		descrizione = request.getHeader("descrizione");
		src = request.getHeader("src");
		
		creaOggettoStella();
		
		try 
		{
			ManagerProdotti mp = new ManagerProdotti();
			mp.registraProdottoStella(s);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

	private void creaOggettoStella() 
	{
		s = new Stella();
		s.setNome(nome);
		s.setPrezzo(prezzo);
		s.setCoordinate(coordinate);
		s.setDescrizione(descrizione);
		s.setSrc(src);
		GregorianCalendar oggi = new GregorianCalendar();
		int gg = oggi.get(Calendar.DAY_OF_MONTH);
		int mm = oggi.get(Calendar.MONTH);
		int aa = oggi.get(Calendar.YEAR);
		
		s.setData("" + aa + "-" + (mm+1) + "-" + gg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
