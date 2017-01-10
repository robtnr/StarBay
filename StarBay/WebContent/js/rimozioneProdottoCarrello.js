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
			
			swal({
				  title: "Prodotto eliminato dal carrello!",
				  type: "success",
				  showCancelButton: false,
				  confirmButtonText: "OK",
				  closeOnConfirm: false,
				},
				function(isConfirm){
				  if (isConfirm) {
					  open("carrello.jsp","_self");
				  }
				});
			
		}
	}
	http.open("POST", "http://localhost:8080/StarBay/ServletRimozioneProdottoCarrello", true);
	http.setRequestHeader("nome_prodotto",nome_prodotto);
	http.setRequestHeader("quantita",quantita);
	http.setRequestHeader("prezzo",prezzo);
	http.send();
	
}