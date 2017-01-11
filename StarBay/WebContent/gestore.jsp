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
					<img id="tool" alt="tool" src="images/gestore.png" />				
					<div id="wrap">
						<div class="wup">Inserimento prodotto:</div>
						<div class="wdown">
							<button onclick="window.open('inserimento_prodotto_stella.jsp','_self');"><img src="images/star.png" /> Stella</button>
							<button onclick="window.open('inserimento_prodotto_store.jsp','_self');"><img src="images/telescopio.png" /> Store</button>
						</div>
						<div class="wup">Modifica prodotto:</div>
						<div class="wdown">
							<button onclick="window.open('modifica_prodotto_stella.jsp','_self');"><img src="images/star.png" /> Stella</button>
							<button onclick="window.open('modifica_prodotto_store.jsp','_self');"><img src="images/telescopio.png" /> Store</button>
						</div>
						<div class="wup">Elimina prodotto:</div>
						<div class="wdown">
							<button onclick="window.open('elimina_prodotto_stella.jsp','_self');"><img src="images/star.png" /> Stella</button>
							<button onclick="window.open('elimina_prodotto_store.jsp','_self');"><img src="images/telescopio.png" /> Store</button>
						</div>
						<div class="wup">Gestione utenti:</div>
						<div class="wdown">
							<button onclick="window.open('elimina_utente.jsp','_self');" style="width: 179px;"><img src="images/user.png" /> Elimina utente</button>
						</div>
						<div class="wup">Visualizza:</div>
						<div class="wdown">
							<button onclick="visualizzaGuadagno()" style="margin-right: 23px" /> Guadagno</button>
							<button onclick="visualizzaRicavo()" /> Ricavo</button>
						</div>
						<div class="wup">Visualizza guadagno:</div>
						<div class="wdown">
							<button onclick="window.open('visualizza_guadagno_singolo_prodotto.jsp','_self');" style="width: 179px;"><img src="images/earn.png" /> Singolo prodotto</button>
						</div>
					</div>
					</div>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>