<%@page import="it.starbay.gestionebean.Stella"%>
<%@page import="it.starbay.gestionebean.Store"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="it.starbay.gestionebean.Cliente" %>
<!DOCTYPE html>
<html>
<head>
<title>StarBay</title>
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
				
					<% if(session.getAttribute("store_ultimi_prodotti")==null && session.getAttribute("stelle_ultimi_prodotti")==null)
						{
							RequestDispatcher rd = request.getRequestDispatcher("/ServletCaricaUltimiProdotti");
							rd.forward(request, response);
						}
						else
						{
							ArrayList<Store> store_ultimi_prodotti = (ArrayList<Store>) session.getAttribute("store_ultimi_prodotti");
							ArrayList<Stella> stelle_ultimi_prodotti = (ArrayList<Stella>) session.getAttribute("stelle_ultimi_prodotti");
							for(Stella s:stelle_ultimi_prodotti)
							{
							
					%>
					<article class="col-md-3">
						<div id="box_article">
							<div id="new">
								<img src="images/new1.png">
							</div>
							<div id="immagine_article_new">
								<img src="<%=s.getSrc()%>" class="img-responsive">
							</div>
							<div id="descrizione_pagina"><%= s.getNome()%>, <%=s.getDescrizione()%></div>
							<div id="compra_articolo">
								<div id="prezzo">
									PREZZO: <span id="cifra"><%=s.getPrezzo()%></span> &euro;
								</div>
								<button type="button" id="bottonePiu">
									<span><img src="images/carrello_piu.png"
										alt="Aggiungi al carrello" title="Aggiungi al carrello"></span>
								</button>
							</div>
						</div>
					</article>
				    <%
				    		}
							for(Store s:store_ultimi_prodotti)
							{
				    %>
				    <article class="col-md-3">
						<div id="box_article">
							<div id="new">
								<img src="images/new1.png">
							</div>
							<div id="immagine_article_new">
								<img src="<%=s.getSrc()%>" class="img-responsive">
							</div>
							<div id="descrizione_pagina"><%= s.getNome()%>, <%=s.getDescrizione()%></div>
							<div id="compra_articolo">
								<div id="prezzo">
									PREZZO: <span id="cifra"><%= s.getPrezzoVendita() %></span> &euro;
								</div>
								<button type="button" id="bottonePiu">
									<span><img src="images/carrello_piu.png"
										alt="Aggiungi al carrello" title="Aggiungi al carrello"></span>
								</button>
							</div>
						</div>
					</article>
					<%		}
							
						} 
					%>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
	
	<%@ include file="includes/form_accedi.jsp"%>
<script type="text/javascript">
	<%
	if(request.getParameter("mex")!=null)
	{
		String mex=(String)request.getParameter("mex");
		if(mex.equals("ok"))
		{
	%>
	swal("Benvenuto!", "Registrazione effettuata con successo", "success");
	<%
		}
	}
	%>
	
	<%
	if(request.getParameter("mex_login")!=null)
	{
		String mex=(String)request.getParameter("mex_login");
		if(mex.equals("nok"))
		{
	%>
	swal("Errore!", "Username o password sbagliate, reinserirle!", "error");
	<%
		}
		else
		{
			Cliente c = (Cliente) session.getAttribute("cliente");
	%>
	swal("Salve "+"<%= c.getNome() %>","Login effettuato con successo!", "success");
	<%
		}
	}
	%>
</script>
</body>
</html>