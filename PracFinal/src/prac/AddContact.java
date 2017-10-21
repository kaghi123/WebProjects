package prac;

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


@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Integer idSeed = 100;
	
    public AddContact() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher( "/WEB-INF/AddContact.jsp" ).forward( request,
				response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name =  request.getParameter( "name" );
			 
		String number =  request.getParameter( "number" );
		
		String letter = name.substring(0,1);
		
		int id = idSeed++;
		
		List<Contact> entries = (List<Contact>) getServletContext().getAttribute("entries" );
	    
		List<FirstLetter> letters = (List<FirstLetter>) getServletContext().getAttribute("letters" );
		
	    Connection c = null;
    	try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";
            String username = "cs3220stu24";
            String password = "LsEokQ5j";
            
            String sql = "insert into contacts (id, name, number) values (?, ?, ?)";
            
            String sql1 = "insert into letters (letter) values (?)";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt(1, id);
            pstmt.setString( 2, name );
            pstmt.setString( 3, number );
          
            pstmt.executeUpdate();

            
            PreparedStatement pstmt1 = c.prepareStatement( sql1 );
            pstmt1.setString(1, letter);
          
            pstmt1.executeUpdate();
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
	        
	        	response.sendRedirect( "ContactList?id=" + id);
	        
		
		
		
	}
}