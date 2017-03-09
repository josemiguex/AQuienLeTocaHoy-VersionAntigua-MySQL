<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Página 3</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">      
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
	<div class="container">
	<div class="row">
	<div class="col l12 m12 s12">
	
		<table style="margin:0 auto;" class="striped">
			<jsp:include page="MainServlet" flush="true"/>			
		</table>
	</div>
	</div>
	</div>

	<nav>
    <div class="nav-wrapper green">
      <a  href="añadir.jsp" class="btn-floating btn-large waves-effect waves-light green left"><i class="material-icons">add</i></a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
        <li><a href="EliminarUsuario">Eliminar</a></li>
        <li><a href="anotar.jsp">Anotar</a></li>
      </ul>
    </div>
  </nav>
	</body>
</html>