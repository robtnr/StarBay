
function controlloDati()
{
	if(controlloPrezzoVendita(document.getElementById("inputPrezzoVendita")))
		if(controlloQuantita(document.getElementById("inputQuantita")))
			if(controlloDescrizione(document.getElementById("inputDescrizione")))
				if(controlloSrc(document.getElementById("inputSrc")))
					if(controlloPrezzoAcquisto(document.getElementById("inputPrezzoAcquisto")))
						if(controlloNome(document.getElementById("inputNome")))
							alert("Inserimento avvenuto con successo!");
}

		function controlloDescrizione(x)
	{
		if(x.value == "")
		{
			document.getElementById("divDescrizione").removeAttribute("class");
			document.getElementById("labelDescrizione").removeAttribute("class");
			document.getElementById("spanDescrizione").style.display="none";
			document.getElementById("iconDescrizione").removeAttribute("class");
			document.getElementById("iconDescrizione").style.display="none";
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
			document.getElementById("spanDescrizione").innerHTML = "OK";
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
			document.getElementById("divSrc").removeAttribute("class");
			document.getElementById("labelSrc").removeAttribute("class");
			document.getElementById("spanSrc").style.display="none";
			document.getElementById("iconSrc").removeAttribute("class");
			document.getElementById("iconSrc").style.display="none";
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
			document.getElementById("divPrezzoAcquisto").removeAttribute("class");
			document.getElementById("labelPrezzoAcquisto").removeAttribute("class");
			document.getElementById("spanPrezzoAcquisto").style.display="none";
			document.getElementById("iconPrezzoAcquisto").removeAttribute("class");
			document.getElementById("iconPrezzoAcquisto").style.display="none";
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
			document.getElementById("divPrezzoVendita").removeAttribute("class");
			document.getElementById("labelPrezzoVendita").removeAttribute("class");
			document.getElementById("spanPrezzoVendita").style.display="none";
			document.getElementById("iconPrezzoVendita").removeAttribute("class");
			document.getElementById("iconPrezzoVendita").style.display="none";
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
			document.getElementById("divNome").removeAttribute("class");
			document.getElementById("labelNome").removeAttribute("class");
			document.getElementById("spanNome").style.display="none";
			document.getElementById("iconNome").removeAttribute("class");
			document.getElementById("iconNome").style.display="none";
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
			document.getElementById("divQuantita").removeAttribute("class");
			document.getElementById("labelQuantita").removeAttribute("class");
			document.getElementById("spanQuantita").style.display="none";
			document.getElementById("iconQuantita").removeAttribute("class");
			document.getElementById("iconQuantita").style.display="none";
		}
		else if(x.value <= 0)
		{
			document.getElementById("divQuantita").setAttribute("class", "form-group has-error has-feedback");
			document.getElementById("labelQuantita").setAttribute("class", "control-label");
			document.getElementById("spanQuantita").innerHTML = "La quantità deve essere maggiore di 0";
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