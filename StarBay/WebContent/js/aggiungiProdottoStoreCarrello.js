function aggiungiProdottoStoreCarrello(x)
{
	var div_principale = x.parentNode.parentNode;
	var tutti_div = div_principale.getElementsByTagName("DIV");
	var nome_prodotto_store = tutti_div[2].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	var prezzo = tutti_div[3].getElementsByTagName("DIV")[0].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	var quantita = tutti_div[5].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	var http = new XMLHttpRequest();
	http.onreadystatechange = function()
	{
		if(http.readyState==4 && http.status==200)
		{
			var verificato = http.getResponseHeader("verificato");
			if(verificato=="true")
			{
				setTimeout(function(){
					open("index.jsp","_self");
				}, 1000);
				
				swal("Successo","Prodotto store inserito con successo", "success");
			}
			else
			{
				setTimeout(function(){
					open("index.jsp","_self");
				}, 1000);
				
				swal("Errore","Prodotto store esaurito", "success");
			}
		}
	}
	http.open("POST", "http://localhost:8080/StarBay/ServletInserimentoCarrello", true);
	http.setRequestHeader("nome_prodotto_store",nome_prodotto_store);
	http.setRequestHeader("prezzo",prezzo);
	http.setRequestHeader("quantita",quantita);
	http.setRequestHeader("tipo","store");
	http.send();
	
}