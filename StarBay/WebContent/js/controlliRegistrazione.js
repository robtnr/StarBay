/**
 * Controlli Registrazione
 *
 * Metodo controlloDati
 * richiama tutte le funzioni di controllo dati e se sono tutte vere l'utente viene reindirizzato alla sua pagina personale
 *
 * Metodo controlloNome
 * controlla campo nome
 * @param x oggetto input
 * @return true se l'input è valido
 * @return false se l'input non è valido
 * 
 * Metodo controlloCognome
 * controlla campo cognome
 * @param x oggetto input
 * @return true se l'input è valido
 * @return false se l'input non è valido
 *
 * Metodo controlloComune
 * controlla campo comune
 * @param x oggetto input
 * @return true se l'input è valido
 * @return false se l'input non è valido
 * 
 * Metodo controlloIndirizzo
 * controlla campo indirizzo
 * @param x oggetto input
 * @return true se l'input è valido
 * @return false se l'input non è valido
 * 
 * Metodo controlloEmail
 * controlla campo email
 * @param x oggetto input
 * @return true se l'input è valido
 * @return false se l'input non è valido
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
 * 
 * Metodo controlloIBAN
 * controlla campo IBAN
 * @param x oggetto input
 * @return true se l'input è valido
 * @return false se l'input non è valido
 */

function controlloDati()
{
	var c1 = controlloNome(document.getElementById("inputNome"));
	var c2 = controlloCognome(document.getElementById("inputCognome"));
	var c3 = controlloComune(document.getElementById("inputComune"));
	var c4 = controlloIndirizzo(document.getElementById("inputIndirizzo"));
	var c5 = controlloEmail(document.getElementById("inputEmail"));
	var c6 = controlloUsername(document.getElementById("inputUsername"));
	var c7 = controlloPassword(document.getElementById("inputPassword"));
	var c8 = controlloIBAN(document.getElementById("inputIBAN"));
	if ((c1 && c2 && c3 && c4 && c5 && c6 && c7 && c8))
	{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				var errore = http.getResponseHeader("errore");
				if(errore=="true")
				{
					document.getElementById("divUsername").setAttribute("class", "form-group has-error has-feedback");
					document.getElementById("labelUsername").setAttribute("class", "control-label");
					document.getElementById("spanUsername").innerHTML = "L'username scelto e' gia' esistente";
					document.getElementById("spanUsername").style.display="block";
					document.getElementById("iconUsername").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
					document.getElementById("iconUsername").style.display="block";
				}
				else
					open("index.jsp?mex=ok","_self");

			}
		}
		http.open("POST", "ServletRegistrazione", true);
		http.setRequestHeader("nome", document.getElementById("inputNome").value);
		http.setRequestHeader("cognome", document.getElementById("inputCognome").value);
		http.setRequestHeader("comune", document.getElementById("inputComune").value);
		http.setRequestHeader("indirizzo", document.getElementById("inputIndirizzo").value);
		http.setRequestHeader("email", document.getElementById("inputEmail").value);
		http.setRequestHeader("username", document.getElementById("inputUsername").value);
		http.setRequestHeader("password", document.getElementById("inputPassword").value);
		http.setRequestHeader("iban", document.getElementById("inputIBAN").value);
		http.send();
	}
}

function controlloNome(x)
{
	if(x.value == "")
	{
		document.getElementById("divNome").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelNome").setAttribute("class", "control-label");
		document.getElementById("spanNome").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanNome").style.display="block";
		document.getElementById("iconNome").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconNome").style.display="block";
	}
	else if(x.value.length > 30)
	{
		document.getElementById("divNome").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelNome").setAttribute("class", "control-label");
		document.getElementById("spanNome").innerHTML = "Il nome deve contenere massimo 30 caratteri";
		document.getElementById("spanNome").style.display="block";
		document.getElementById("iconNome").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconNome").style.display="block";
	}
	else if (/[^a-zA-Z ]/.test(x.value))
	{
		document.getElementById("divNome").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelNome").setAttribute("class", "control-label");
		document.getElementById("spanNome").innerHTML = "Il nome deve contenere solo lettere";
		document.getElementById("spanNome").style.display="block";
		document.getElementById("iconNome").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconNome").style.display="block";
	}
	else
	{
		document.getElementById("divNome").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelNome").setAttribute("class", "control-label");
		document.getElementById("spanNome").innerHTML = "";
		document.getElementById("spanNome").style.display="block";
		document.getElementById("iconNome").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconNome").style.display="block";
		return true;
	}
	return false;
}

function controlloCognome(x)
{
	if(x.value == "")
	{
		document.getElementById("divCognome").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelCognome").setAttribute("class", "control-label");
		document.getElementById("spanCognome").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanCognome").style.display="block";
		document.getElementById("iconCognome").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconCognome").style.display="block";
	}
	else if(x.value.length > 30)
	{
		document.getElementById("divCognome").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelCognome").setAttribute("class", "control-label");
		document.getElementById("spanCognome").innerHTML = "Il cognome deve contenere massimo 30 caratteri";
		document.getElementById("spanCognome").style.display="block";
		document.getElementById("iconCognome").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconCognome").style.display="block";
	}
	else if (/[^a-zA-Z ']/.test(x.value))
	{
		document.getElementById("divCognome").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelCognome").setAttribute("class", "control-label");
		document.getElementById("spanCognome").innerHTML = "Il cognome deve contenere solo lettere";
		document.getElementById("spanCognome").style.display="block";
		document.getElementById("iconCognome").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconCognome").style.display="block";
	}
	else
	{
		document.getElementById("divCognome").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelCognome").setAttribute("class", "control-label");
		document.getElementById("spanCognome").innerHTML = "";
		document.getElementById("spanCognome").style.display="block";
		document.getElementById("iconCognome").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconCognome").style.display="block";
		return true;
	}
	return false;
}

function controlloComune(x)
{
	if(x.value == "")
	{
		document.getElementById("divComune").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelComune").setAttribute("class", "control-label");
		document.getElementById("spanComune").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanComune").style.display="block";
		document.getElementById("iconComune").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconComune").style.display="block";
	}
	else if(x.value.length > 30)
	{
		document.getElementById("divComune").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelComune").setAttribute("class", "control-label");
		document.getElementById("spanComune").innerHTML = "Il comune deve contenere massimo 30 caratteri";
		document.getElementById("spanComune").style.display="block";
		document.getElementById("iconComune").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconComune").style.display="block";
	}
	else if (/[^a-zA-Z ']/.test(x.value))
	{
		document.getElementById("divComune").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelComune").setAttribute("class", "control-label");
		document.getElementById("spanComune").innerHTML = "Il comune deve contenere solo lettere";
		document.getElementById("spanComune").style.display="block";
		document.getElementById("iconComune").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconComune").style.display="block";
	}
	else
	{
		document.getElementById("divComune").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelComune").setAttribute("class", "control-label");
		document.getElementById("spanComune").innerHTML = "";
		document.getElementById("spanComune").style.display="block";
		document.getElementById("iconComune").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconComune").style.display="block";
		return true;
	}
	return false;
}

function controlloIndirizzo(x)
{
	if(x.value == "")
	{
		document.getElementById("divIndirizzo").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelIndirizzo").setAttribute("class", "control-label");
		document.getElementById("spanIndirizzo").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanIndirizzo").style.display="block";
		document.getElementById("iconIndirizzo").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconIndirizzo").style.display="block";
	}
	else if(x.value.length > 40)
	{
		document.getElementById("divIndirizzo").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelIndirizzo").setAttribute("class", "control-label");
		document.getElementById("spanIndirizzo").innerHTML = "L'indirizzo deve contenere massimo 40 caratteri";
		document.getElementById("spanIndirizzo").style.display="block";
		document.getElementById("iconIndirizzo").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconIndirizzo").style.display="block";
	}
	else if (/[^a-zA-Z0-9 ']/.test(x.value))
	{
		document.getElementById("divIndirizzo").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelIndirizzo").setAttribute("class", "control-label");
		document.getElementById("spanIndirizzo").innerHTML = "L'indirizzo deve contenere solo lettere e numeri";
		document.getElementById("spanIndirizzo").style.display="block";
		document.getElementById("iconIndirizzo").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconIndirizzo").style.display="block";
	}
	else
	{
		document.getElementById("divIndirizzo").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelIndirizzo").setAttribute("class", "control-label");
		document.getElementById("spanIndirizzo").innerHTML = "";
		document.getElementById("spanIndirizzo").style.display="block";
		document.getElementById("iconIndirizzo").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconIndirizzo").style.display="block";
		return true;
	}
	return false;
}

function controlloEmail(x)
{
	if(x.value == "")
	{
		document.getElementById("divEmail").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelEmail").setAttribute("class", "control-label");
		document.getElementById("spanEmail").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanEmail").style.display="block";
		document.getElementById("iconEmail").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconEmail").style.display="block";
	}
	else if(x.value.length > 40)
	{
		document.getElementById("divEmail").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelEmail").setAttribute("class", "control-label");
		document.getElementById("spanEmail").innerHTML = "L'email deve contenere massimo 40 caratteri";
		document.getElementById("spanEmail").style.display="block";
		document.getElementById("iconEmail").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconEmail").style.display="block";
	}
	else if (/^[\w\.\-]+@\w+[\w\.\-]*?\.\w{1,4}$/.test(x.value) == false)
	{
		document.getElementById("divEmail").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelEmail").setAttribute("class", "control-label");
		document.getElementById("spanEmail").innerHTML = "L'email deve rispettare il seguente formato: nome@dominio.it";
		document.getElementById("spanEmail").style.display="block";
		document.getElementById("iconEmail").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconEmail").style.display="block";
	}
	else
	{
		document.getElementById("divEmail").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelEmail").setAttribute("class", "control-label");
		document.getElementById("spanEmail").innerHTML = "";
		document.getElementById("spanEmail").style.display="block";
		document.getElementById("iconEmail").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconEmail").style.display="block";
		return true;
	}
	return false;
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
	else if(x.value.length > 30 || x.value.length < 8)
	{
		document.getElementById("divUsername").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelUsername").setAttribute("class", "control-label");
		document.getElementById("spanUsername").innerHTML = "L'username deve contenere minimo 8 e massimo 30 caratteri";
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
	else if(x.value.length > 30 || x.value.length < 8)
	{
		document.getElementById("divPassword").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelPassword").setAttribute("class", "control-label");
		document.getElementById("spanPassword").innerHTML = "La password deve contenere minimo 8 e massimo 30 caratteri";
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

function controlloIBAN(x)
{
	if(x.value == "")
	{
		document.getElementById("divIBAN").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelIBAN").setAttribute("class", "control-label");
		document.getElementById("spanIBAN").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanIBAN").style.display="block";
		document.getElementById("iconIBAN").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconIBAN").style.display="block";
	}
	else if(x.value.length != 27)
	{
		document.getElementById("divIBAN").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelIBAN").setAttribute("class", "control-label");
		document.getElementById("spanIBAN").innerHTML = "L'IBAN deve contenere 27 caratteri";
		document.getElementById("spanIBAN").style.display="block";
		document.getElementById("iconIBAN").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconIBAN").style.display="block";
	}
	else if (/[A-Z]{2}[0-9]{2}[A-Z0-9]{4}[0-9]{7}([A-Z0-9]?){0,16}/.test(x.value) == false)
	{
		document.getElementById("divIBAN").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelIBAN").setAttribute("class", "control-label");
		document.getElementById("spanIBAN").innerHTML = "L'IBAN non rispetta il formato";
		document.getElementById("spanIBAN").style.display="block";
		document.getElementById("iconIBAN").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconIBAN").style.display="block";
	}
	else
	{
		document.getElementById("divIBAN").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelIBAN").setAttribute("class", "control-label");
		document.getElementById("spanIBAN").innerHTML = "";
		document.getElementById("spanIBAN").style.display="block";
		document.getElementById("iconIBAN").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconIBAN").style.display="block";
		return true;
	}
	return false;
}