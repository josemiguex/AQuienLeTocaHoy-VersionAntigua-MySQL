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
public class AñadirAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AñadirAdmin() {
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
        boolean error = false;
		try {
			
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	        		    
		    String query = "insert into ADMINISTRADOR (IDENTIFICADOR, CLAVE) values ('" + request.getParameter("Identificador") + "','" + request.getParameter("clave") + "')" ;	        
	        
		    stmt = connection.createStatement();
	        int insert = stmt.executeUpdate(query);
	        
	 
		} catch (NamingException e) {
			
			response.getWriter().append(e.getMessage());
			e.printStackTrace();
	    } catch (SQLException e ) {
	    	response.getWriter().append("<b>No se ha podido añadir el administrador:</b>" + "<br>");
	    	error = true;
			e.printStackTrace();
			response.getWriter().append(e.getMessage());	  
			
	    } finally {
	        if (stmt != null) {	        	
	        	try {
	        		if (!error) {
	        		String nextJSP = "/Pagina3.jsp";
	    			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	    			dispatcher.forward(request,response);
					stmt.close();
	        		}
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
