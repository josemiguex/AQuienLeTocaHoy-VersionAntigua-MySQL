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
		<title>Página 4</title>
	</head>
	<body>
		<h4 style="text-align: center;">¿A quién le toca hoy?</h4>
		
		
		<form class="col s12" action="AñadirUsuario" method="post">
		<div class="row">
		<div class="input-field col l4 m12 s12">
		<input type="text" name="Nombre" placeholder="Nombre" required>
		<label for="Nombre"> Nombre </label>
		</div>
		<div class="input-field col l4 m6 s12">
		<input type="text" name="Apellido1" placeholder="Primer apellido" required>
		<label for="Apellido1">Primer apellido</label>
		</div>
		<div class="input-field col l4 m6 s12">
		<input type="text" name="Apellido2" placeholder="Segundo apellido">
		<label for="Apellido2">Segundo apellido</label>
		</div>
		<div class="input-field col l6 m6 s12">
		<input type="text" name="DNI" placeholder="DNI" required>
		<label for="DNI">DNI</label>
		</div>
		<div class="input-field col l6 m6 s12">
		<input type="email" name="email" placeholder="Correo electrónico" required>
		<label for="email" data-error="wrong" data-success="right">Correo electrónico</label>
		<%String id = request.getParameter("admin");
		%>
				
		<input type="hidden" name="Identificador" value=<%=id %>>
		</div>
		<br><br><br><br>
		<center>
		
		<input class="button" type="submit" value="Añadir Usuario">
		
		</center>
		</div>
		</form>


	</body>
</html>