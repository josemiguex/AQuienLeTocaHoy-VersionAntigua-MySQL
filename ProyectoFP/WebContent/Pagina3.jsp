<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>P�gina 3</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">      
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body background="IMG/Pagina3.jpg">
	<h4 style="text-align: center; color: white;text-shadow: 0.1em 0.1em #333;">�A qui�n le toca hoy?</h4>
	<% String admin = request.getParameter("Identificador"); 
	%>
	<div class="container">
	<div class="row">
	<div class="col l12 m12 s12">
	
		<table style="margin:0 auto;" bgcolor="#dbdbdb" class="striped">
		<form action="BorrarUsuario" method="get" name="form1">
			<jsp:include page="MainServlet" flush="true"/>
				<input type="hidden" name="Identificador" value="<%= admin %>">
				
			
			</form>
		</table>
	</div>
	</div>
	</div>
	

	<nav>
	
	
    <div class="nav-wrapper #616161 grey darken-2">
    <form action="Pagina4.jsp" method="get" name="form2">
    <input type="hidden" name="admin" value="<%= admin %>">
      <a  onclick="document.forms['form2'].submit(); return false;" class="btn-floating btn-large waves-effect waves-light #bdbdbd grey lighten-1 left"><i class="material-icons">add</i></a>
      
      </form>
      
      <ul class="left" id="nav-mobile" class="left hide-on-med-and-down">
      <form action="Pagina5.jsp" name="form3">
        <input type="hidden" name="Identificador" value="<%= admin %>">
        
        </form>
      
      <input type="hidden" name="Identificador" value="<%= admin %>">
        <li><a onclick="document.forms['form1'].submit(); return false;">Eliminar</a></li>
        <li><a onclick="document.forms['form3'].submit(); return false;">Anotar</a></li>
       
        
        
        
      </ul>
    </div>
  </nav>
 	
	</body>
</html>