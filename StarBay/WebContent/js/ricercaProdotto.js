function ricercaProdotto()
{
	var chiave = document.getElementById("ricerca_prodotto").value;
	var http = new XMLHttpRequest();
	http.onreadystatechange = function()
	{
		
		open("risultati_cerca.jsp?chiave="+chiave,"_self");
	}
	http.open("POST", "http://localhost:8080/StarBay/ServletRicercaProdotto", true);
	http.setRequestHeader("chiave",chiave);
	http.send();
	
}