<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Inserimento prodotto stella</title>
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
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/style.css">
<script src="dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="dist/sweetalert.css">
<script	src="js/controlliProdottoStella.js"></script>
<script	src="js/logout.js"></script>
</head>
<body>

	<%@ include file="includes/headerLoggatoAdmin.jsp"%>      

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
					<div id="form" class="col-md-12" style="margin: 15px 0;">
						<form id="formStella" method="POST" action="ServletInserimentoProdottoStella" enctype="multipart/form-data" class="col-md-8 col-md-offset-2" style="margin-top:20px;margin-bottom:20px;">
							<center><label style="font-size:20px; margin-bottom:10px;">Inserimento del prodotto stella</label></center>
							<div id="divNome" class="form-group">
								<label id="labelNome" for="inputNome">Nome</label>
								<input id="inputNome" class="form-control" name="nome" placeholder="Nome" type="text" onblur="controlloNome(this)"/>
								<span id="spanNome" style="display: none" class="help-block"></span>
								<span id="iconNome" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divPrezzo" class="form-group">
								<label id="labelPrezzo" for="inputPrezzo">Prezzo</label>
								<input id="inputPrezzo" class="form-control" name="prezzo" placeholder="Prezzo" type="text" onblur="controlloPrezzo(this)"/>
								<span id="spanPrezzo" style="display: none" class="help-block"></span>
								<span id="iconPrezzo" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divCoordinate" class="form-group">
								<label id="labelCoordinate" for="inputCoordinate">Coordinate</label>
								<input id="inputCoordinate" class="form-control" name="coordinate" placeholder="Coordinate" type="text" onblur="controlloCoordinate(this)"/>
								<span id="spanCoordinate" style="display: none" class="help-block"></span>
								<span id="iconCoordinate" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divDescrizione" class="form-group">
								<label id="labelDescrizione" for="inputDescrizione">Descrizione</label>
								<textarea id="inputDescrizione" class="form-control" name="descrizione" row="5" type="text" onblur="controlloDescrizione(this)"></textarea>
								<span id="spanDescrizione" style="display: none" class="help-block"></span>
								<span id="iconDescrizione" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divSrc" class="form-group">
								<label id="labelSrc" for="inputSrc">Src</label>
								<input id="inputSrc" class="form-control" name="src" type="file" onblur="controlloSrc(this)" />
								<span id="spanSrc" style="display: none" class="help-block"></span>
								<span id="iconSrc" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
						</form>					
						<button id="buttonLogin" onclick="controlloDati()" class="btn btn-default col-md-4 col-md-offset-4">
									Inserisci
						</button>
					</div>
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
							<button id="buttonLogin" onclick="controlloDati()" class="btn btn-default col-md-2 col-md-offset-5">
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