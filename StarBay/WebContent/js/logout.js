/**
* Logout
*
* Metodo logOut
* questo metodo chiama la servlet per effettuare il logout
*/


function logOut()
{
		var http = new XMLHttpRequest();
		http.onreadystatechange = function()
		{
			if(http.readyState==4 && http.status==200)
			{
				var esito_logout = http.getResponseHeader("logout");
				if(esito_logout=="ok")
					open("index.jsp","_self");
				
			}
		}
		http.open("POST", "http://localhost:8080/StarBay/ServletLogout", true);
		http.send();
}