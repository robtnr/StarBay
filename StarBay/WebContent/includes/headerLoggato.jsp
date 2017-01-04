<%@ page import="it.starbay.gestionebean.Cliente" %>
<!-- Header con il logo -->
	<div class="container">
		<div class="row">
			<header class="col-md-10 col-md-offset-1">
				<div id="logoContainer">
					<a href="index.jsp"><img src="images/logo.png" class="img-responsive"></a>
				</div>
				<div id="benvenuto">
				Benvenuto <a href="#"><%= ((Cliente)session.getAttribute("cliente")).getNome() %></a><img id="logout" title="logout" src="images/logout.png" onclick="logOut()">
				</div>
			</header>	
		</div>
	</div>