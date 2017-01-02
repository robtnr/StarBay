
function controlloDati()
{
	if(controlloNome(document.getElementById("inputNome")))
		if(controlloCognome(document.getElementById("inputCognome")))
			if(controlloComune(document.getElementById("inputComune")))
				if(controlloIndirizzo(document.getElementById("inputIndirizzo")))
					if(controlloEmail(document.getElementById("inputEmail")))
						if(controlloUsername(document.getElementById("inputUsername")))
							if(controlloPassword(document.getElementById("inputPassword")))
								if(controlloIBAN(document.getElementById("inputIBAN")))
									alert("Registrazione avvenuta con successo!");
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
		else if(x.value.length > 30)
		{
			document.getElementById("divNome").setAttribute("class", "form-group has-error has-feedback");
			document.getElementById("labelNome").setAttribute("class", "control-label");
			document.getElementById("spanNome").innerHTML = "Il nome deve contenere massimo 30 caratteri";
			document.getElementById("spanNome").style.display="block";
			document.getElementById("iconNome").setAttribute("class", "glyphicon glyphicon-remove form-control-feedback");
			document.getElementById("iconNome").style.display="block";
		}
		else if (/[^a-zA-Z]/.test(x.value))
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
			document.getElementById("divCognome").removeAttribute("class");
			document.getElementById("labelCognome").removeAttribute("class");
			document.getElementById("spanCognome").style.display="none";
			document.getElementById("iconCognome").removeAttribute("class");
			document.getElementById("iconCognome").style.display="none";
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
		else if (/[^a-zA-Z]/.test(x.value))
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
			document.getElementById("divComune").removeAttribute("class");
			document.getElementById("labelComune").removeAttribute("class");
			document.getElementById("spanComune").style.display="none";
			document.getElementById("iconComune").removeAttribute("class");
			document.getElementById("iconComune").style.display="none";
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
		else if (/[^a-zA-Z]/.test(x.value))
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
			document.getElementById("divIndirizzo").removeAttribute("class");
			document.getElementById("labelIndirizzo").removeAttribute("class");
			document.getElementById("spanIndirizzo").style.display="none";
			document.getElementById("iconIndirizzo").removeAttribute("class");
			document.getElementById("iconIndirizzo").style.display="none";
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
		else if (/[^a-zA-Z0-9 ]/.test(x.value))
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
			document.getElementById("divEmail").removeAttribute("class");
			document.getElementById("labelEmail").removeAttribute("class");
			document.getElementById("spanEmail").style.display="none";
			document.getElementById("iconEmail").removeAttribute("class");
			document.getElementById("iconEmail").style.display="none";
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
			document.getElementById("divUsername").removeAttribute("class");
			document.getElementById("labelUsername").removeAttribute("class");
			document.getElementById("spanUsername").style.display="none";
			document.getElementById("iconUsername").removeAttribute("class");
			document.getElementById("iconUsername").style.display="none";
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
			document.getElementById("divPassword").removeAttribute("class");
			document.getElementById("labelPassword").removeAttribute("class");
			document.getElementById("spanPassword").style.display="none";
			document.getElementById("iconPassword").removeAttribute("class");
			document.getElementById("iconPassword").style.display="none";
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

	function controlloIBAN(x)
	{
		if(x.value == "")
		{
			document.getElementById("divIBAN").removeAttribute("class");
			document.getElementById("labelIBAN").removeAttribute("class");
			document.getElementById("spanIBAN").style.display="none";
			document.getElementById("iconIBAN").removeAttribute("class");
			document.getElementById("iconIBAN").style.display="none";
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