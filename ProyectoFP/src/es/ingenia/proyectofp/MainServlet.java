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
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
        Statement stmt2 = null;
        String idAdministrador = "";
		try {
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	        
	        String query = "SELECT IDADMINISTRADOR FROM ADMINISTRADOR WHERE IDENTIFICADOR LIKE '" + request.getParameter("Identificador") + "'";     
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        while (rs.next()) {
	        	idAdministrador = rs.getString("IDADMINISTRADOR");
	        }	
	        
	        
		    String query2 = "SELECT DNI, NOMBRE, APELLIDO1, APELLIDO2, ID, PASAJERO, CONDUCTOR FROM USUARIO WHERE IdAdministrador LIKE '" + idAdministrador + "' ORDER BY (VA/CONDUCTOR) desc";     
	        stmt2 = connection.createStatement();
	        ResultSet rs2 = stmt2.executeQuery(query2);

	        response.getWriter().append("<thead><tr><th></th><th>DNI</th><th cosplan=\"3\">Nombre y Apellidos</th><th>Pasajero</th><th>Conductor</th></thead>");
	        while (rs2.next()) {
	        	String dni = rs2.getString("DNI");
	            String nombre = rs2.getString("NOMBRE");
	            String apellido1 = rs2.getString("APELLIDO1");
	            String apellido2 = rs2.getString("APELLIDO2");
	            String ID = rs2.getString("ID");
	            String pasajero = rs2.getString("PASAJERO");  
	            
	            String conductor = rs2.getString("CONDUCTOR");
	            
	            int pasajeroNum = Integer.parseInt(pasajero) - 1;
	            int conductorNum = Integer.parseInt(conductor) - 1;
	            
	             pasajero = Integer.toString(pasajeroNum);  
	            
	             conductor = Integer.toString(conductorNum);  
	            
	            response.getWriter().append("<tr><td><input type=\"checkbox\" name=\"dni\" id=\""+dni+ "\" value=\""+dni+ "\" /><label for=\""+dni+ "\"></td><td>"+dni+"</td><td cosplan=\"3\">"+nombre+" "+apellido1+" "+apellido2+"</label></td><td>" + pasajero + "</td><td>" + conductor + "</td></tr>");
	        }
	       
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

