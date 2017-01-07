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