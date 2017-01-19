/**
* Modifica prodotto store
*
* Metodo modificaProdottoStore
* questo metodo chiama la servlet per modificare i parametri di un prodotto store
* @param x oggetto node che rappresenta un table
*/

function modificaProdottoStore(x)
{
		var http = new XMLHttpRequest();
		var tr = x.parentNode.parentNode;
		var td = tr.getElementsByTagName("TD");
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				open("modifica_prodotto_singolo_store.jsp","_self");
			}
		}
		http.open("POST", "http://localhost:8080/StarBay/ServletModificaProdotto", true);
		http.setRequestHeader("nome",td[0].childNodes[0].nodeValue);
		http.setRequestHeader("descrizione",td[1].childNodes[0].nodeValue);
		http.setRequestHeader("prezzo_vendita",td[2].childNodes[0].nodeValue);
		http.setRequestHeader("prezzo_acquisto",td[3].childNodes[0].nodeValue);
		http.setRequestHeader("quantita",td[4].childNodes[0].nodeValue);
		http.setRequestHeader("data",td[5].childNodes[0].nodeValue);
		http.setRequestHeader("tipo","store");
		http.send();
}