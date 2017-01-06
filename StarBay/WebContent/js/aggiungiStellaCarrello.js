function aggiungiStellaCarrello()
{
	var nome_stella_nuova = document.getElementById("inputNome").value;
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
				}, 2000);
				
				swal("Successo","Prodotto stella inserito con successo", "success");
			}
			else
			{
				setTimeout(function(){
					open("index.jsp","_self");
				}, 2000);
				
				swal("Errore","Stella già presente!", "success");
			}
		}
	}
	http.open("POST", "http://localhost:8080/StarBay/ServletInserimentoCarrello", true);
	http.setRequestHeader("nome_stella_nuova",nome_stella_nuova);
	http.setRequestHeader("tipo","stella");
	http.send();
	
	
}