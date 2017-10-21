package Lab20;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Lab20.Faculty;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }
    
    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
        request.getRequestDispatcher( "/WEB-INF/AddFaculty.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	Connection c = null;
    	try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";
            String username = "cs3220stu24";
            String password = "LsEokQ5j";

            String sql = "insert into faculty (name) values (?)";
            
            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, request.getParameter( "name" ) );
            pstmt.executeUpdate();
            c.close();
            
            //Faculty faculty = new Faculty( request.getParameter( "faculty" ) );
           // if( request.getParameter( "chair" ) != null ) faculty.setChair( true );

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

    	 response.sendRedirect( "DisplayFaculty" );
    }

}