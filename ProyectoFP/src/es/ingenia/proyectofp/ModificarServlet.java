package es.ingenia.proyectofp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class MainServlet
 */
public class ModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarServlet() {
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
        Statement stmt3 = null;

        String dni = "";
        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";
        String email = "";
        boolean patata = false;
        
        String idadministrador = request.getParameter("IdAdministrador");
		try {
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
		    
	        if (request.getParameter("datos") == null) {
	        String query = "SELECT DNI, NOMBRE, APELLIDO1, APELLIDO2, EMAIL, IDADMINISTRADOR FROM USUARIO WHERE ID LIKE '" + request.getParameter("ID") + "'";     
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        //response.getWriter().append("<table style=\"margin: 0 auto;\">");
	        response.getWriter().append("<thead><tr><th>Orden</th><th></th><th>DNI</th><th cosplan=\"3\">Nombre y Apellidos</th><th>Pasajero</th><th>Conductor</th><th>Última fecha y hora</th></thead>");
	        int i = 1;
	        
	        while (rs.next()) {
	        	dni = rs.getString("DNI");
	            nombre = rs.getString("NOMBRE");
	            apellido1 = rs.getString("APELLIDO1");
	            apellido2 = rs.getString("APELLIDO2");
	            email = rs.getString("EMAIL");
	            idadministrador = rs.getString("IDADMINISTRADOR");
	        }
	        
	        } else {
	        	
	        	
	        	if (!request.getParameter("DNI").equals(request.getParameter("dniActual"))) {
	        	String query3 = "SELECT DNI FROM USUARIO";     
		        stmt3 = connection.createStatement();
		        ResultSet rs = stmt3.executeQuery(query3);
		        
		        while (rs.next()) {
		        	if (request.getParameter("DNI").equals(rs.getString("DNI"))) {
			        	request.setAttribute("DNIduplicado",true);
			        	patata = true;
		        	}
		        }
	        	}
	        	
	        	if (!request.getParameter("email").equals(request.getParameter("emailActual"))) {
		        	String query3 = "SELECT EMAIL FROM USUARIO";     
			        stmt3 = connection.createStatement();
			        ResultSet rs = stmt3.executeQuery(query3);
			        
			        while (rs.next()) {
			        	if (request.getParameter("email").equals(rs.getString("EMAIL"))) {
				        	request.setAttribute("emailDuplicado",true);
				        	patata = true;
			        	}
			        }
		        	}
	        	
	        	if (patata) {
	        		String query = "SELECT DNI, NOMBRE, APELLIDO1, APELLIDO2, EMAIL, IDADMINISTRADOR FROM USUARIO WHERE ID LIKE '" + request.getParameter("ID") + "'";     
	    	        stmt = connection.createStatement();
	    	        ResultSet rs = stmt.executeQuery(query);
	    	        //response.getWriter().append("<table style=\"margin: 0 auto;\">");
	    	        
	    	        
	    	        while (rs.next()) {
	    	        	dni = rs.getString("DNI");
	    	            nombre = rs.getString("NOMBRE");
	    	            apellido1 = rs.getString("APELLIDO1");
	    	            apellido2 = rs.getString("APELLIDO2");
	    	            email = rs.getString("EMAIL");
	    	            idadministrador = rs.getString("IDADMINISTRADOR");
	    	        }
	        	}
	        	String query2 = "UPDATE USUARIO SET NOMBRE='" + request.getParameter("Nombre") + "', APELLIDO1='" + request.getParameter("Apellido1") + "', APELLIDO2='" + request.getParameter("Apellido2") + "', DNI='" + request.getParameter("DNI") + "', EMAIL='" + request.getParameter("email") + "' WHERE ID='" + request.getParameter("ID") + "'" ;
    	        stmt2 = connection.createStatement();
    	        int rs2 = stmt2.executeUpdate(query2);
	        }
	        
	        
	        	
	        //response.getWriter().append("</table>");
		} catch (NamingException e) {
			response.getWriter().append(e.getMessage());
			e.printStackTrace();
	    } catch (SQLException e ) {
			e.printStackTrace();
			response.getWriter().append(e.getMessage());	        
	    } finally {
	        if (stmt != null || stmt2 != null) {	        	
	        	try {
	        		if (request.getParameter("datos") == null || patata) {
	        		String nextJSP = "/Pagina4.jsp?dni=" + dni + "&nombre=" + nombre + "&apellido1=" + apellido1 + "&apellido2=" + apellido2 + "&email=" + email;
        			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        			dispatcher.forward(request,response);
	        		} else {
	        			
	        			String nextJSP = "/Pagina3.jsp";
	        			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        			dispatcher.forward(request,response);
	        		}
					stmt.close();
					stmt2.close();
        			connection.close();

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
