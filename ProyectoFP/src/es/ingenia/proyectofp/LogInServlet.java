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
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
        boolean existe = false;
       
		try {
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
		    String query = "SELECT * FROM ADMINISTRADOR WHERE IDENTIFICADOR='" + request.getParameter("Identificador") + "' AND CLAVE='" + request.getParameter("clave") + "'"; 
	        stmt = connection.createStatement();
	        ResultSet rs = stmt.executeQuery(query);
	        //response.getWriter().append("<table style=\"margin: 0 auto;\">");
	        
            //String identificador = rs.getString("IDENTIFICADOR");
            //String clave = rs.getString("CLAVE");
	        while (rs.next())
	        {
	        	if (rs.getString("IDENTIFICADOR").equals(request.getParameter("Identificador")) && rs.getString("CLAVE").equals(request.getParameter("clave"))) {
	                existe = true;
	        }
            
            }
	        
	        	
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
	        		if (existe) {
	        			String nextJSP = "/Pagina3.jsp";
	        			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	        			dispatcher.forward(request,response);
	        		} else {
	        			
	        			
	        			String msg = "Usuario o contraseña incorrectos";
	        	        request.setAttribute("msg", msg); 
	        	        RequestDispatcher rd = request.getRequestDispatcher("/Página0.jsp");
	        	        rd.forward(request, response);

	        			
	        		}
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