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
public class AñadirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AñadirUsuario() {
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
		try {
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	        
	        String query = "SELECT DNI FROM USUARIO";     
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        

	        while (rs.next()) {
	        
	        	if (request.getParameter("DNI").equals(rs.getString("DNI"))) {
		        	request.setAttribute("DNIduplicado",true);
	        	}
	        }
	        
		    String query2 = "INSERT INTO USUARIO (DNI, NOMBRE, APELLIDO1, APELLIDO2, EMAIL, IdAdministrador) VALUES ('" + request.getParameter("DNI") + "','" + request.getParameter("Nombre") + "','" + request.getParameter("Apellido1") + "','" + request.getParameter("Apellido2") + "','" + request.getParameter("email") + "','" + request.getParameter("IdAdministrador") + "')"; 
	        stmt2 = connection.createStatement();
	        int insert = stmt2.executeUpdate(query2);
	        
	        
	        
	        	
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
	        		String nextJSP = "/Pagina3.jsp?IdAdministrador=" + request.getParameter("IdAdministrador");
        			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        			dispatcher.forward(request,response);
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
