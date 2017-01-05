<%@page import="java.util.ArrayList"%>
<%@page import="it.starbay.gestionebean.Store"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Modifica prodotto store</title>
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
	<script	src="js/modificaProdotto.js"></script>
</head>
<body>

	<%@ include file="includes/headerLoggatoAdmin.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
				<div style="margin-top:30px;" class="col-md-12 table-responsive">
					<table id="table_prodotti" style="border:1px solid black" class="table" >
					<thead style="border:1px solid black; color:#ffc307; background-color:#070d19;">
				      <tr>
				        <th>Nome</th>
				        <th>Descrizione</th>
				        <th>Src</th>
				        <th>Prezzo vendita</th>
				        <th>Prezzo d'acquisto</th>
				        <th>Quantit�</th>
				        <th>Data</th>
				        <th></th>
				      </tr>
				    </thead>
				    <tbody>
				    <% if(session.getAttribute("carica_prodotti_store")==null)
				    	{
					    	RequestDispatcher rd = request.getRequestDispatcher("/ServletCaricaProdotti");
					    	request.setAttribute("mex_carica", "store");
							rd.forward(request, response);
				    	}
				    	else
				    	{
				    		ArrayList<Store> carica_prodotti_store = (ArrayList<Store>)session.getAttribute("carica_prodotti_store");
				    		for(Store s: carica_prodotti_store)
				    		{
				    %>
				      <tr>
				        <td><%= s.getNome() %></td>
				        <td><%= s.getDescrizione() %></td>
				        <td><%= s.getSrc() %></td>
				        <td><%= s.getPrezzoVendita() %></td>
				        <td><%= s.getPrezzoAcquisto() %></td>
				        <td><%= s.getQuantita() %></td>
				        <td><%= s.getData()%></td>
				        <td><img id="modifica_prodotto" onclick=modificaProdotto(this) src="images/modifica.png" title="modifica"></td>
				      </tr>
				     <%
				    		}
				    	}
				     %>
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