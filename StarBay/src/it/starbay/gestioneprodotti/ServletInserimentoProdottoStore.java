package it.starbay.gestioneprodotti;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import it.starbay.gestionebean.Store;

@WebServlet("/ServletInserimentoProdottoStore")
public class ServletInserimentoProdottoStore extends HttpServlet {

	// location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "img";
    
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private ArrayList<String> parametri;
	
	private String nome;
	private double prezzoAcquisto;
	private double prezzoVendita;
	private String descrizione;
	private int quantita;
	private String src;
	private Store s;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		prendiParametri(request, response);				
		creaOggettoStore();
		
		try 
		{
			ManagerProdotti mp = new ManagerProdotti();
			mp.registraProdottoStore(s);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		RequestDispatcher disp = request.getRequestDispatcher("/gestore.jsp");  
		disp.forward(request, response);  
	}

	private void prendiParametri(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
		if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
		parametri = new ArrayList<String>();
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("/")
                + "/" + UPLOAD_DIRECTORY;
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems)
                {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + "/" + fileName;
                        File storeFile = new File(filePath);
                        parametri.add("img/"+fileName);
                        // saves the file on disk
                        item.write(storeFile);
                        System.out.println(filePath);
                    }
                    else
                    {
                    	parametri.add(item.getString());
                    }
                }
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}

	private void creaOggettoStore() 
	{
		nome = parametri.get(0);
		prezzoAcquisto = Double.parseDouble(parametri.get(1));
		prezzoVendita = Double.parseDouble(parametri.get(2));
		quantita = Integer.parseInt(parametri.get(3));
		descrizione = parametri.get(4);
		src = parametri.get(5);
		
		s = new Store();
		s.setNome(nome);
		s.setPrezzoAcquisto(prezzoAcquisto);
		s.setPrezzoVendita(prezzoVendita);
		s.setDescrizione(descrizione);
		s.setQuantita(quantita);
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
