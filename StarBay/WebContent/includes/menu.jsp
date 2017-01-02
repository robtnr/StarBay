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
							<li class="attivo"><a href="index.jsp">home</a></li>
							<li><a href="stelle.jsp">stelle</a></li>
							<li><a href="store.jsp">store</a></li>
							<li><a href="mappa.jsp">mappa</a></li>
						</ul>
					<ul class="nav navbar-nav navbar-right" style="margin-right:-116px;">
				    	<li><a data-toggle="modal" href="#MyModal">accedi</a></li>
				    	<li>
							<button type="submit" id="buttonCarrello" class="btn btn-default">
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