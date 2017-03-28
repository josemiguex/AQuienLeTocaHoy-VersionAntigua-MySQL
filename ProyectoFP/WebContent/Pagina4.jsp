<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">      
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/Pagina4.css">
		
		<title>Página 4</title>
		
		<style>
body {
background-image: url(IMG/Pagina4.jpg);
background-attachment: fixed;/*para que sea estático*/
background-position: bottom center;/*arriba a la derecha*/
background-repeat: no-repeat;/*que no se repita el fondo*/
}
</style>

	</head>
	<body>
	
	<script>
	if (${DNIduplicado == 'true'}) {
		  alert("El DNI que has introducido ya está en uso");
	}
	</script>
	
	<script>
	if (${emailDuplicado == 'true'}) {
		  alert("El Email que has introducido ya está en uso");
	}
	</script>
	
		<h4 style="text-align: center;">¿A quién le toca hoy?</h4>
		
		<%
		String servlet = "AñadirUsuario";
		String nombre = "";
		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre");
			servlet = "ModificarServlet";
		}
		
		String apellido1 = "";
		if (request.getParameter("apellido1") != null) {
			apellido1 = request.getParameter("apellido1");
		}
		
		String apellido2 = "";
		if (request.getParameter("apellido2") != null) {
			apellido2 = request.getParameter("apellido2");
		}
		
		String dni = "";
		if (request.getParameter("dni") != null) {
			dni = request.getParameter("dni");
		}
		
		String email = "";
		if (request.getParameter("email") != null) {
			email = request.getParameter("email");
		}
		
		String idUser = request.getParameter("ID");
		%>
		
		<form class="col s12" action="<%= servlet %>" method="post">
		<div class="row">
		<div class="input-field col l4 m12 s12">
		<input type="text" name="Nombre" placeholder="Nombre" value="<%= nombre %>" required>
		<label for="Nombre"> Nombre </label>
		</div>
		<div class="input-field col l4 m6 s12">
		<input type="text" name="Apellido1" placeholder="Primer apellido" value="<%= apellido1 %>" required>
		<label for="Apellido1">Primer apellido</label>
		</div>
		<div class="input-field col l4 m6 s12">
		<input type="text" name="Apellido2" placeholder="Segundo apellido" value="<%= apellido2 %>">
		<label for="Apellido2">Segundo apellido</label>
		</div>
		<div class="input-field col l6 m6 s12">
		<input type="text" name="DNI" id="DNI" placeholder="DNI" value="<%= dni %>" required>
		<label for="DNI">DNI</label>
		</div>
		<div class="input-field col l6 m6 s12">
		<input type="email" name="email" placeholder="Correo electrónico" value="<%= email %>" required>
		<label for="email" data-error="wrong" data-success="right">Correo electrónico</label>
		<%String id = request.getParameter("IdAdministrador");
		  String identificador = request.getParameter("Identificador");	
		%>
			
		<input type="hidden" name="IdAdministrador" value=<%=id %>>
		<input type="hidden" name="Identificador" value=<%=identificador %>>
		</div>
		<br><br><br><br>
		<center>
		
		<%
		if (request.getParameter("nombre") == null) {
			out.println("<input class=\"button\" type=\"submit\" value=\"Añadir Usuario\">");
		} else {
			out.println("<input type=\"hidden\" name=\"ID\" value=\"" + idUser + "\">");
			out.println("<input type=\"hidden\" name=\"datos\" value=\"datos\">");
			out.println("<input type=\"hidden\" name=\"dniActual\" value=\"" + dni + "\">");
			out.println("<input type=\"hidden\" name=\"emailActual\" value=\"" + email + "\">");
			out.println("<input class=\"button\" type=\"submit\" value=\"Modificar Usuario\">");
		}
		
		%>
		</center>
		</div>
		</form>


	</body>
</html>