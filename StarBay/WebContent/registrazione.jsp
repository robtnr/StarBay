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
	<script	src="js/controlliLogin.js"></script>
	<script src="js/controlliRegistrazione.js"></script>
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
					<div id="formRegistrazione" class="col-md-4 col-md-offset-4">
						<form action"#" style="margin-top:20px;">
							<div id="divNome" class="form-group">
								<label id="labelNome" for="inputNome">Nome</label>
								<input id="inputNome" class="form-control" name="nome" placeholder="Nome" type="text" onblur="controlloNome(this)"/>
								<span id="spanNome" style="display: none" class="help-block"></span>
								<span id="iconNome" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divCognome" class="form-group">
								<label id="labelCognome" for="inputCognome">Cognome</label>
								<input id="inputCognome" class="form-control" name="cognome" placeholder="Cognome" type="text" onblur="controlloCognome(this)"/>
								<span id="spanCognome" style="display: none" class="help-block"></span>
								<span id="iconCognome" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divComune" class="form-group">
								<label id="labelComune" for="inputComune">Comune</label>
								<input id="inputComune" class="form-control" name="comune" placeholder="Comune" type="text" onblur="controlloComune(this)"/>
								<span id="spanComune" style="display: none" class="help-block"></span>
								<span id="iconComune" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divIndirizzo" class="form-group">
								<label id="labelIndirizzo" for="inputIndirizzo">Indirizzo</label>
								<input id="inputIndirizzo" class="form-control" name="indirizzo" placeholder="Indirizzo" type="text" onblur="controlloIndirizzo(this)"/>
								<span id="spanIndirizzo" style="display: none" class="help-block"></span>
								<span id="iconIndirizzo" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divEmail" class="form-group">
								<label id="labelEmail" for="inputEmail">Email</label>
								<input id="inputEmail" class="form-control" name="email" placeholder="Email" type="text" onblur="controlloEmail(this)"/>
								<span id="spanEmail" style="display: none" class="help-block"></span>
								<span id="iconEmail" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divUsername" class="form-group">
								<label id="labelUsername" for="inputUsername">Username</label>
								<input id="inputUsername" class="form-control" name="username" placeholder="Username" type="text" onblur="controlloUsername(this)"/>
								<span id="spanUsername" style="display: none" class="help-block"></span>
								<span id="iconUsername" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divPassword" class="form-group">
								<label id="labelPassword" for="inputPassword">Password</label>
								<input id="inputPassword" class="form-control" name="password" placeholder="Password" type="password" onblur="controlloPassword(this)"/>
								<span id="spanPassword" style="display: none" class="help-block"></span>
								<span id="iconPassword" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div id="divIBAN" class="form-group">
								<label id="labelIBAN" for="inputIBAN">IBAN</label>
								<input id="inputIBAN" class="form-control" name="iban" placeholder="IBAN" type="text" onblur="controlloIBAN(this)"/>
								<span id="spanIBAN" style="display: none" class="help-block"></span>
								<span id="iconIBAN" style="display: none" class="glyphicon glyphicon-remove form-control-feedback"></span>
							</div>
							<div>
								
							</div>
						</form>
						<button style="margin-bottom:20px; margin-top:5px;" id="buttonLogin" onclick="controlloDati()" class="btn btn-default col-md-4 col-md-offset-4">
									Registrati
								</button>
					</div>
				</div>
			</section>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
	
<script type="text/javascript">
	<%
	if(request.getParameter("mex")!=null)
	{
		String mex=(String)request.getParameter("mex");
		if(mex.equals("nok"))
		{
	%>
	swal("Errore", "Username gi� esistente, cambia e riprova!", "error");
	<%
		}
	}
	%>
</script>
</body>
</html>