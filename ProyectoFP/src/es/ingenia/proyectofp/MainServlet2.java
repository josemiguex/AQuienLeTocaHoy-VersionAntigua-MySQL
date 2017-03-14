package es.ingenia.proyectofp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;


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
public class MainServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet2() {
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
        String borrar;
		try {
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	        PrintWriter pw = response.getWriter();
			response.setContentType("text/html");

	        
	        String[] ID = new String[10];
	        int i = 0;
	        
	        while (i < ID.length) {
	        	
	        	if (!request.getParameter("" + i + "").equals("null")) {
		        	ID[i] = request.getParameter("" + i + "");
		        	i++;
	        	}
	        	response.getWriter().append(ID[i]+ "<br>");
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
	        		String nextJSP = "/Pagina3.jsp";
        			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        			dispatcher.forward(request,response);
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
