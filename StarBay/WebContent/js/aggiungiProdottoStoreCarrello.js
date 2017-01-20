/**
 * Aggiungi Prodotto Store al Carrello
 * si occupa di aggiungere un prodotto store al carrello
 * 
 * Metodo aggiungiProdottoStoreCarrello
 * questo metodo chiama la servlet che inserisce il prodotto store nel carrello e poi esso mostra un alert
 * @param x oggetto node che rappresenta un button
 * 
 */

function aggiungiProdottoStoreCarrello(x)
{
	var div_principale = x.parentNode.parentNode;
	var title = document.getElementsByTagName("TITLE")[0].childNodes[0].nodeValue;
	var tutti_div = div_principale.getElementsByTagName("DIV");
	var nome_prodotto_store = tutti_div[2].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	var prezzo = tutti_div[3].getElementsByTagName("DIV")[0].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	var quantita = tutti_div[5].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
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
					  title:"Prodotto store inserito con successo!",
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
					  title: "Prodotto store esaurito!",
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
	http.open("POST", "ServletInserimentoProdottoCarrello", true);
	http.setRequestHeader("nome_prodotto_store",nome_prodotto_store);
	http.setRequestHeader("prezzo",prezzo);
	http.setRequestHeader("quantita",quantita);
	http.setRequestHeader("pagina_da_reindirizzare",title);
	http.setRequestHeader("tipo","store");
	http.send();
	
}