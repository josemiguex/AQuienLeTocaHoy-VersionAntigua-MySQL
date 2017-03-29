package es.ingenia.proyectofp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.mysql.jdbc.StringUtils;

/**
 * Servlet implementation class MainServlet
 */
public class AnotadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotadorServlet() {
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

			Map m= request.getParameterMap();
			Set s = m.entrySet();
			Iterator it = s.iterator();
	        
			while (it.hasNext()) {

				Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

				String key = entry.getKey();
				String[] value = entry.getValue();

				
				if(value.length>1){
				for (int i = 0; i < value.length; i++) {
					response.getWriter().append("<li>" + value[i].toString() + "</li><br>");
				}
				
				} 
				if (!key.equals("IdAdministrador")) {
					if (!key.equals("Identificador")) {
						if (!key.equals("Fecha")) {
							if (!key.equals("Hora")) {
				String query = "UPDATE USUARIO SET " + value[0].toString() + "=" + value[0].toString() + "+1,VA=VA + 1, FECHA=DATE(STR_TO_DATE('" + request.getParameter("Fecha") + "','%d/%m/%Y')), HORA='"+ request.getParameter("Hora") + "' WHERE ID=" + key + "";     
		        stmt = connection.createStatement();
		        int rs = stmt.executeUpdate(query);
							}
						}
					}
				}
			}
			
			String query2 = "SELECT EMAIL FROM USUARIO WHERE IDADMINISTRADOR='" + request.getParameter("IdAdministrador") + "' ORDER BY (VA/CONDUCTOR) desc, FECHA asc, HORA asc LIMIT 2;";
	        stmt2 = connection.createStatement();
	        ResultSet rs2 = stmt2.executeQuery(query2);
	        
	        while (rs2.next()) {
	        	// Recipient's email ID needs to be mentioned.
	            String to = rs2.getString("EMAIL");
	       
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

	             // Create a default MimeMessage object.
		         MimeMessage message = new MimeMessage(session);
		         // Set From: header field of the header.
		         message.setFrom(new InternetAddress(from));
		         // Set To: header field of the header.
		         message.addRecipient(Message.RecipientType.TO,
		                                  new InternetAddress(to));
		         // Set Subject: header field
		         message.setSubject("¿A QUIEN LE TOCA HOY?");
		         // Now set the actual message
		         message.setText("Le recordamos que esta en los primeros puestos en la lista para llevar el coche.\nSaludos.\nPor favor no responda este mensaje.");
		         // Send message
		         Transport.send(message);
	        }
		}catch (MessagingException mex) {
	         mex.printStackTrace();
	         response.getWriter().append("Error al enviar email");
	         
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
	
	public static boolean isEmpty(String variable) {
	    return variable == null || variable.length() == 0;
	}

}
