function richiediNomeStella(x)
{
	var div_principale = x.parentNode.parentNode;
	var tutti_div = div_principale.getElementsByTagName("DIV");
	var nome_stella = tutti_div[2].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	var prezzo = tutti_div[3].getElementsByTagName("DIV")[0].getElementsByTagName("SPAN")[0].childNodes[0].nodeValue;
	open("modifica_nome_stella.jsp?prezzo="+prezzo+"&"+"nome_stella="+nome_stella,"_self");
}