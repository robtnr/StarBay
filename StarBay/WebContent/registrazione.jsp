<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registrazione</title>
	<meta charset="UTF-8" />
	<meta name="keywords" content="stelle, venditaonline, binocolo, telescopio, star, e-commerce">
    <meta name="description" content="Vendita di stelle, binocoli e telescopi.">
    <meta name="author" content="Roberto Contaldo, Gianluca De Luca Fiscone">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="shortcut icon" href="images/favicon.ico" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/style.css">

</head>
<body>

	<%@ include file="includes/headerNonLoggato.jsp"%>
	<%@ include file="includes/menu.jsp"%>

	<div class="container">
		<div class="row">
			<section class="col-md-10 col-md-offset-1">
				<div class="row">
				<div id="formRegistrazione" class="col-md-4 col-md-offset-4">
					<form>
						<div class="form-group">
							<label for="inputNome">Nome</label>
							<input class="form-control" name="nome" placeHolder="Nome" type="text" id="inputNome"/>
					    </div>
					    <div class="form-group">
							<label for="inputCognome">Cognome</label>
							<input class="form-control" name="cognome" placeHolder="Cognome" type="text" id="inputCognome"/>
					    </div>
					    <div class="form-group">
							<label for="inputNome">Comune</label>
							<input class="form-control" name="comune" placeHolder="Comune" type="text" id="inputComune"/>
					    </div>
					    <div class="form-group">
							<label for="inputNome">Indirizzo</label>
							<input class="form-control" name="indirizzo" placeHolder="Indirizzo" type="text" id="inputIndirizzo"/>
					    </div>
					    <div class="form-group">
							<label for="inputNome">Email</label>
							<input class="form-control" name="email" placeHolder="Email" type="text" id="inputEmail"/>
					    </div>
						<div class="form-group">
							<label for="inputUserName">Username</label>
							<input class="form-control" placeHolder="Username" type="text" id="inputUsername"/>
					    </div>
						<div class="form-group">
							<label for="inputPassword">Password</label>
							<input class="form-control" placeHolder="Password" type="password" id="inputUsername"/>
						</div>
						<div class="form-group">
							<label for="inputUserName">IBAN</label>
							<input class="form-control" placeHolder="IBAN" type="text" id="inputIban"/>
					    </div>
						<div>
							<button id="buttonLogin" type="submit" class="btn btn-default col-md-4 col-md-offset-4">
								Registrati
							</button>
						</div>
					 </form>
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
					<button type="button" id="buttonChiudi" class="close" data-dismiss="modal">
						<span><img src="images/close.png"></span>
					</button>
					<h4 class="modal-title">Login</h4>
				</div>
				<div class="modal-body" id="modalBody">
					<div class="row">
						<div class="col-lg-12">
							<form>
								<div class="form-group">
									<label for="inputUserName">Username</label>
									<input class="form-control" placeHolder="Username" type="text" id="inputUsername"/>
								</div>
								<div class="form-group">
									<label for="inputPassword">Password</label>
									<input class="form-control" placeHolder="Password" type="password" id="inputUsername"/>
								</div>
								<div>
									<button id="buttonLogin" type="submit" class="btn btn-default col-md-2 col-md-offset-5">Login
									</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer" id="modalFooter">
						<div>Non sei ancora registrato?</div> 
						<div><a href="registrazione.jsp">Registrati</a></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>