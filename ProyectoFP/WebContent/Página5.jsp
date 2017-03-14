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
	</head>
	<body>
	<h4 style="text-align: center;">¿A quién le toca hoy?</h4>
	<% String admin = request.getParameter("Identificador"); 
	%>
	<div class="container">
	<div class="row">
	<div class="col l12 m12 s12">
	
		<table style="margin:0 auto;" class="striped">
		<form action="MainServlet2" method="get" name="form1">
			<jsp:include page="AnotarServlet" flush="true"/>
				<input type="hidden" name="Identificador" value="<%= admin %>">
				
			
			</form>
		</table>
	</div>
	</div>
	</div>
	

	<nav>
	
	
        
        
      <ul id="nav-mobile" class="left hide-on-med-and-down">
      
      <form action="MainServlet2" method="get" name="form1">
      <input type="hidden" name="Identificador" value="<%= admin %>">
        <li><a onclick="document.forms['form1'].submit(); return false;">Anotar</a></li>
        
        </form>
  </nav>
  </form>	
	</body>
</html>