<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">      
	  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
	  <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
      <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
<title>¿A quién le toca hoy?</title>
<link rel="stylesheet" type="text/css" href="CSS/Pagina0.css">

</head>
<body bgcolor="#FFFFFF" background="http://www.fondos7.net/wallpaper-original/wallpapers/fotos-de-autos-7395.jpg">


	<h4 style="text-align: center;">¿A quién le toca hoy?</h4>
	<p align=center><b >Información de la página</b></p> <br/>
	
	<div class="contenedor">
	
	<legend><h5>Registrarse</h5></legend>
	<a href="Página1.jsp"><button class="button"><span>Pulse aquí para registrarse</span></button></a>
	<br/>
	<br/>
		<form class="col s12" action="LogInServlet" method="post">
		<div class="row">
		<legend><h5>Iniciar sesión</h5></legend>
	       <div class="input-field col l3 m6 s12">
			<input type="text" name="Identificador" placeholder="Pon aquí el nombre de usuario del administrador" required>
			<label for="Identificador">Nombre del administrador</label>
			</div>
			
			<div class="input-field col l3 m6 s12">
			<input type="password" name="clave" placeholder="Pon aquí la clave del administrador" required>
			<label for="clave">Clave del administrador</label>
			</div>
		</div>
		<b>${msg}</b><br/>
		<input class="button" type="submit" value="Iniciar sesión">
	</form>
	
	<br>
	
	<form class="col s12" action="Pagina2.jsp" method="post">
		<div class="row">
		<legend><h5>Mostrar usuarios de un determinado administrador</h5></legend>
	       <div class="input-field col l3 m6 s12">
			<input type="text" name="Identificador" placeholder="Pon aquí el identificador del administrador" required>
			<label for="Identificador">Id del administrador</label>
			</div>
			
			</div>
			<b>${msg2}</b><br/>
		<input class="button" type="submit" value="Mostrar usuarios"><br/>
		
	</form>
	</div>
</body>
</html>