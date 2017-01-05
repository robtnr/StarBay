function eliminaProdottoStore(x)
{
		var http = new XMLHttpRequest();
		var tr = x.parentNode.parentNode;
		var td = tr.getElementsByTagName("TD");
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				setTimeout(function(){
					open("elimina_prodotto_store.jsp","_self");
				}, 3000);
				
				swal("Successo","Prodotto store eliminato con successo", "success");
			}
		}
		http.open("POST", "http://localhost:8080/StarBay/ServletEliminaProdotto", true);
		http.setRequestHeader("nome",td[0].childNodes[0].nodeValue);
		http.setRequestHeader("tipo","store");
		http.send();
}