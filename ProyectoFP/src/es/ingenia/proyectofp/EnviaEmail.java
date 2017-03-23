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
import java.util.Random;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Servlet implementation class MainServlet
 */
public class EnviaEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviaEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    public String getCadenaAlfanumAleatoria (int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
		char c = (char)r.nextInt(255);
		if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
		cadenaAleatoria += c;
		i ++;
		}
		}
		return cadenaAleatoria;
		}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        Context ctx;
        Connection connection = null;
        Statement stmt = null;
        String clave = "";
        boolean error = false;
        
    	String nuevaContraseña = getCadenaAlfanumAleatoria(8);

    	// Recipient's email ID needs to be mentioned.
        String to = request.getParameter("email");
   
        // Sender's email ID needs to be mentioned
        String from = "info@aquienletocahoy.es";
   
        // Assuming you are sending email from localhost
        String host = "correo.ingenia.es";
   
        // Get system properties
        Properties properties = System.getProperties();
   
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
   
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
        
  	  // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

    
        
		try {
			
			
	        
			ctx = new InitialContext();
	        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/ProyectoFP");
	        connection = ds.getConnection();
	       
	        String query = "UPDATE ADMINISTRADOR SET CLAVE='" + nuevaContraseña + "' WHERE EMAIL='" + request.getParameter("email") + "'" ;
	        stmt = connection.createStatement();
	        int rs = stmt.executeUpdate(query);
	        
	     // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	         // Set Subject: header field
	         message.setSubject("Restablecimiento de contraseña");
	         // Now set the actual message
	         message.setText("Esta es tu nueva contraseña de acceso: " + nuevaContraseña + ", puedes cambiarla dándole a cambiar contraseña una vez iniciada la sesión, no respondas a este correo");
	         // Send message
	         Transport.send(message);
	         
	         
	         
		}
		catch (MessagingException mex) {
	         mex.printStackTrace();
	         response.getWriter().append("Error al enviar email");
	         error = true;
	         mex.printStackTrace();
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
	        			 request.setAttribute("noErrorEmail",true);
		        			String nextJSP = "/Pagina0.jsp";
		        			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		        			dispatcher.forward(request,response);
	        		 }
	        		
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
