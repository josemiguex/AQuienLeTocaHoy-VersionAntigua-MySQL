<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página 6</title>

<meta name="viewport" content="width=device-width, initial-scale=1">      
	  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
	  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
      <link rel="stylesheet" type="text/css" href="CSS/Pagina6.css">
</head>
<body background="IMG/Pagina6.jpg">
	<% 
		String identificador = request.getParameter("Identificador"); 
		String idadministrador = request.getParameter("IdAdministrador"); 
	
	
	%>
<div class="contenedor">
<legend><h5>Selección de nueva contraseña</h5></legend>
<form class="col s12" action="CambiarContraseña">
<div class="row">

<div class="input-field col l4 m12 s12">
	<input type="password" name="contraseñaActual" placeholder="Pon aquí la contraseña actual" required>
	<label for="contraseñaActual">Contraseña actual</label>
	
	</div>
	<div class="input-field col l4 m12 s12">
	<input type="password" name="nuevaContraseña" placeholder="Pon aquí la nueva contraseña" required>
	<label for="nuevaContraseña">Nueva contraseña</label>
	</div>
	
	<div class="input-field col l4 m12 s12">
	
	<input type="password" name="nuevaContraseña2" placeholder="Repite la nueva contraseña" required>
	<label for="nuevaContraseña"></label>
	</div>
	
	<input type="hidden" name="Identificador" value="<%= identificador %>">
	<input type="hidden" name="IdAdministrador" value="<%= idadministrador %>">
	
	<input class="button" type="submit" value="Cambiar contraseña">
	</div>
	</form>
</div>


</body>
</html>