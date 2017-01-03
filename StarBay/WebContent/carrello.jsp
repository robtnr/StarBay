<%@ page language="java" contentType="text/html;"%>
<!DOCTYPE html>
<html>
<head>
<title>Carrello</title>
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
<!-- Link per SweetAlert -->
	<script src="dist/sweetalert-dev.js"></script>
    <link rel="stylesheet" href="dist/sweetalert.css">	
</head>
<body>

	<%@ include file="includes/headerNonLoggato.jsp"%>
	<%@ include file="includes/menu.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
			<div class="row">
				<div id="scontrino" class="col-md-6 col-md-offset-3">
					<div id="scontrino_sup">StarBay<p>Prodotti</p></div>
					<div id="scontrino_med">
					<table id="tabella_scontrino" class="table">
					    <thead>
					      <tr>
					        <th>Nome</th>
					        <th>Quantit�</th>
					        <th>Prezzo &euro;</th>
					        <th></th>
					      </tr>
					    </thead>
					    <tbody>
					      <tr>
						    <td class="nome_prodotto">Andromeda</td>
							<td>1</td>
							<td>25.00 &euro;</td>
							<td><img src="images/less.png" title="clicca qui per eliminare"></td>  
					      </tr>
					      <tr>
						    <td class="nome_prodotto">Andromeda</td>
							<td>1</td>
							<td>25.00 &euro;</td>
							<td><img src="images/less.png" title="clicca qui per eliminare"></td>  
					      </tr>
					    </tbody>
					    </table>					
					</div>
					<div id="scontrino_bar"><hr></div>
					<div id="scontrino_tot">TOTALE<p>100.00 &euro;</p></div>
					<div id="scontrino_acquista"><input class="submit_acquista" type="submit" value="acquista"></div>
			    </div>			

				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
	
	<div id="MyModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content" id="modalContent">
				<div class="modal-header" id="modalHeader">
					<button type="button" id="buttonChiudi" class="close"
						data-dismiss="modal">
						<span><img src="images/close.png"></span>
					</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body" id="modalBody">
					<div class="row">
						<div class="col-lg-12">
							<form>
								<div class="form-group">
									<label for="inputUserName">Username</label> <input
										class="form-control" name="username" placeHolder="Username" type="text"
										id="inputUsername" />
								</div>
								<div class="form-group">
									<label for="inputPassword">Password</label> <input
										class="form-control" name="password" placeHolder="Password" type="password"
										id="inputUsername" />
								</div>
								<div>
									<button id="buttonLogin" type="submit"
										class="btn btn-default col-md-2 col-md-offset-5">Login
									</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer" id="modalFooter">
					<div>Non sei ancora registrato?</div>
					<div>
						<a href="registrazione.jsp">Registrati</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>