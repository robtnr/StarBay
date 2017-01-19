<%@page import="it.starbay.gestionebean.Stella"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
	if(session.getAttribute("admin")==null)
		response.sendError(response.SC_UNAUTHORIZED,"Non sei autorizzato!");
	else {
	%>
	
<!DOCTYPE html>
<html>
<head>
<% Stella p = (Stella)session.getAttribute("stella_daModificare"); %>
<title>Modifica stella <%= p.getNome() %></title>
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
	src="js/modificaProdottoSingoloStella.js"></script>
	<script	src="js/logout.js"></script>
<!-- Link per SweetAlert -->
	<script src="dist/sweetalert-dev.js"></script>
    <link rel="stylesheet" href="dist/sweetalert.css">	
</head>
<body>

	<%@ include file="includes/headerLoggatoAdmin.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
				<div id="back_admin">
						<a href="modifica_prodotto_stella.jsp"><img src="images/arrow_left.png"></a>
					</div>
					<div id="form" class="col-md-12" style="margin: 15px 0;">
						<form id="formStella" action="#" class="col-md-8 col-md-offset-2" style="margin-top:20px;margin-bottom:20px;">
							<center><label style="font-size:20px; margin-bottom:10px;">Inserimento del prodotto stella</label></center>
							<div id="divNome" class="form-group">
								<label id="labelNome" for="inputNome">Nome</label>
								<input id="inputNome" class="form-control" name="nome" placeholder="Nome" type="text" onblur="controlloNome(this)" value="<%= p.getNome()%>"/>
								<span id="spanNome" style="display: none" class="help-block"></span>
								<span id="iconNome" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divPrezzo" class="form-group">
								<label id="labelPrezzo" for="inputPrezzo">Prezzo</label>
								<input id="inputPrezzo" class="form-control" name="prezzo" placeholder="Prezzo" type="text" onblur="controlloPrezzo(this)" value="<%= p.getPrezzo()%>"/>
								<span id="spanPrezzo" style="display: none" class="help-block"></span>
								<span id="iconPrezzo" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divCoordinate" class="form-group">
								<label id="labelCoordinate" for="inputCoordinate">Coordinate</label>
								<input id="inputCoordinate" class="form-control" name="coordinate" placeholder="Coordinate" type="text" onblur="controlloCoordinate(this)" value="<%= p.getCoordinate()%>"/>
								<span id="spanCoordinate" style="display: none" class="help-block"></span>
								<span id="iconCoordinate" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divDescrizione" class="form-group">
								<label id="labelDescrizione" for="inputDescrizione">Descrizione</label>
								<textarea id="inputDescrizione" class="form-control" name="descrizione" row="5" type="text" onblur="controlloDescrizione(this)"><%= p.getDescrizione() %></textarea>
								<span id="spanDescrizione" style="display: none" class="help-block"></span>
								<span id="iconDescrizione" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
						</form>					
						<button id="buttonLogin" onclick="controlloDatiSingolaStella()" class="btn btn-default col-md-4 col-md-offset-4">
									Modifica
						</button>
					</div>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>

	
</body>
</html>
<% } %>