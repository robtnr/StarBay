/**
 * Gestore
 * si occupa di gestire le statistiche
 * 
 * Metodo visualizzaGuadagno
 * questo metodo chiama la servlet che calcola il guadagno totale e poi esso mostra un alert con il valore
 * 
 * Metodo visualizzaRicavo
 * questo metodo chiama la servlet che calcola il ricavo totale e poi esso mostra un alert con il valore
 * 
 */

function visualizzaGuadagno()
{

	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() 
	  {
	    if (this.readyState == 4 && this.status == 200) 
	    {
	    	var guadagnoTotale = xhttp.getResponseHeader("guadagnoTotale");
	    	
	    	swal("Guadagno totale", "Hai guadagnato "+guadagnoTotale+" \u20AC", "info");
	    }
	  };
	  xhttp.open("GET", "ServletVisualizzaGuadagnoTotale", true);
	  xhttp.send();
}

function visualizzaRicavo()
{
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() 
	  {
	    if (this.readyState == 4 && this.status == 200) 
	    {
	    	var ricavoTotale = xhttp.getResponseHeader("ricavoTotale");
	    	
	    	swal("Ricavo totale", "Hai ricavato "+ricavoTotale+" \u20AC", "info");
	    }
	  };
	  xhttp.open("GET", "ServletVisualizzaRicavoTotale", true);
	  xhttp.send();
}