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
        Statement stmt2 = null;
        boolean error = false;
        String idAdministrador = "";
		try {
			
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	        		    
		    String query = "insert into ADMINISTRADOR (IDENTIFICADOR, CLAVE, CODADMIN) values ('" + request.getParameter("Identificador") + "','" + request.getParameter("clave") + "','" + request.getParameter("codAdmin") + "')" ;	        
	        
		    stmt = connection.createStatement();
	        int insert = stmt.executeUpdate(query);
	        
	        String query2 = "SELECT IDADMINISTRADOR FROM ADMINISTRADOR WHERE IDENTIFICADOR LIKE '" + request.getParameter("Identificador") + "'" ;	        
	        
		    stmt2 = connection.createStatement();
		    ResultSet rs2 = stmt2.executeQuery(query2);
		    
		    while (rs2.next())
	        {
		    	idAdministrador = rs2.getString("IDADMINISTRADOR");
	        }
		    
	 
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
	        		String nextJSP = "/Pagina3.jsp?IdAdministrador=" + idAdministrador;
	    			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	    			dispatcher.forward(request,response);
	    			connection.close();
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
