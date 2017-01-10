function eliminaProdottoStore(x)
{
		var http = new XMLHttpRequest();
		var tr = x.parentNode.parentNode;
		var td = tr.getElementsByTagName("TD");
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				
				swal({
					  title: "Prodotto store eliminato con successo!",
					  type: "success",
					  showCancelButton: false,
					  confirmButtonText: "OK",
					  closeOnConfirm: false,
					},
					function(isConfirm){
					  if (isConfirm) {
						  open("elimina_prodotto_store.jsp","_self");
					  }
					});
				
			}
		}
		http.open("POST", "http://localhost:8080/StarBay/ServletEliminaProdotto", true);
		http.setRequestHeader("nome",td[0].childNodes[0].nodeValue);
		http.setRequestHeader("tipo","store");
		http.send();
}