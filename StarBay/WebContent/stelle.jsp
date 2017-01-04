<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Stelle</title>
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
					<article class="col-md-3">
						<div id="box_article">
							<div id="new">
							</div>
							<div id="immagine_article_new">
								<img src="images/stella.png" class="img-responsive">
							</div>
							<div id="descrizione_pagina">Donec leo, vivamus fermentum
								nibh in augue praesent a lacus at urna congue rutrum wisi
								maecenas ligula.</div>
							<div id="compra_articolo">
								<div id="prezzo">
									PREZZO: <span id="cifra">38.00</span> &euro;
								</div>
								<button type="button" id="bottonePiu">
									<span><img src="images/carrello_piu.png"
										alt="Aggiungi al carrello" title="Aggiungi al carrello"></span>
								</button>
							</div>
						</div>
					</article>
					
					<article class="col-md-3">
						<div id="box_article">
							<div id="new">
							</div>
							<div id="immagine_article_new">
								<img src="images/stella.png" class="img-responsive">
							</div>
							<div id="descrizione_pagina">Donec leo, vivamus fermentum
								nibh in augue praesent a lacus at urna congue rutrum wisi
								maecenas ligula.</div>
							<div id="compra_articolo">
								<div id="prezzo">
									PREZZO: <span id="cifra">38.00</span> &euro;
								</div>
								<button type="button" id="bottonePiu">
									<span><img src="images/carrello_piu.png"
										alt="Aggiungi al carrello" title="Aggiungi al carrello"></span>
								</button>
							</div>
						</div>
					</article>
					
					<article class="col-md-3">
						<div id="box_article">
							<div id="new">
							</div>
							<div id="immagine_article_new">
								<img src="images/stella.png" class="img-responsive">
							</div>
							<div id="descrizione_pagina">Donec leo, vivamus fermentum
								nibh in augue praesent a lacus at urna congue rutrum wisi
								maecenas ligula.</div>
							<div id="compra_articolo">
								<div id="prezzo">
									PREZZO: <span id="cifra">38.00</span> &euro;
								</div>
								<button type="button" id="bottonePiu">
									<span><img src="images/carrello_piu.png"
										alt="Aggiungi al carrello" title="Aggiungi al carrello"></span>
								</button>
							</div>
						</div>
					</article>
					

				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
	
	<%@ include file="includes/form_accedi.jsp"%>
	
</body>
</html>