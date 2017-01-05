<%@page import="it.starbay.gestionebean.Store"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Inserimento prodotto store</title>
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
<script
	src="js/modificaProdottoSingoloStore.js"></script>
	<script	src="js/logout.js"></script>
</head>
<body>

	<%@ include file="includes/headerLoggatoAdmin.jsp"%>
	<% Store p = (Store)session.getAttribute("prodotto_store_daModificare"); %>
	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
				<div id="form" class="col-md-12" style="margin: 15px 0;">
					<form id="formStore" method="POST" action="ServletInserimentoProdottoStore" enctype="multipart/form-data" class="col-md-8 col-md-offset-2"
						style="margin-top: 20px; margin-bottom: 20px;">
						<center>
							<label style="font-size: 20px; margin-bottom: 10px;">Modifica del prodotto store</label>
						</center>
						<div id="divNome" class="form-group">
							<label id="labelNome" for="inputNome">Nome</label> <input
								id="inputNome" class="form-control" name="nome"
								placeholder="Nome" type="text" value="<%= p.getNome() %>" /> <span
								id="spanNome" style="display: none" class="help-block"></span> <span
								id="iconNome" style="display: none"
								class="glyphicon glyphicon-remove form-control-feedback"></span>
						</div>
						<div id="divPrezzoAcquisto" class="form-group">
							<label id="labelPrezzoAcquisto" for="inputPrezzoAcquisto">Prezzo
								d'acquisto</label> <input id="inputPrezzoAcquisto" class="form-control"
								name="prezzoAcquisto" placeholder="Prezzo d'acquisto"
								type="text" value="<%= p.getPrezzoAcquisto() %>"  /> <span
								id="spanPrezzoAcquisto" style="display: none" class="help-block"></span>
							<span id="iconPrezzoAcquisto" style="display: none"
								class="glyphicon glyphicon-remove form-control-feedback"></span>
						</div>
						<div id="divPrezzoVendita" class="form-group">
							<label id="labelPrezzoVendita" for="inputPrezzoVendita">Prezzo
								di vendita</label> <input id="inputPrezzoVendita" class="form-control"
								name="prezzoVendita" placeholder="Prezzo di vendita" type="text"
							    value="<%= p.getPrezzoVendita() %>"  /> <span
								id="spanPrezzoVendita" style="display: none" class="help-block"></span>
							<span id="iconPrezzoVendita" style="display: none"
								class="glyphicon glyphicon-remove form-control-feedback"></span>
						</div>
						<div id="divQuantita" class="form-group">
							<label id="labelQuantita" for="inputQuantita">Quantit�</label> <input
								id="inputQuantita" class="form-control" name="quantita"
								placeholder="Quantit�" type="text"
								value="<%= p.getQuantita() %>"  /> <span id="spanQuantita"
								style="display: none" class="help-block"></span> <span
								id="iconQuantita" style="display: none"
								class="glyphicon glyphicon-remove form-control-feedback"></span>
						</div>
						<div id="divDescrizione" class="form-group">
								<label id="labelDescrizione" for="inputDescrizione">Descrizione</label>
								<textarea id="inputDescrizione" class="form-control" name="descrizione" row="5" type="text"><%= p.getDescrizione() %></textarea>
								<span id="spanDescrizione" style="display: none" class="help-block"></span>
								<span id="iconDescrizione" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
						</div>
						</form>	
						<div>
							<button id="buttonLogin" onclick="controlloDati()" class="btn btn-default col-md-2 col-md-offset-5">
								Modifica</button>
						</div>
					</div>
					</form>

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
							<form>
								<div class="form-group">
									<label for="inputUserName">Username</label> <input
										class="form-control" name="username" placeHolder="Username"
										type="text" id="inputUsername" />
								</div>
								<div class="form-group">
									<label for="inputPassword">Password</label> <input
										class="form-control" name="password" placeHolder="Password"
										type="password" id="inputUsername" />
								</div>
							</form>
							<button id="buttonLogin" onclick="controlloDati()" class="btn btn-default col-md-4 col-md-offset-4">
									Inserisci
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
</body>
</html>