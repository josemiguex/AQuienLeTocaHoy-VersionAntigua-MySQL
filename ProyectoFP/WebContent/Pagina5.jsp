<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>P�gina 5</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">      
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/css/materialize.min.css">
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>           
		<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.3/js/materialize.min.js"></script> 
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="CSS/Pagina0.css">
		<script>
		 $('.datepicker').pickadate({
			    selectMonths: true, // Creates a dropdown to control month
			    selectYears: 15 // Creates a dropdown of 15 years to control year
			  });
		</script>
		
			<style>
				body {
				background-image: url(IMG/Pagina5.jpg);
				background-attachment: fixed;/*para que sea est�tico*/
				background-position: top right;/*arriba a la derecha*/
				background-repeat: no-repeat;/*que no se repita el fondo*/
				}
			</style>
	</head>
	<body >
	<h4 style="text-align: center;">�A qui�n le toca hoy?</h4>
	<% String admin = request.getParameter("Identificador"); 
	String idadministrador = request.getParameter("IdAdministrador"); 
	
	Date fecha = new Date();
	Calendar c1 = Calendar.getInstance();
	Calendar c2 = new GregorianCalendar();
	
	String date = String.valueOf(c1.get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(c1.get(Calendar.MONTH) + 1) + "/" + String.valueOf(c1.get(Calendar.YEAR));
	
	String hora = "";
	if (String.valueOf(c1.get(Calendar.HOUR_OF_DAY)).length() == 2) {
		hora += String.valueOf(c1.get(Calendar.HOUR_OF_DAY));
		} else {
		hora += "0" + String.valueOf(c1.get(Calendar.HOUR_OF_DAY));
		}
	
	hora += ":";
	if (String.valueOf(c1.get(Calendar.MINUTE)).length() == 2) {
		hora += String.valueOf(c1.get(Calendar.MINUTE));
		} else {
		hora += "0" + String.valueOf(c1.get(Calendar.MINUTE));
		}
	
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
		<br/>
		
			<input  class="input-field col l6 m6 s12" type="text" name="Fecha" value="<%= date %>"  style="background: #d7ccc8">
			
	<input class="input-field col l6 m6 s12" type="text" name="Hora" value="<%= hora %>"   required  style="background: #d7ccc8">
			
	</table>
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