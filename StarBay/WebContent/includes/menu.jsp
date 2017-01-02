<script type="text/javascript">
		window.onload = function() 
		{
			cambia_classe_attivo();
		}
		
		function cambia_classe_attivo()
		{
			document.getElementById("home").removeAttribute("class");
			document.getElementById("stelle").removeAttribute("class");
			document.getElementById("store").removeAttribute("class");
			document.getElementById("mappa").removeAttribute("class");
			var titolo = document.getElementsByTagName("TITLE")[0].innerHTML;
			if(titolo=="StarBay")
				{
				document.getElementById("home").setAttribute("class","attivo");
				}
			if(titolo=="Stelle")
				{
				document.getElementById("stelle").setAttribute("class","attivo");
				}
			if(titolo=="Store")
			{
			document.getElementById("store").setAttribute("class","attivo");
			}
			if(titolo=="Mappa")
			{
			document.getElementById("mappa").setAttribute("class","attivo");
			}
		}
</script>

<div class="container">
		<!-- Creazione Menu-->
		<div class="row">
			<nav id="menu" class="navbar navbar-default col-md-9 col-md-offset-1">
					<div class="navbar-header">
						<!-- Menu per mobile (Creazione del pulsante) -->
						<button type="button" id="bottoneMobile" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
							<span class="icon-bar" style="background-color:#ffc307;"></span>
							<span class="icon-bar" style="background-color:#ffc307;"></span>
							<span class="icon-bar" style="background-color:#ffc307;"></span>
						</button>

					</div>
					<!-- Menu -->
					<div class="collapse navbar-collapse" id="mainNavBar">
						<ul class="nav navbar-nav">
							<li id="home" class="attivo"><a href="index.jsp">home</a></li>
							<li id="stelle"><a href="stelle.jsp">stelle</a></li>
							<li id="store"><a href="store.jsp">store</a></li>
							<li id="mappa"><a href="mappa.jsp">mappa</a></li>
						</ul>
					<ul class="nav navbar-nav navbar-right" style="margin-right:-116px;">
				    	<li><a data-toggle="modal" href="#MyModal">accedi</a></li>
				    	<li>
							<button type="submit" id="buttonCarrello" class="btn btn-default" onclick="window.location.href='carrello.jsp'"">
								<span id="carrello"><img src="images/carrello.png" title="Accedi al carrello"></span>
							</button>
				    	</li>
				    </ul>

					<form class="navbar-form" role="search" style="border:none; float:left;">
						<div class="input-group">
							<input type="text" class="form-control pull-right" style="width: 128px; margin-left: 60px; border: 1px solid black; background-color: #cbcbcb; font-family: Arial; margin-top: 6px;" placeholder="Cerca">
							<span class="input-group-btn">
								<button type="submit" class="btn btn-default" style="height:32px; margin-top:6px; background-color: #cbcbcb;">
									<span class="glyphicon glyphicon-search">
										<span class="sr-only">Cerca</span>
									</span>
								</button>
							</span>
						</div>
				    </form>

				    
					</div>
			</nav>
		</div>
	</div>