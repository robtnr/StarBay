
function controlloDati()
{
	if(controlloCoordinate(document.getElementById("inputCoordinate")))
		if(controlloDescrizione(document.getElementById("inputDescrizione")))
			if(controlloSrc(document.getElementById("inputSrc")))
				if(controlloPrezzo(document.getElementById("inputPrezzo")))
					if(controlloNome(document.getElementById("inputNome")))
						alert("Inserimento avvenuto con succeso!");
}

	function controlloCoordinate(x)
	{
		if(x.value == "")
		{
			document.getElementById("divCoordinate").removeAttribute("class");
			document.getElementById("labelCoordinate").removeAttribute("class");
			document.getElementById("spanCoordinate").style.display="none";
			document.getElementById("iconCoordinate").removeAttribute("class");
			document.getElementById("iconCoordinate").style.display="none";
		}
		else if(x.value.length > 20)
		{
			document.getElementById("divCoordinate").setAttribute("class", "form-group has-error has-feedback");
			document.getElementById("labelCoordinate").setAttribute("class", "control-label");
			document.getElementById("spanCoordinate").innerHTML = "Le coordinate deve contenere massimo 20 caratteri";
			document.getElementById("spanCoordinate").style.display="block";
			document.getElementById("iconCoordinate").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
			document.getElementById("iconCoordinate").style.display="block";
		}
		else
		{
			document.getElementById("divCoordinate").setAttribute("class", "form-group has-success has-feedback");
			document.getElementById("labelCoordinate").setAttribute("class", "control-label");
			document.getElementById("spanCoordinate").innerHTML = "";
			document.getElementById("spanCoordinate").style.display="block";
			document.getElementById("iconCoordinate").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
			document.getElementById("iconCoordinate").style.display="block";
			return true;
		}
		return false;
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

	function controlloPrezzo(x)
	{
		if(x.value == "")
		{
			document.getElementById("divPrezzo").removeAttribute("class");
			document.getElementById("labelPrezzo").removeAttribute("class");
			document.getElementById("spanPrezzo").style.display="none";
			document.getElementById("iconPrezzo").removeAttribute("class");
			document.getElementById("iconPrezzo").style.display="none";
		}
		else if(x.value <= 0)
		{
			document.getElementById("divPrezzo").setAttribute("class", "form-group has-error has-feedback");
			document.getElementById("labelPrezzo").setAttribute("class", "control-label");
			document.getElementById("spanPrezzo").innerHTML = "Il prezzo deve essere maggiore di 0";
			document.getElementById("spanPrezzo").style.display="block";
			document.getElementById("iconPrezzo").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
			document.getElementById("iconPrezzo").style.display="block";
		}
		else if (/[^0-9.]/.test(x.value))
		{
			document.getElementById("divPrezzo").setAttribute("class", "form-group has-error has-feedback");
			document.getElementById("labelPrezzo").setAttribute("class", "control-label");
			document.getElementById("spanPrezzo").innerHTML = "Il prezzo deve contenere solo numeri, eventualmente separati dal punto (es 150.99)";
			document.getElementById("spanPrezzo").style.display="block";
			document.getElementById("iconPrezzo").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
			document.getElementById("iconPrezzo").style.display="block";
		}
		else
		{
			document.getElementById("divPrezzo").setAttribute("class", "form-group has-success has-feedback");
			document.getElementById("labelPrezzo").setAttribute("class", "control-label");
			document.getElementById("spanPrezzo").innerHTML = "";
			document.getElementById("spanPrezzo").style.display="block";
			document.getElementById("iconPrezzo").setAttribute("class", "glyphicon glyphicon-ok form-control-feedback");
			document.getElementById("iconPrezzo").style.display="block";
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
		else if(x.value.length > 20)
		{
			document.getElementById("divNome").setAttribute("class", "form-group has-error has-feedback");
			document.getElementById("labelNome").setAttribute("class", "control-label");
			document.getElementById("spanNome").innerHTML = "Il nome deve contenere massimo 20 caratteri";
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
