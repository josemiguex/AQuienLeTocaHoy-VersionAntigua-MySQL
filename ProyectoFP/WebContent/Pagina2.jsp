<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">

<meta name="viewport" content="width=device-width, initial-scale=1">      
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página 2</title>
<link rel="stylesheet" type="text/css" href="CSS/Pagina2.css">
<style>
body {
background-image: url(IMG/Pagina2.jpg);
background-attachment: fixed;/*para que sea estático*/
background-position: top right;/*arriba a la derecha*/
background-repeat: no-repeat;/*que no se repita el fondo*/
}
</style>

</head>
<body>

<%
if (request.getParameter("CodAdmin").equals("")) {
	out.println("<script> alert(\"Este administrador no existe\"); </script>");
}
%>
<script>
	if (${notExist == 'true'}) {
		  alert("Este administrador no existe");
	}
	
	</script>
<h4 style="text-align: center;">¿A quién le toca hoy?</h4>

<div class="container">
<div class="row">
<div class="col l12 m12 s12">
<table style="margin: 0 auto;" class="striped" bgcolor="#dbdbdb">
<jsp:include page="MostrarTabla" flush="true"/>
</table>
</div>
</div>
</div>

<div class="contenedor">
<form class="col s12" action="LogInServlet" method="post">
<div class="row">
<legend><h5>Iniciar sesión</h5></legend>
<div class="input-field col l3 m6 s12">
<input type="text" name="Identificador" placeholder="Introduce el identificador del administrador" required>
<label for="Identificador"> Identificador del administrador</label>
</div>
<div class="input-field col l3 m6 s12">
<input type="password" name="clave" placeholder="Introduce su contraseña" required>
<label for="clave">Clave del administrador</label>
</div><br><br><br><br>
<input class="button" type="submit" value="Iniciar Sesión">
</div>
</form>
	<p><a href="Pagina7.jsp">¿Has olvidado tu contraseña?</a></p>

<form class="col s12" action="URLServlet">
<div class="row">
<legend><h5>¿Quieres ver otra tabla?</h5></legend>
<div class="input-field col l3 m6 s12">
<input type="text" name="Identificador" placeholder="Introduce el usuario del administrador" required>

<label for="Identificador"> Usuario del administrador</label>
</div>
<input class="button" type="submit" value="Buscar tabla">
</div>
</form>
</div>


</body>
</html>