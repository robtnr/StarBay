var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() 
{
	if (this.readyState == 4 && this.status == 200) 
	{
		var tbody = xhttp.getResponseHeader("tbody");

		if (tbody == "nok")
		{
			swal({
				title: "Non hai effettuato nessun ordine",
				type: "info",
				showCancelButton: false,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			});
		}
		else
		{
			document.getElementById("tbody").innerHTML = tbody;
			var totale = xhttp.getResponseHeader("totale");
			document.getElementById("totale").innerHTML = "Totale: "+totale+" &euro;"
		}
	}
};
xhttp.open("GET", "ServletCaricaOrdiniUtente", true);
xhttp.setRequestHeader("username", document.getElementById("username").innerHTML);
xhttp.send();