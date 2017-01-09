<%@page import="it.starbay.gestionebean.Ordine"%>
<%@page import="it.starbay.gestionebean.Cliente"%>
<%@page import="it.starbay.gestioneutenti.ManagerUtenti"%>
<%@page import="java.util.ArrayList"%>
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
<script	src="js/logout.js"></script>
<script	src="js/profiloUtente.js"></script>
<script	src="js/ricercaProdotto.js"></script>
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
								<br> <span id="username">${cliente.username}</span>
								<br> ${cliente.comune}
								<br> ${cliente.indirizzo}
							</div>
						</div>

						<div class="table-responsive" style="margin-bottom: 50px;margin-top: 75px;">
							<table class="table">
						    <thead>
						      <tr style="background-color:#070d19; color:#ffc307;">
						        <th>ID Ordine</th>
						        <th>Nome</th>
						        <th>Prezzo</th>
						        <th>Quantità</th>
						       	<th>Contratto</th>
						      </tr>
						    </thead>
						    <tbody>
						      <%
						     	ManagerUtenti mu = new ManagerUtenti();
								Cliente c = (Cliente) session.getAttribute("cliente");
								ArrayList<Ordine> ordini = mu.dammiOrdiniUtente(c.getUsername());
								session.setAttribute("ordini", ordini);
						      	
						      	for (Ordine o: ordini)
						      	{
						      		if (o.getTipo().equals("stella"))
						      			out.println("<tr><td>"+o.getIdOrdine()+"</td><td>"+o.getNomeProdotto()+"</td><td>"+o.getPrezzo()+"</td><td>"+o.getQuantita()+"</td><td>CONTRATTO QUI</td></tr>");
						      		else if(o.getTipo().equals("store"))
						      			out.println("<tr><td>"+o.getIdOrdine()+"</td><td>"+o.getIdProdotto()+"</td><td>"+o.getPrezzo()+"</td><td>"+o.getQuantita()+"</td><td></td></tr>");
						      	}
						      %>
						    </tbody>
						    </table>
						    <div style="background-color:#070d19; height:2px;"><hr></div>
							<div id="totale" style="text-align:center; font-size:16px;">Totale: 100.00 &euro;</div>
						</div>
					</div>	
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>