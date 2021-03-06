/**
* Controlli prodotti stella
*
* Metodo controlloDatiSingolaStella
* richiama tutte le funzioni di controllo dati e se sono tutte vere il gestore visualizza messaggio di avvenuto inserimento
* e viene reindirizzato alla sua pagina personale
*
* Metodo controlloNome
* controlla campo nome
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloPrezzo
* controlla campo prezzo
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
* 
* Metodo controlloCoordinate
* controlla campo coordinate
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
* Metodo controlloSrc
* controlla campo src
* @param x oggetto input
* @return true se l'input è valido
* @return false se l'input non è valido
*/

function controlloDatiSingolaStella()
{
	var c1 = controlloNome(document.getElementById("inputNome"));
	var c2 = controlloPrezzo(document.getElementById("inputPrezzo"));
	var c3 = controlloCoordinate(document.getElementById("inputCoordinate"));
	var c4 = controlloDescrizione(document.getElementById("inputDescrizione"));
	if((c1 && c2 && c3 && c4))
	{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				
				swal({
					  title: "Stella modificata con successo!",
					  type: "success",
					  showCancelButton: false,
					  confirmButtonText: "OK",
					  closeOnConfirm: false,
					},
					function(isConfirm){
					  if (isConfirm) {
						  open("modifica_prodotto_stella.jsp","_self");
					  }
					});
			}
		}
		http.open("POST", "http://localhost:8080/StarBay/ServletModificaProdottoSingolo", true);
		http.setRequestHeader("nome",document.getElementById("inputNome").value);
		http.setRequestHeader("descrizione",document.getElementById("inputDescrizione").value);
		http.setRequestHeader("prezzo",document.getElementById("inputPrezzo").value);
		http.setRequestHeader("coordinate",document.getElementById("inputCoordinate").value);
		http.setRequestHeader("tipo","stella");
		http.send();
	}
}

function controlloCoordinate(x)
{
	if(x.value == "")
	{
		document.getElementById("divCoordinate").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelCoordinate").setAttribute("class", "control-label");
		document.getElementById("spanCoordinate").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanCoordinate").style.display="block";
		document.getElementById("iconCoordinate").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconCoordinate").style.display="block";
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

function controlloPrezzo(x)
{
	if(x.value == "")
	{
		document.getElementById("divPrezzo").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelPrezzo").setAttribute("class", "control-label");
		document.getElementById("spanPrezzo").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanPrezzo").style.display="block";
		document.getElementById("iconPrezzo").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconPrezzo").style.display="block";
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
		document.getElementById("divNome").setAttribute("class", "form-group has-warning has-feedback");
		document.getElementById("labelNome").setAttribute("class", "control-label");
		document.getElementById("spanNome").innerHTML = "* Campo obbligatorio";
		document.getElementById("spanNome").style.display="block";
		document.getElementById("iconNome").setAttribute("class", "glyphicon glyphicon-warning-sign form-control-feedback");
		document.getElementById("iconNome").style.display="block";
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
	else if (/[^a-zA-Z0-9 ]/.test(x.value))
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
