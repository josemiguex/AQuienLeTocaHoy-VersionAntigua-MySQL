 package es.ingenia.proyectofp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class MainServlet2
 */
public class AnotarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        Context ctx;
        Connection connection = null;
        Statement stmt = null;
		try {
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	        //response.getWriter().append("<h1 style=\"text-align: center;\">�A QUI�N LE TOCA HOY?</h1>");
		    String query = "SELECT DNI, NOMBRE, APELLIDO1, APELLIDO2, ID FROM USUARIO WHERE IdAdministrador LIKE '" + request.getParameter("IdAdministrador") + "' ORDER BY (VA/CONDUCTOR) desc, FECHA asc, HORA asc";     
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        //response.getWriter().append("<table style=\"margin: 0 auto;\">");
	        response.getWriter().append("<thead><tr><th>Chofer</th><th>Pasajero</th><th>DNI</th><th cosplan=\"3\">Nombre y Apellidos</th></thead>");
	       int i = 1;
	        while (rs.next()) {
	        	
	        	String dni = rs.getString("DNI");
	            String nombre = rs.getString("NOMBRE");
	            String apellido1 = rs.getString("APELLIDO1");
	            String apellido2 = rs.getString("APELLIDO2");
	            String ID = rs.getString("ID");
	            response.getWriter().append("<tr><td><input type=\"radio\" name=\"" + ID + "\" id=\"chofer" + i + "\" value=\"Conductor\" /><label for=\"chofer" + i + "\"> </td><td><input type=\"radio\" name=\"" + ID + "\" id=\"pasajero" + i +"\" value=\"Pasajero\" /><label for=\"pasajero" + i + "\"></td><td>"+dni+"</td><td cosplan=\"3\">"+nombre+" "+apellido1+" "+apellido2+"</label></td></tr>");
	          i++;
	        }	
	        //response.getWriter().append("</form>");
	        //response.getWriter().append("</table>");
		} catch (NamingException e) {
			response.getWriter().append(e.getMessage());
			e.printStackTrace();
	    } catch (SQLException e ) {
			e.printStackTrace();
			response.getWriter().append(e.getMessage());	        
	    } finally {
	        if (stmt != null) {	        	
	        	try {
	        		connection.close();
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
	        } 
	    }		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

