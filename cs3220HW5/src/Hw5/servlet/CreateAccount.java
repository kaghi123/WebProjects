package Hw5.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Integer idSeed = 100;
	
    public CreateAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher( "/WEB-INF/CreateAccount.jsp" ).forward( request,
		         response );
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Account> account = (List<Account>) getServletContext().getAttribute("account" );
		
		
		
		String username1 = request.getParameter( "username" );
		String password1 = request.getParameter( "password" );
		
		for(Account entry : account){
			if(username1.equals(entry.getUsername()) ){
				response.sendRedirect( "CreateAccount" );
				break;
			}
			else{
				
				HttpSession session = request.getSession();
				
				session.setAttribute( "username", username1 );
				session.setAttribute( "password", password1 );
				
				
				
				
				Connection c = null;
		    	try
		        {
		            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";
		            String username = "cs3220stu24";
		            String password = "LsEokQ5j";
		            
		            String sql = "insert into account (name, passowrd, accId) values (?, ?, ?)";

		            c = DriverManager.getConnection( url, username, password );
		            PreparedStatement pstmt = c.prepareStatement( sql );
		            pstmt.setString( 1, request.getParameter( "username" ) );
		            pstmt.setString( 2, request.getParameter( "password" ) );
		            pstmt.setInt(3, idSeed++);
		            pstmt.executeUpdate();
		            c.close();
		            
		        }
		        catch( SQLException e )
		        {
		            throw new ServletException( e );
		        }
		    	finally
		        {
		            try
		            {
		                if( c != null ) c.close();
		            }
		            catch( SQLException e )
		            {
		                throw new ServletException( e );
		            }
		        }
				
				
				
				request.getRequestDispatcher( "/WEB-INF/Login.jsp" ).forward( request,
				         response );
				}
			}
		}
		
		
		

}
