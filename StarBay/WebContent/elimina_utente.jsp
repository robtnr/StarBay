<%@page import="it.starbay.gestionebean.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Elimina Utente</title>
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
	<script	src="js/logout.js"></script>
	<script	src="js/eliminaUtente.js"></script>
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
				<div style="margin-top:30px; margin-bottom:25px" class="col-md-12 table-responsive">
				<center>
					<label style="font-size: 20px; margin-bottom: 20px;">Catalogo delle stelle</label>
				</center>
					<table id="table_utenti" style="border:1px solid black" class="table" >
					<thead style="border:1px solid black; color:#ffc307; background-color:#070d19;">
				      <tr>
				        <th>Cognome</th>
				        <th>Nome</th>
				        <th>Username</th>
				        <th>Email</th>
				      </tr>
				    </thead>
				    <tbody id ="tbody">
				    
					</tbody>
					</table>
				</div>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>