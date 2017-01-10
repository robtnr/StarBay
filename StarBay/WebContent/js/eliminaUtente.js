var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() 
{
	if (this.readyState == 4 && this.status == 200) 
	{
		var tbody = xhttp.getResponseHeader("tbody");

		if (tbody == "nok")
		{
			swal({
				title: "Non ci sono utenti da eliminare",
				type: "info",
				showCancelButton: false,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			});
		}
		else
			document.getElementById("tbody").innerHTML = tbody;
	}
};
xhttp.open("GET", "ServletCaricaUtenti", true);
xhttp.send();


function eliminaUtente(x)
{
	var http = new XMLHttpRequest();
	http.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			swal({
				  title: "Utente eliminato con successo!",
				  type: "success",
				  showCancelButton: false,
				  confirmButtonText: "OK",
				  closeOnConfirm: false,
				},
				function(isConfirm){
				  if (isConfirm) {
					  open("elimina_utente.jsp","_self");
				  }
				});
		}
	};
	http.open("GET", "ServletEliminaUtente", true);
	http.setRequestHeader("utente", x);
	http.send();
}