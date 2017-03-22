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
public class CambiarContraseña extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarContraseña() {
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
        String clave = "";
        boolean error = false;
        boolean password = false;
		try {
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	        String query = "SELECT CLAVE FROM ADMINISTRADOR WHERE IDENTIFICADOR LIKE '" + request.getParameter("Identificador") + "'";
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        
	        while (rs.next()) {
	        	clave = rs.getString("CLAVE");
	        }
	        
	        if (request.getParameter("contraseñaActual").equals(clave)) {
	        	if (request.getParameter("nuevaContraseña").equals(request.getParameter("nuevaContraseña2"))) {
	        		String query2 = "UPDATE ADMINISTRADOR SET CLAVE='" + request.getParameter("nuevaContraseña") + "' WHERE IDENTIFICADOR='" + request.getParameter("Identificador") + "'" ;
	    	        stmt2 = connection.createStatement();
	    	        int rs2 = stmt.executeUpdate(query2);
		        } else {
		        	error = true;
		        	request.setAttribute("newPassword",true);
		        	
		        }
		        
	        } else {
	        	error = true;
	        	request.setAttribute("actualPassword",true);

	        }
        	//stmt = connection.createStatement();
	        //int insert = stmt.executeUpdate(query);
	        
	        
	        	
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
	        		if (!error) {
	        			request.setAttribute("noError",true);
	        		}
	        			String nextJSP = "/Pagina3.jsp?IdAdministrador=" + request.getParameter("IdAdministrador") + "&Identificador=" + request.getParameter("Identificador");
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
