<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.io.*,java.util.*, javax.servlet.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
h1 {
color: white;
text-align: center;
text-shadow: 0.05em 0.05em 0.2em black
}

p {
text-align="center";
}

button {
    background-color: #ffa100; 
    border: 2px solid #ffc86b;
    color: white;
    padding: 15px 20px;
    width: 500px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 8px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.1s;
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.2s;
}

button:hover {
    background-color: #ffc86b; 
    color: black;
    
}

button:hover span {
  padding-right: 25px;
}

button:hover span:after {
  opacity: 1;
  right: 0;
}


h2.date {
color: yellow;
text-align: center;
text-shadow: 0.01em 0.01em 0.2em black
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProyectoFP</title>

</head>
<body background="http://www.wallpaperbetter.com/wallpaper/745/151/627/bmw-z4-black-car-at-sunset-1080P-wallpaper.jpg">
	
	
	<h1>Programa de orden de usuarios que van a usar el coche</h1>
	
	<p align="center">
		<a href="ListaUsuarios.jsp">
			<button>
				<h2><span>Mostrar lista de usuarios </span></h2>
			</button>
		</a>
		<br>
		<br>
		
		<a href="AñadirUsuario.html">
			<button>
				<h2><span>Añadir usuarios</span></h2>
			</button>
		</a>
		<br>
		<br>
		
		<a href="BorrarUsuario.html">
		<button>
			<h2><span>Eliminar usuarios</span></h2>
		</button>
		</a>
		<br>
		<br>
		<button>
			<h2><span>Elegir qué usuarios han usado el coche hoy</span></h2>
		</button>
	</p>
	<br>
<%
   Date date = new Date();
   out.print( "<h2 align=\"center\" class=\"date\">" + "Fecha y Hora: "+date.toString()+"</h2>");
%>
</body>
</html>