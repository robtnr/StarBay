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
<script src="dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="dist/sweetalert.css">	
<script	src="js/logout.js"></script>
<script	src="js/gestore.js"></script>
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
							<li>Inserimento prodotto<a href="inserimento_prodotto_stella.jsp"><img src="images/arrow.png">Stella</a><a href="inserimento_prodotto_store.jsp"><img src="images/arrow.png">Store</a></li>
							<li>Modifica prodotto<a href="modifica_prodotto_stella.jsp"><img src="images/arrow.png">Stella</a><a href="modifica_prodotto_store.jsp"><img src="images/arrow.png">Store</a></li>
							<li>Elimina prodotto<a href="elimina_prodotto_stella.jsp"><img src="images/arrow.png">Stella</a><a href="elimina_prodotto_store.jsp"><img src="images/arrow.png">Store</a></li>
							<li><a href="#">Elimina Utente </a></li>
							<li>Visualizza<a href="#" onclick="visualizzaGuadagno()"><img src="images/arrow.png">Guadagno</a><a href="#" onclick="visualizzaRicavo()"><img src="images/arrow.png">Ricavo</a></li>
							<li><a href="visualizza_guadagno_singolo_prodotto.jsp">Visualizza guadagno per singolo prodotto</a></li>
						</ul>
					</div>

				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>