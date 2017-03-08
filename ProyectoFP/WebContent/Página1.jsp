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
<title>Insert title here</title>
</head>
<body>
	
	<h4 style="text-align: center;">¿A quién le toca hoy?</h4>
	<p></p>
		<div class="row">
		<form class="col s12" action="AñadirAdmin">
		<div class="row">
		<legend><h5 text-color="blue">Registrarse</h5></legend>
	   
			<div class="input-field col l4 m6 s12">
			<input type="text" name="Identificador" placeholder="Elige el nombre del usuario" required>
			<label for="Identificador">Nombre de usuario</label>
			</div>
			
			<div class="input-field col l4 m6 s12">
			<input type="password" name="clave" placeholder="Elige la contraseña" required>
			<label for="clave">Contraseña</label>
			</div>
			
			
		</div>
		
		<input class="button" type="submit" value="Registrarse"><br/>
		</form>
		
		
	
		
	
</body>
</html>