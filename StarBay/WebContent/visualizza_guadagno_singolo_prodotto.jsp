<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	if(session.getAttribute("admin")==null)
		response.sendError(response.SC_UNAUTHORIZED,"Non sei autorizzato!");
	else
	{
	%>
<!DOCTYPE html>
<html>
<head>
<title>Visualizza guadagno singolo prodotto </title>
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
<script src="dist/sweetalert-dev.js"></script>
<link rel="stylesheet" href="dist/sweetalert.css">
	<script	src="js/visualizzaGuadagnoSingoloProdotto.js"></script>	
</head>
<body>

	<%@ include file="includes/headerLoggatoAdmin.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
				<div id="back_admin">
						<a href="gestore.jsp"><img src="images/arrow_left.png"></a>
					</div>
				<div style="margin-top:30px; margin-bottom:25px" class="col-md-12 table-responsive">
				<center>
							<label style="font-size: 20px; margin-bottom: 20px;">Guadagno per singolo prodotto</label>
				</center>
					<table id="table_prodotti" style="border:1px solid black" class="table" >
					<thead style="border:1px solid black; color:#ffc307; background-color:#070d19;">
				      <tr>
				        <th>ID</th>
				        <th>Nome prodotto</th>
				        <th>Guadagno</th>
				        <th>Data (AAAA-MM-GG)</th>
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
<%
	}
%>