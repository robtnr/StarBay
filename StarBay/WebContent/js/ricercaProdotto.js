/**
 * Ricerca Prodotto
 * si occupa di ricercare un prodotto
 * 
 * Metodo ricercaProdotto
 * questo metodo chiama la servlet passandole la chiave di ricerca
 * 
 */

function ricercaProdotto()
{
	var chiave = document.getElementById("ricerca_prodotto").value;
	var http = new XMLHttpRequest();
	http.onreadystatechange = function()
	{
		
		open("risultati_cerca.jsp?chiave="+chiave,"_self");
	}
	http.open("POST", "ServletRicercaProdotto", true);
	http.setRequestHeader("chiave",chiave);
	http.send();
	
}