var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() 
{
	if (this.readyState == 4 && this.status == 200) 
	{
		alert("caricati");
	}
};
xhttp.open("GET", "ServletCaricaOrdiniUtente", true);
xhttp.setRequestHeader("username", document.getElementById("username").innerHTML);
xhttp.send();