/**
* Controlli Login
*
* Metodo controlloDati
* richiama tutte le funzioni di controllo dati e se sono tutte vere l'utente viene reindirizzato alla sua pagina personale
*
* Metodo controlloUsername
* controlla campo username
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloPassword
* controlla campo password
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
*/

function controlloDati()
{
	var c1 = controlloUsername(document.getElementById("inputUsername"));
	var c2 = controlloPassword(document.getElementById("inputPassword"));
	if((c1 && c2))
	{
		alert("OK - implementare reindirizzamento alla pagina personale");
		var http = new XMLHttpRequest();
		http.open("POST", "/ServletLoginUtente", true);
		http.send();
	}
}

function controlloUsername(x)
{
	if(x.value == "")
	{
		document.getElementById("divUsername").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelUsername").setAttribute("class", "control-label");
		document.getElementById("spanUsername").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanUsername").style.display="block";
		document.getElementById("iconUsername").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconUsername").style.display="block";
	}
	else if(x.value.length > 30 && x.value.length < 8)
	{
		document.getElementById("divUsername").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelUsername").setAttribute("class", "control-label");
		document.getElementById("spanUsername").innerHTML = "L'username deve contenere minimo 8 e massimo 40 caratteri";
		document.getElementById("spanUsername").style.display="block";
		document.getElementById("iconUsername").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconUsername").style.display="block";
	}
	else if (/[^a-zA-Z0-9]/.test(x.value))
	{
		document.getElementById("divUsername").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelUsername").setAttribute("class", "control-label");
		document.getElementById("spanUsername").innerHTML = "L'username deve contenere solo lettere e numeri";
		document.getElementById("spanUsername").style.display="block";
		document.getElementById("iconUsername").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconUsername").style.display="block";
	}
	else
	{
		document.getElementById("divUsername").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelUsername").setAttribute("class", "control-label");
		document.getElementById("spanUsername").innerHTML = "";
		document.getElementById("spanUsername").style.display="block";
		document.getElementById("iconUsername").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconUsername").style.display="block";
		return true;
	}
	return false;
}

function controlloPassword(x)
{
	if(x.value == "")
	{
		document.getElementById("divPassword").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelPassword").setAttribute("class", "control-label");
		document.getElementById("spanPassword").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanPassword").style.display="block";
		document.getElementById("iconPassword").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconPassword").style.display="block";
	}
	else if(x.value.length > 30 && x.value.length < 8)
	{
		document.getElementById("divPassword").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelPassword").setAttribute("class", "control-label");
		document.getElementById("spanPassword").innerHTML = "La password deve contenere minimo 8 e massimo 40 caratteri";
		document.getElementById("spanPassword").style.display="block";
		document.getElementById("iconPassword").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconPassword").style.display="block";
	}
	else if (/[^a-zA-Z0-9]/.test(x.value))
	{
		document.getElementById("divPassword").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelPassword").setAttribute("class", "control-label");
		document.getElementById("spanPassword").innerHTML = "La password deve contenere solo lettere e numeri";
		document.getElementById("spanPassword").style.display="block";
		document.getElementById("iconPassword").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconPassword").style.display="block";
	}
	else
	{
		document.getElementById("divPassword").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelPassword").setAttribute("class", "control-label");
		document.getElementById("spanPassword").innerHTML = "";
		document.getElementById("spanPassword").style.display="block";
		document.getElementById("iconPassword").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconPassword").style.display="block";
		return true;
	}
	return false;
}