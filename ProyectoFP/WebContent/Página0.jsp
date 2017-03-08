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
<style>
h1,h2,h3,h4,h5,h6 {
color: #FFFFFF;
text-align: center;
}
p,b {
color: white;
}

.button {
    background-color: #42a4f4; 
    border: 2px solid #63b9ff;
    color: white;
    padding: 15px 20px;
    width: 250px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 8px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.1s;
    box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 3px 10px 0 rgba(0,0,0,0.19);
    
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.2s;
}

.button:hover {
    background-color: #63b9ff; 
    color: black;
    
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}

input {
color: white;
}

div.uno {
border-top: 500px;
}
</style>
</head>
<body background="http://www.fondos7.net/wallpaper-original/wallpapers/fotos-de-autos-7395.jpg">
	
	<h4 style="text-align: center;">¿A quién le toca hoy?</h4>
	<p align=center><b >Información de la página</b></p> <br/>
	
	<div class="uno">
	<a href="Página1.jsp"><button class="button"><span>Registrarse</span></button></a>
	<br/>
		<form class="col s12" action="Pagina2.jsp">
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
		<input class="button" type="submit" value="Iniciar sesión"><br/>
		
	</form>
	
	<br>
	
	<form class="col s12" action="Pagina2.jsp">
		<div class="row">
		<legend><h5>Mostrar usuarios de un determinado administrador</h5></legend>
	       <div class="input-field col l3 m6 s12">
			<input type="text" name="IdAdmin" placeholder="Pon aquí el identificador del administrador">
			<label for="IdAdmin">Id del administrador</label>
			</div>
			
			</div>
		</div>
		<input class="button" type="submit" value="Mostrar usuarios"><br/>
		
	</form>
	</div>
</body>
</html>