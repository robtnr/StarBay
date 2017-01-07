function rimozioneProdottoCarrello(x)
{
	var tr = x.parentNode.parentNode;
	var nome_prodotto = tr.getElementsByTagName("TD")[0].childNodes[0].nodeValue;
	var quantita = tr.getElementsByTagName("TD")[1].childNodes[0].nodeValue;
	var prezzo = tr.getElementsByTagName("TD")[2].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	var http = new XMLHttpRequest();
	http.onreadystatechange = function()
	{
		if(http.readyState==4 && http.status==200)
		{
			setTimeout(function(){
				open("carrello.jsp","_self");
			}, 1200);
				
			swal("Successo","Prodotto eliminato dal carrello", "success");
		}
	}
	http.open("POST", "http://localhost:8080/StarBay/ServletRimozioneProdottoCarrello", true);
	http.setRequestHeader("nome_prodotto",nome_prodotto);
	http.setRequestHeader("quantita",quantita);
	http.setRequestHeader("prezzo",prezzo);
	http.send();
	
}