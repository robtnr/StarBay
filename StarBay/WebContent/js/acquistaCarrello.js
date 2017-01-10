function acquistaCarrello()
{
	var http = new XMLHttpRequest();
	http.onreadystatechange = function()
	{
		if(http.readyState==4 && http.status==200)
		{
			var mex_acquisto = http.getResponseHeader("mex_acquisto");
			if(mex_acquisto=="errore_non_loggato")
			{
				swal({
					  title: "Non sei loggato/Non sei registrato?",
					  text: "Loggati o registrati!",
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonColor: "#DD6B55",
					  confirmButtonText: "Registrati",
					  cancelButtonText: "Cancel",
					  closeOnConfirm: false,
					  closeOnCancel: false
					},
					function(isConfirm){
					  if (isConfirm) {
						  open("registrazione.jsp","_self");
					  } else {
						  open("carrello.jsp","_self");
					  }
					});
			}
			else if(mex_acquisto=="nok")
			{
				var lunghezza_header = http.getResponseHeader("lunghezza_header");
				var text="";
				for(var i=1;i<=lunghezza_header;i++)
				{
					var tipo =  http.getResponseHeader("tipo"+i);
					var nome =  http.getResponseHeader("nome"+i);
					var quantita_trovata =  http.getResponseHeader("quantita_trovata"+i);
					var quantita_vecchia =  http.getResponseHeader("quantita_vecchia"+i);
					if(tipo=="quantita_sottratta")
						{
						text+=i+") La quantita' di "+ quantita_vecchia+" "+nome+" richiesta non e' disponibile. In magazzino ne sono presenti "+quantita_trovata+".\n "; 
						}
					else if(tipo=="quantita_eliminata")
						{
						text+=i+") La quantita' di "+ quantita_vecchia+" "+nome+" richiesta non e' disponibile. In magazzino non ne sono presenti per cui il prodotto e' stato eliminato dal carrello.\n "; 
						}
				}
				swal({
					  title: "Carrello aggiornato!",
					  text: text,
					  type: "warning",
					  showCancelButton: true,
					  confirmButtonColor: "#DD6B55",
					  confirmButtonText: "OK",
					  cancelButtonText: "Cancel",
					  closeOnConfirm: false,
					  closeOnCancel: false
					},
					function(isConfirm){
					  if (isConfirm) {
						  open("carrello.jsp","_self");
					  } else {
						  open("carrello.jsp","_self");
					  }
					});
			}
			else if(mex_acquisto=="ok")
				{
					setTimeout(function(){
						open("carrello.jsp","_self");
					}, 1200);
					swal("Successo", "I prodotti nel carrello sono stati acquistati!", "success")
				}
			}
		}
	http.open("POST", "http://localhost:8080/StarBay/ServletAcquistaCarrello", true);
	http.send();
	}
	
	
