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
							<form action="#" >
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
							</form>
							<button id="buttonLogin" onclick="controlloDati()" class="btn btn-default col-md-4 col-md-offset-4">
									Login
								</button>
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