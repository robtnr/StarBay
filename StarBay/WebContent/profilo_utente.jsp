<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Profilo ${cliente.nome} </title>
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
					<div class="col-md-7 col-md-offset-3">
						<div id="profilo_utente">
							<div id="user"><img src="images/user2.png"></div>
							<div id="info_user">
							<div id="nome_utente">${cliente.nome}  ${cliente.cognome}</div>
								<br> ${cliente.email}
								<br> ${cliente.username}
								<br> ${cliente.comune}
								<br> ${cliente.indirizzo}
							</div>
						</div>

						<div class="table-responsive" style="margin-bottom: 50px;margin-top: 75px;">
							<table class="table">
						    <thead>
						      <tr style="background-color:#070d19; color:#ffc307;">
						        <th>Nome Prodotto</th>
						        <th>Prezzo</th>
						        <th>Quantità</th>
						        <th>Data Acquisto</th>
						        <th>Contratto</th>
						      </tr>
						    </thead>
						    <tbody>
						      <tr>
							    <td>Telescopio</td>
								<td>25.00</td>
								<td>1</td>
								<td>2016-05-05</td>
								<td><a href="#">link pdf</a></td>   
						      </tr>
						    </tbody>
						    </table>
						    <div style="background-color:#070d19; height:2px;"><hr></div>
							<div style="text-align:center; font-size:16px;">Totale: 100.00 &euro;</div>
						</div>
					</div>	
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
	
</body>
</html>