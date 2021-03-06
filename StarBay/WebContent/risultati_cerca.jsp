<%@page import="it.starbay.gestionebean.Stella"%>
<%@page import="it.starbay.gestionebean.Store"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="it.starbay.gestionebean.Cliente" %>
<!DOCTYPE html>
<html>
<head>
<title>Ricerca su <%= request.getParameter("chiave") %></title>
<meta charset="UTF-8" />
<meta name="keywords"
	content="stelle, venditaonline, binocolo, telescopio, star, e-commerce">
<meta name="description"
	content="Vendita di stelle, binocoli e telescopi.">
<meta name="author" content="Roberto Contaldo, Gianluca De Luca Fiscone">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="shortcut icon" href="images/favicon.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script	src="js/controlliLogin.js"></script>
<script	src="js/logout.js"></script>
<script	src="js/richiediNomeStella.js"></script>
<script	src="js/aggiungiProdottoStoreCarrello.js"></script>
<script	src="js/ricercaProdotto.js"></script>
<!-- Link per SweetAlert -->
	<script src="dist/sweetalert-dev.js"></script>
    <link rel="stylesheet" href="dist/sweetalert.css">	
</head>
<body>

	<%if(session.getAttribute("cliente")==null){ %>
	<%@ include file="includes/headerNonLoggato.jsp"%>
	<%
	}
	else
	{
	%>
	<%@ include file="includes/headerLoggato.jsp"%>
	<%
	}
	%>
	<%@ include file="includes/menu.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
				
					<% if(session.getAttribute("prodotti_ricercati")!=null)
						{
							ArrayList prodotti_ricercati = (ArrayList) session.getAttribute("prodotti_ricercati");
							if(prodotti_ricercati.size()==0)
							{
							%>
							<label style="font-size: 20px;margin-top: 30px;margin-bottom: 250px; margin-left:2px">Nessun prodotto trovato</label>
							<%
							}
							else
							{
							for(int i=0; i<prodotti_ricercati.size(); i=i+2)
							{
								String tipo = (String)prodotti_ricercati.get(i);
							if(tipo.equals("stella"))
							{
								Stella stella = (Stella)prodotti_ricercati.get(i+1);
							%>
							<article class="col-md-3">
								<div id="box_article">
									<div id="new">
									</div>
									<div id="immagine_article_new">
										<img src="<%= stella.getSrc()%>" class="img-responsive">
									</div>
									<div id="descrizione_pagina"><span><%= stella.getNome()%></span>, <%= stella.getDescrizione()%></div>
									<div id="compra_articolo">
										<div id="prezzo">
											PREZZO: <span id="cifra"><%=stella.getPrezzo()%></span> &euro;
										</div>
										<button type="button" id="bottonePiu" onclick="richiediNomeStella(this)">
											<span><img src="images/carrello_piu.png"
												alt="Aggiungi al carrello" title="Aggiungi al carrello"></span>
										</button>
									</div>
								</div>
							</article>
							
							<%
							}
							else 
							{
								Store store = (Store)prodotti_ricercati.get(i+1);
						    %>
							    <article class="col-md-3">
									<div id="box_article">
										<div id="new">
										</div>
										<div id="immagine_article_new">
											<img src="<%=store.getSrc()%>" class="img-responsive">
										</div>
										<div id="descrizione_pagina"><span><%= store.getNome()%></span>, <%=store.getDescrizione()%></div>
										<div id="compra_articolo">
											<div id="prezzo">
												PREZZO: <span id="cifra"><%= store.getPrezzoVendita() %></span> &euro;
											</div>
											<button type="button" id="bottonePiu" onclick="aggiungiProdottoStoreCarrello(this)">
												<span><img src="images/carrello_piu.png"
													alt="Aggiungi al carrello" title="Aggiungi al carrello"></span>
											</button>
										</div>
										<div id="quantita">DISPONIBILITA': <span><%= store.getQuantita() %></span></div>
									</div>
								</article>
						    <%
							}}}}
					%>
					
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
	
	<%@ include file="includes/form_accedi.jsp"%>
<script type="text/javascript">
</script>
</body>
</html>