<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página 6</title>
</head>
<body background="IMG/Pagina6.jpg">
	<% 
		String identificador = request.getParameter("Identificador"); 
		String idadministrador = request.getParameter("IdAdministrador"); 
	
	
	%>
<form action="CambiarContraseña" >
	<h3>Contraseña actual:</h3>
	<input type="text" name="contraseñaActual">
	<h3>Nueva contraseña:</h3>
	<input type="text" name="nuevaContraseña">
	<h3>Repetir contraseña:</h3>
	<input type="text" name="nuevaContraseña2">
	<input type="hidden" name="Identificador" value="<%= identificador %>">
	<input type="hidden" name="IdAdministrador" value="<%= idadministrador %>">
	<input type="submit" value="Cambiar contraseña">
</form>
</body>
</html>