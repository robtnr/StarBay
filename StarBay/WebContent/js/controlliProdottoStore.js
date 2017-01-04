/**
* Controlli prodotti stella
*
* Metodo controlloDati
* richiama tutte le funzioni di controllo dati e se sono tutte vere il gestore visualizza messaggio di avvenuto inserimento
* e viene reindirizzato alla sua pagina personale
*
* Metodo controlloNome
* controlla campo nome
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloPrezzoAcquisto
* controlla campo prezzoAcquisto
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloPrezzoVendita
* controlla campo prezzoVendita
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloDescrizione
* controlla campo descrizione
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloQuantita
* controlla campo quantita
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloSrc
* controlla campo src
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
*/

function controlloDati()
{
	var c1 = controlloNome(document.getElementById("inputNome"));
	var c2 = controlloPrezzoAcquisto(document.getElementById("inputPrezzoAcquisto"));
	var c3 = controlloPrezzoVendita(document.getElementById("inputPrezzoVendita"));
	var c4 = controlloDescrizione(document.getElementById("inputDescrizione"));
	var c5 = controlloQuantita(document.getElementById("inputQuantita"));
	var c6 = controlloSrc(document.getElementById("inputSrc"));
	
	if ((c1 && c2 && c3 && c4 && c5 && c6))
		document.getElementById("formStore").submit();
}

function controlloDescrizione(x)
{
	if(x.value == "")
	{
		document.getElementById("divDescrizione").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelDescrizione").setAttribute("class", "control-label");
		document.getElementById("spanDescrizione").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanDescrizione").style.display="block";
		document.getElementById("iconDescrizione").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconDescrizione").style.display="block";
	}
	else if(x.value.length > 300)
	{
		document.getElementById("divDescrizione").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelDescrizione").setAttribute("class", "control-label");
		document.getElementById("spanDescrizione").innerHTML = "La descrizione deve contenere massimo 300 caratteri";
		document.getElementById("spanDescrizione").style.display="block";
		document.getElementById("iconDescrizione").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconDescrizione").style.display="block";
	}
	else
	{
		document.getElementById("divDescrizione").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelDescrizione").setAttribute("class", "control-label");
		document.getElementById("spanDescrizione").innerHTML = "";
		document.getElementById("spanDescrizione").style.display="block";
		document.getElementById("iconDescrizione").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconDescrizione").style.display="block";
		return true;
	}
	return false;
}

function controlloSrc(x)
{
	if(x.value == "")
	{
		document.getElementById("divSrc").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelSrc").setAttribute("class", "control-label");
		document.getElementById("spanSrc").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanSrc").style.display="block";
		document.getElementById("iconSrc").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconSrc").style.display="block";
	}
	else if(x.value.length > 60)
	{
		document.getElementById("divSrc").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelSrc").setAttribute("class", "control-label");
		document.getElementById("spanSrc").innerHTML = "La path deve contenere massimo 60 caratteri";
		document.getElementById("spanSrc").style.display="block";
		document.getElementById("iconSrc").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconSrc").style.display="block";
	}
	else
	{
		document.getElementById("divSrc").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelSrc").setAttribute("class", "control-label");
		document.getElementById("spanSrc").innerHTML = "";
		document.getElementById("spanSrc").style.display="block";
		document.getElementById("iconSrc").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconSrc").style.display="block";
		return true;
	}
	return false;
}

function controlloPrezzoAcquisto(x)
{
	if(x.value == "")
	{
		document.getElementById("divPrezzoAcquisto").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelPrezzoAcquisto").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoAcquisto").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanPrezzoAcquisto").style.display="block";
		document.getElementById("iconPrezzoAcquisto").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconPrezzoAcquisto").style.display="block";
	}
	else if(x.value <= 0)
	{
		document.getElementById("divPrezzoAcquisto").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelPrezzoAcquisto").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoAcquisto").innerHTML = "Il prezzo deve essere maggiore di 0";
		document.getElementById("spanPrezzoAcquisto").style.display="block";
		document.getElementById("iconPrezzoAcquisto").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconPrezzoAcquisto").style.display="block";
	}
	else if (/[^0-9.]/.test(x.value))
	{
		document.getElementById("divPrezzoAcquisto").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelPrezzoAcquisto").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoAcquisto").innerHTML = "Il prezzo deve contenere solo numeri, eventualmente separati dal punto (es 150.99)";
		document.getElementById("spanPrezzoAcquisto").style.display="block";
		document.getElementById("iconPrezzoAcquisto").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconPrezzoAcquisto").style.display="block";
	}
	else
	{
		document.getElementById("divPrezzoAcquisto").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelPrezzoAcquisto").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoAcquisto").innerHTML = "";
		document.getElementById("spanPrezzoAcquisto").style.display="block";
		document.getElementById("iconPrezzoAcquisto").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconPrezzoAcquisto").style.display="block";
		return true;
	}
	return false;
}

function controlloPrezzoVendita(x)
{
	if(x.value == "")
	{
		document.getElementById("divPrezzoVendita").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelPrezzoVendita").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoVendita").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanPrezzoVendita").style.display="block";
		document.getElementById("iconPrezzoVendita").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconPrezzoVendita").style.display="block";
	}
	else if(x.value <= 0)
	{
		document.getElementById("divPrezzoVendita").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelPrezzoVendita").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoVendita").innerHTML = "Il prezzo deve essere maggiore di 0";
		document.getElementById("spanPrezzoVendita").style.display="block";
		document.getElementById("iconPrezzoVendita").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconPrezzoVendita").style.display="block";
	}
	else if (/[^0-9.]/.test(x.value))
	{
		document.getElementById("divPrezzoVendita").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelPrezzoVendita").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoVendita").innerHTML = "Il prezzo deve contenere solo numeri, eventualmente separati dal punto (es 150.99)";
		document.getElementById("spanPrezzoVendita").style.display="block";
		document.getElementById("iconPrezzoVendita").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconPrezzoVendita").style.display="block";
	}
	else
	{
		document.getElementById("divPrezzoVendita").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelPrezzoVendita").setAttribute("class", "control-label");
		document.getElementById("spanPrezzoVendita").innerHTML = "";
		document.getElementById("spanPrezzoVendita").style.display="block";
		document.getElementById("iconPrezzoVendita").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconPrezzoVendita").style.display="block";
		return true;
	}
	return false;
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
	else if(x.value.length > 50)
	{
		document.getElementById("divNome").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelNome").setAttribute("class", "control-label");
		document.getElementById("spanNome").innerHTML = "Il nome deve contenere massimo 50 caratteri";
		document.getElementById("spanNome").style.display="block";
		document.getElementById("iconNome").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconNome").style.display="block";
	}
	else if (/[^a-zA-Z0-9]/.test(x.value))
	{
		document.getElementById("divNome").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelNome").setAttribute("class", "control-label");
		document.getElementById("spanNome").innerHTML = "Il nome deve contenere solo lettere e numeri";
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

function controlloQuantita(x)
{
	if(x.value == "")
	{
		document.getElementById("divQuantita").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelQuantita").setAttribute("class", "control-label");
		document.getElementById("spanQuantita").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanQuantita").style.display="block";
		document.getElementById("iconQuantita").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconQuantita").style.display="block";
	}
	else if(x.value <= 0)
	{
		document.getElementById("divQuantita").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelQuantita").setAttribute("class", "control-label");
		document.getElementById("spanQuantita").innerHTML = "La quantita' deve essere maggiore di 0";
		document.getElementById("spanQuantita").style.display="block";
		document.getElementById("iconQuantita").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconQuantita").style.display="block";
	}
	else if (/[^0-9]/.test(x.value))
	{
		document.getElementById("divQuantita").setAttribute("class", "form-group has-error has-feedback");
		document.getElementById("labelQuantita").setAttribute("class", "control-label");
		document.getElementById("spanQuantita").innerHTML = "La quantita' deve contenere solo numeri";
		document.getElementById("spanQuantita").style.display="block";
		document.getElementById("iconQuantita").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
		document.getElementById("iconQuantita").style.display="block";
	}
	else
	{
		document.getElementById("divQuantita").setAttribute("class", "form-group has-success has-feedback");
		document.getElementById("labelQuantita").setAttribute("class", "control-label");
		document.getElementById("spanQuantita").innerHTML = "";
		document.getElementById("spanQuantita").style.display="block";
		document.getElementById("iconQuantita").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
		document.getElementById("iconQuantita").style.display="block";
		return true;
	}
	return false;
}