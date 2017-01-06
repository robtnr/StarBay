var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() 
{
	if (this.readyState == 4 && this.status == 200) 
	{
		var tbody = xhttp.getResponseHeader("tbody");

		if (tbody == "nok")
		{
			swal({
				title: "Non hai guadagnato nulla",
				type: "error",
				showCancelButton: false,
				closeOnConfirm: false,
				showLoaderOnConfirm: true,
			},
			function(){
				open("gestore.jsp", "_self");
			});
		}
		else
			document.getElementById("tbody").innerHTML = tbody;
	}
};
xhttp.open("GET", "ServletVisualizzaGuadagnoSingoloProdotto", true);
xhttp.send();