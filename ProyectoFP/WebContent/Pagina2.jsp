<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta name="viewport" content="width=device-width, initial-scale=1">      
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página 2</title>
</head>
<body>

<h4 style="text-align: center;">¿A quién le toca hoy?</h4>

<div class="container">
<div class="row">
<div class="col l12 m12 s12">
<table style="margin: 0 auto;" class="striped">
<jsp:include page="MainServlet" flush="true"/>
</table>
</div>
</div>
</div>
<form class="col s12" action="">
<div class="row">
<legend><h5>Iniciar sesión</h5></legend>
<div class="input-field col l3 m6 s12">
<input type="text" name="nombre" placeholder="Introduce el nombre de usuario" required>
<label for="nombre"> Usuario del administrador</label>
</div>
<div class="input-field col l3 m6 s12">
<input type="password" name="clave" placeholder="Inreuduce su contraseña" required>
<label for="clave">Clave del administrador</label>
</div><br><br><br><br>
<input class="button" type="submit" value="Iniciar Sesión">
</div>
</form>

<form class="col s12" action="">
<div class="row">
<legend><h5>¿Quieres ver otra tabla?</h5></legend>
<div class="input-field col l3 m6 s12">
<input type="text" name="IdAdmin" placeholder="Introduce el usuario del administrador" required>
<label for="IdAdmin"> Usuario del administrador</label>
</div>
<input class="button" type="submit" value="Buscar tabla">
</div>
</form>

</body>
</html>