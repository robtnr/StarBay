/**
* Modifica prodotto singolo
*
* Metodo modificaProdottoStella
* viene chiamata la servlet ServletModificaProdotto e si viene reindirizzati alla pagina modifica_prodotto_singolo_stella.jsp
* @param x oggetto node
*/

function modificaProdottoStella(x)
{
		var http = new XMLHttpRequest();
		var tr = x.parentNode.parentNode;
		var td = tr.getElementsByTagName("TD");
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				open("modifica_prodotto_singolo_stella.jsp","_self");	
			}
		}
		http.open("POST", "http://localhost:8080/StarBay/ServletModificaProdotto", true);
		http.setRequestHeader("nome",td[0].childNodes[0].nodeValue);
		http.setRequestHeader("descrizione",td[1].childNodes[0].nodeValue);
		http.setRequestHeader("coordinate",td[2].childNodes[0].nodeValue);
		http.setRequestHeader("prezzo",td[3].childNodes[0].nodeValue);
		http.setRequestHeader("data",td[4].childNodes[0].nodeValue);
		http.setRequestHeader("tipo","stella");
		http.send();
}