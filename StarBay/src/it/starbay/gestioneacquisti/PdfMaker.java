package it.starbay.gestioneacquisti;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import it.starbay.gestionebean.Cliente;
import it.starbay.gestionebean.Ordine;

public class PdfMaker 
{
	private Font bigFont = new Font(Font.FontFamily.UNDEFINED, 16, Font.NORMAL);
	private Font bigFontBold = new Font(Font.FontFamily.UNDEFINED, 16, Font.BOLD);
	private Font redFont = new Font(Font.FontFamily.UNDEFINED, 12, Font.NORMAL, BaseColor.RED);
	private Font subFont = new Font(Font.FontFamily.UNDEFINED, 9, Font.NORMAL);
	private Font subFontBold = new Font(Font.FontFamily.UNDEFINED, 9, Font.BOLD);
	private Font smallBold = new Font(Font.FontFamily.UNDEFINED, 8, Font.BOLD);

	private Document document;
	private String idOrdine;
	private int idDettaglioOrdine;
	private String data;
	private String ora;
	private String coordinate;
	private String nome;
	private String descrizione;
	private String prezzo;
	private String nome_cognome;
	private String path;

	public PdfMaker(String path, Cliente c, Ordine o) 
	{
		try 
		{
			this.path = path;
			this.nome_cognome = c.getNome()+" "+c.getCognome();
			this.idOrdine = ""+o.getIdOrdine();
			this.idDettaglioOrdine = o.getIdDettaglioOrdine();
			this.data = o.getData();
			this.ora = o.getOra();
			this.coordinate = o.getIdProdotto();
			this.nome = o.getNomeProdotto();
			this.descrizione = o.getDescrizione();
			this.prezzo = ""+o.getPrezzo();
			document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(this.path + "pdf/Starbay_Contratto_Stella"+idOrdine+".pdf"));
			document.open();

			PdfPTable thead = creaTabellaIntestazione();
			PdfPTable tbodyD = creaTabellaDettagli();
			PdfPTable tbodyO = creaTabellaOrdine();
			PdfPTable tbodyT = creaTabellaTermini();

			document.add(thead);
			document.add(new Paragraph("ACQUIRENTE: " + nome_cognome + "\n\n", subFont));
			document.add(new Paragraph("Consegna concordata\n", subFontBold));
			document.add(tbodyD);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			document.add(tbodyO);
			document.add(tbodyT);

			document.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private PdfPTable creaTabellaIntestazione() throws MalformedURLException, IOException, DocumentException 
	{
		PdfPTable tabella = new PdfPTable(2);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

		Image img = null;
		img = Image.getInstance(this.path + "pdf/img/logo.png");

		PdfPCell cell = new PdfPCell(new Paragraph("CONTRATTO PER LA VENDITA ONLINE DI STELLE", bigFontBold));
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorder(0);

		tabella.addCell(cell);
		tabella.addCell(img);

		return tabella;
	}

	private PdfPTable creaTabellaDettagli() 
	{		
		PdfPTable tabella = new PdfPTable(6);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

		PdfPCell c1 = new PdfPCell(new Paragraph("N. Ordine", subFont));
		PdfPCell c2 = new PdfPCell(new Paragraph("Data AA-MM-GG", subFont));
		PdfPCell c3 = new PdfPCell(new Paragraph("Ora", subFont));
		PdfPCell c4 = new PdfPCell(new Paragraph(""));
		PdfPCell c5 = new PdfPCell(new Paragraph(""));
		PdfPCell c6 = new PdfPCell(new Paragraph(""));
		c1.setBorder(0);
		c2.setBorder(0);
		c3.setBorder(0);
		c4.setBorder(0);
		c5.setBorder(0);
		c6.setBorder(0);
		c1.setBorderWidthBottom(1);
		c2.setBorderWidthBottom(1);
		c3.setBorderWidthBottom(1);
		c4.setBorderWidthBottom(1);
		c5.setBorderWidthBottom(1);
		c6.setBorderWidthBottom(1);

		tabella.addCell(c1);
		tabella.addCell(c2);
		tabella.addCell(c3);
		tabella.addCell(c4);
		tabella.addCell(c5);
		tabella.addCell(c6);

		tabella.addCell(new Paragraph(idOrdine, subFont));
		tabella.addCell(new Paragraph(data, subFont));
		tabella.addCell(new Paragraph(ora, subFont));
		tabella.addCell("");
		tabella.addCell("");
		tabella.addCell("");

		return tabella;
	}

	private PdfPTable creaTabellaOrdine() 
	{		
		PdfPTable tabella = new PdfPTable(4);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

		PdfPCell c1 = new PdfPCell(new Paragraph("Coordinate", subFontBold));
		PdfPCell c2 = new PdfPCell(new Paragraph("Nome", subFontBold));
		PdfPCell c3 = new PdfPCell(new Paragraph("Descrizione", subFontBold));
		PdfPCell c4 = new PdfPCell(new Paragraph("Importo", subFontBold));
		c1.setBorder(0);
		c2.setBorder(0);
		c3.setBorder(0);
		c4.setBorder(0);
		c1.setBorderWidthBottom(1);
		c2.setBorderWidthBottom(1);
		c3.setBorderWidthBottom(1);
		c4.setBorderWidthBottom(1);

		tabella.addCell(c1);
		tabella.addCell(c2);
		tabella.addCell(c3);
		tabella.addCell(c4);

		tabella.addCell(new Paragraph(coordinate, subFont));
		tabella.addCell(new Paragraph(nome, subFont));
		tabella.addCell(new Paragraph(descrizione, subFont));
		tabella.addCell(new Paragraph(prezzo, subFont));
		tabella.addCell(" ");
		tabella.addCell(" ");
		tabella.addCell(" ");

		return tabella;	
	}

	private PdfPTable creaTabellaTermini()
	{
		PdfPTable tabella = new PdfPTable(1);
		tabella.setWidthPercentage(100);
		tabella.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

		tabella.addCell(new Paragraph(" "));
		tabella.addCell(new Paragraph("1. Oggetto del contratto", subFontBold));
		tabella.addCell(new Paragraph("Con il presente contratto, rispettivamente, il Fornitore vende e l’Acquirente acquista a distanza tramite strumenti telematici i prodotti stella indicati e offerti in vendita sul sito www.starbay.it. I prodotti stella sono illustrati nella pagina web www.starbay.it/stelle", subFont));
		tabella.addCell(new Paragraph(" "));
		tabella.addCell(new Paragraph("2. Modalità di stipulazione del contratto", subFontBold));
		tabella.addCell(new Paragraph("Il contratto tra il Fornitore e l’Acquirente si conclude esclusivamente attraverso la rete internet mediante l’accesso dell’Acquirente all’indirizzo www.starbay.it, ove, seguendo le procedure indicate, l’Acquirente arriverà a formalizzare la proposta per l’acquisto dei prodotti stella.", subFont));
		tabella.addCell(new Paragraph(" "));
		tabella.addCell(new Paragraph("3. Conclusione ed efficacia del contratto", subFontBold));
		tabella.addCell(new Paragraph("Il contratto di acquisto si conclude mediante l’esatta compilazione del modulo di richiesta e il consenso all’acquisto manifestato tramite l’adesione inviata online ovvero con la compilazione del form/modulo allegato al catalogo elettronico online all’indirizzo www.starbay.it e il successivo invio del form/modulo stesso, nella quale sono riportati gli estremi dell’ordinante e dell’ordinazione, il prezzo del bene acquistato, le modalità di pagamento, l’indirizzo ove il bene verrà consegnato. Nel momento in cui il Fornitore riceve dall’Acquirente l’ordinazione provvede alla visualizzazione di una pagina web di conferma e riepilogo dell’ordine, stampabile, nella quale siano riportati precedentemente.", subFont));
		tabella.addCell(new Paragraph(" "));
		tabella.addCell(new Paragraph("4. Modalità di pagamento", subFontBold));
		tabella.addCell(new Paragraph("Ogni pagamento da parte dell’Acquirente potrà avvenire unicamente per mezzo di uno dei metodi indicati nell’apposita pagina web dal Fornitore.", subFont));
		tabella.addCell(new Paragraph(" "));
		tabella.addCell(new Paragraph("5. Obblighi dell’Acquirente", subFontBold));
		tabella.addCell(new Paragraph(" L’Acquirente si impegna, una volta conclusa la procedura d’acquisto online, a provvedere alla stampa e alla conservazione del presente contratto. Le informazioni contenute in questo contratto sono state, peraltro, già visionate e accettate dall’Acquirente, che ne dà atto, in quanto questo passaggio viene reso obbligatorio prima della conferma di acquisto.", subFont));

		return tabella;
	}
	
	public String getPath()
	{
		return path + "pdf/Starbay_Contratto_Stella"+this.idDettaglioOrdine+".pdf";
	}
}
