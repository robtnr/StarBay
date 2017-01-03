<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>StarBay</title>
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
</head>
<body>

	<%@ include file="includes/headerNonLoggato.jsp"%>
	<%@ include file="includes/menu.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
					<article class="col-md-3">
						<div id="box_article">
							<div id="new">
								<img src="images/new1.png">
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
								<img src="images/new1.png">
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
								<img src="images/new1.png">
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
								<img src="images/new1.png">
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
	
	<div id="MyModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" id="modalContent">
				<div class="modal-header" id="modalHeader">
					<button type="button" id="buttonChiudi" class="close"
						data-dismiss="modal">
						<span><img src="images/close.png"></span>
					</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body" id="modalBody">
					<div class="row">
						<div class="col-lg-12">
							<form action="#" >
							<div id="divUsername" class="form-group">
								<label id="labelUsername" for="inputUsername">Username</label>
								<input id="inputUsername" class="form-control" name="username" placeholder="Username" type="text" onblur="controlloUsername(this)"/>
								<span id="spanUsername" style="display: none" class="help-block"></span>
								<span id="iconUsername" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divPassword" class="form-group">
								<label id="labelPassword" for="inputPassword">Password</label>
								<input id="inputPassword" class="form-control" name="password" placeholder="Password" type="password" onblur="controlloPassword(this)"/>
								<span id="spanPassword" style="display: none" class="help-block"></span>
								<span id="iconPassword" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							</form>
							<button id="buttonForm" onclick="controlloDati()" class="btn btn-default col-md-4 col-md-offset-4">
									Login
								</button>
						</div>
					</div>
				</div>
				<div class="modal-footer" id="modalFooter">
					<div>Non sei ancora registrato?</div>
					<div>
						<a href="registrazione.jsp">Registrati</a>
					</div>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
	<%
	if(request.getParameter("mex")!=null)
	{
		String mex=(String)request.getParameter("mex");
		if(mex.equals("ok"))
		{
	%>
	alert("Inserimento effettuato con successo, BENVENUTO!");
	<%
		}
	}
	%>
</script>
</body>
</html>