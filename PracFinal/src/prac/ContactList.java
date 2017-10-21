package prac;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/ContactList")
public class ContactList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactList() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		List<Contact> entries = new ArrayList<Contact>();
		List<FirstLetter> letter = new ArrayList<FirstLetter>();
		
		entries.add( new Contact(1, "George Kassar", "(764) 123-2344" ));
		entries.add( new Contact(2, "Gary Smith", "(234) 789-2564" ));
		entries.add( new Contact(3, "Al Bart", "(169) 867-2399" ));
		
		for( Contact entry  : entries ) {
			
			String firstLetter = entry.getName().substring(0, 1);
			
			if(!letter.contains(firstLetter)){
				letter.add(new FirstLetter(firstLetter));
			}
			
			
		}

		getServletContext().setAttribute( "entries", entries );
		getServletContext().setAttribute( "letter", letter );
		
		try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Contact> entries = (List<Contact>) getServletContext().getAttribute("entries" );
		List<FirstLetter> letter = (List<FirstLetter>) getServletContext().getAttribute("letter" );
		
		
		Connection c = null;
    	try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";
            String username = "cs3220stu24";
            String password = "LsEokQ5j";

            c = DriverManager.getConnection( url, username,
                password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from contacts" );
            

            while( rs.next() )
            {
            	entries.add( new Contact(
            			Integer.valueOf(rs.getString( "id" )),
            			rs.getString( "name" ), 
            			rs.getString( "number" )
            			));
            }
            
            rs.close();
            
            
            
            ResultSet rs1 = stmt.executeQuery( "select * from letters" );
            

            while( rs1.next() )
            {
            	letter.add( new FirstLetter(
            			rs1.getString( "letter" )
            			));
            }
            
            rs1.close();
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
        
		request.getRequestDispatcher( "/WEB-INF/ContactList.jsp" ).forward( request,
		         response );
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}








