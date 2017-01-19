<%@page import="it.starbay.gestionebean.Stella"%>
<%@page import="java.util.ArrayList"%>
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
<title>Modifica prodotto stella</title>
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
	<script	src="js/modificaProdottoStella.js"></script>
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
						<a href="gestore.jsp"><img src="images/arrow_left.png"></a>
					</div>
				<div style="margin-top:30px; margin-bottom:25px" class="col-md-12 table-responsive">
				<center>
							<label style="font-size: 20px; margin-bottom: 20px;">Catalogo delle stelle</label>
				</center>
					<table id="table_prodotti" style="border:1px solid black" class="table" >
					<thead style="border:1px solid black; color:#ffc307; background-color:#070d19;">
				      <tr>
				        <th>Nome</th>
				        <th>Descrizione</th>
				        <th>Coordinate</th>
				        <th>Prezzo di vendita</th>
				        <th>Data</th>
				        <th></th>
				      </tr>
				    </thead>
				    <tbody>
				    <% if(session.getAttribute("carica_prodotti_stella")==null)
				    	{
					    	RequestDispatcher rd = request.getRequestDispatcher("/ServletCaricaProdotti");
					    	request.setAttribute("mex_carica", "stella");
					    	request.setAttribute("pagina", "modifica");
							rd.forward(request, response);
				    	}
				    	else
				    	{
				    		ArrayList<Stella> carica_prodotti_stella = (ArrayList<Stella>)session.getAttribute("carica_prodotti_stella");
				    		for(Stella s: carica_prodotti_stella)
				    		{
				    %>
				      <tr>
				        <td><%= s.getNome() %></td>
				        <td><%= s.getDescrizione() %></td>
				        <td><%= s.getCoordinate() %></td>
				        <td><%= s.getPrezzo() %></td>
				        <td><%= s.getData()%></td>
				        <td><img id="modifica_prodotto" onclick=modificaProdottoStella(this) src="images/modifica.png" title="modifica"></td>
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
<%
	}
%>