<%@page import="it.starbay.gestionebean.Stella"%>
<%@page import="it.starbay.gestionebean.Store"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="it.starbay.gestionebean.Cliente" %>
<!DOCTYPE html>
<html>
<head>
<title>Modifica nome stella</title>
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
<script	src="js/aggiungiStellaCarrello.js"></script>
<!-- Link per SweetAlert -->
	<script src="dist/sweetalert-dev.js"></script>
    <link rel="stylesheet" href="dist/sweetalert.css">
    <%
    	String nome_stella = request.getParameter("nome_stella");
    	String prezzo = request.getParameter("prezzo");
    	session.setAttribute("prezzo", prezzo);
    	
    	session.setAttribute("nome_stella", nome_stella);
    	
    	session.setAttribute("pagina_da_reindirizzare", request.getParameter("title"));
    %>
			
</head>
<body>

	<%if(session.getAttribute("cliente")==null)
	{  %>
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
					<div class="col-md-5 col-md-offset-3">
						<div id="divNome" class="form-group" style="margin-top:30px; margin-bottom:20px;">
								<label id="labelNome" for="inputNome">Inserisci nome nuovo oppure lascia quello predefinito</label>
								<input id="inputNome" class="form-control" name="nome" placeholder="Nome stella" type="text" value="<%= nome_stella%>"/>
								<span id="spanNome" style="display: none" class="help-block"></span>
								<span id="iconNome" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
						</div>
						<button id="buttonLogin" onclick="aggiungiStellaCarrello()" class="btn btn-default col-md-4 col-md-offset-4">
									Modifica
						</button>
						<div style="margin-top:150px"></div>
					</div>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
	
	<%@ include file="includes/form_accedi.jsp"%>

</body>
</html>