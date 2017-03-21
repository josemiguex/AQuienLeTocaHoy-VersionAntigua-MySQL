<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Página 5</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">      
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/Pagina0.css">
		
	</head>
	<body background="IMG/Pagina5.jpg">
	<h4 style="text-align: center;">¿A quién le toca hoy?</h4>
	<% String admin = request.getParameter("Identificador"); 
	String idadministrador = request.getParameter("IdAdministrador"); 
	%>
	<div class="container">
	<div class="row">
	<div class="col l12 m12 s12">
	<form action="AnotadorServlet" method="post" name="Anotador">
		<table style="margin:0 auto;" bgcolor="#d7ccc8" class="striped">
		
			<jsp:include page="AnotarServlet" flush="true"/>
				<input type="hidden" name="Identificador" value="<%= admin %>">
				<input type="hidden" name="IdAdministrador" value="<%= idadministrador %>">
			
			
			
		</table>
		
	<input class="input-field col l6 m6 s12" type="text" name="Fecha" placeholder="AAAA/MM/DD">
	<input class="input-field col l6 m6 s12" type="text" name="Hora" placeholder="HH:MM">
	</form>
	</div>
	</div>
	</div>
	

	<nav>
	
	
        
        <div class="nav-wrapper #a1887f brown lighten-2">
      <ul id="nav-mobile" class="left">
      <li><a onclick="document.forms['Anotador'].submit(); return false;">Anotar</a></li>
      
      </ul>
	</div>
  </nav>
	
	</body>
</html>