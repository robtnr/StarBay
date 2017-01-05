function eliminaProdottoStella(x)
{
		alert("ciao");
		var http = new XMLHttpRequest();
		var tr = x.parentNode.parentNode;
		var td = tr.getElementsByTagName("TD");
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				setTimeout(function(){
					open("elimina_prodotto_stella.jsp","_self");
				}, 3000);
				
				swal("Successo","Stella eliminata con successo", "success");
			}
		}
		http.open("POST", "http://localhost:8080/StarBay/ServletEliminaProdotto", true);
		http.setRequestHeader("coordinate",td[2].childNodes[0].nodeValue);
		http.setRequestHeader("tipo","stella");
		http.send();
}