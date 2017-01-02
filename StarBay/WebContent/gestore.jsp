<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestore</title>
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
</head>
<body>

	<%@ include file="includes/headerLoggatoAdmin.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
					
					<div id="menu_gestione" class="col-md-6 col-md-offset-3">
					<img id="tool" alt="tool" src="images/gestore.png">
						<ul>
							<li>Inserimento prodotto<a href="#"><img src="images/arrow.png">Stella</a><a href="#"><img src="images/arrow.png">Store</a></li>
							<li>Modifica prodotto<a href="#"><img src="images/arrow.png">Stella</a><a href="#"><img src="images/arrow.png">Store</a></li>
							<li>Elimina prodotto<a href="#"><img src="images/arrow.png">Stella</a><a href="#"><img src="images/arrow.png">Store</a></li>
							<li><a href="#">Elimina Utente </a></li>
							<li>Visualizza<a href="#"><img src="images/arrow.png">Guadagno</a><a href="#"><img src="images/arrow.png">Ricavo</a></li>
							<li><a href="#">Visualizza guadagno per singolo prodotto</a></li>
						</ul>
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
								<div>
									<button id="buttonLogin" type="submit"
										class="btn btn-default col-md-2 col-md-offset-5">Login
									</button>
								</div>
							</form>
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