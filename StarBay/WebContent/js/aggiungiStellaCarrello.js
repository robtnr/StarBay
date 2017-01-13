/**
 * Aggiungi Stella al Carrello
 * si occupa di aggiungere un prodotto stella al carrello
 * 
 * Metodo aggiungiStellaCarrello
 * questo metodo chiama la servlet che inserisce il prodotto stella nel carrello e poi esso mostra un alert
 * 
 * Metodo controllaNome
 * questo metodo controlla se il nome inserito rispetta la lunghezza e il formato
 * @param x oggetto node che rappresenta un testo
 * @return true se il nome inserito è corretto
 * @return false se il nome inserito non è corretto
 * 
 */

function aggiungiStellaCarrello()
{
	var c1 = controlloNome(document.getElementById("inputNome"));
	if(c1)
	{
		var nome_stella_nuova = document.getElementById("inputNome").value;
		var http = new XMLHttpRequest();
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				var verificato = http.getResponseHeader("verificato");
				var pagina_da_reindirizzare = http.getResponseHeader("pagina_da_reindirizzare");
				if(verificato=="true")
				{
					swal({
						  title: "Prodotto stella inserito con successo!",
						  type: "success",
						  showCancelButton: false,
						  confirmButtonText: "OK",
						  closeOnConfirm: false,
						},
						function(isConfirm){
						  if (isConfirm) {
							  open(pagina_da_reindirizzare,"_self");
						  }
						});
				}
				else
				{
					swal({
						  title: "Stella gia' presente!",
						  type: "error",
						  showCancelButton: false,
						  confirmButtonText: "OK",
						  closeOnConfirm: false,
						},
						function(isConfirm){
						  if (isConfirm) {
							  open(pagina_da_reindirizzare,"_self");
						  }
						});
				}
			}
		}
	}
	http.open("POST", "http://localhost:8080/StarBay/ServletInserimentoProdottoCarrello", true);
	http.setRequestHeader("nome_stella_nuova",nome_stella_nuova);
	http.setRequestHeader("tipo","stella");
	http.send();
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