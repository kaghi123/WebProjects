package Final;

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


@WebServlet(urlPatterns = "/Display", loadOnStartup = 1)
public class Display extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Display()
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
    	List<Course> entries = new ArrayList<Course>();
    	//List<Faculty> entriesF = new ArrayList<Faculty>();
    	Connection c = null;
    	try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";
            String username = "cs3220stu24";
            String password = "LsEokQ5j";

            c = DriverManager.getConnection( url, username,
                password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from course" );
            

            while( rs.next() )
            {
            	entries.add( new Course( rs.getString( "name" ), rs.getString( "courseType" ), rs.getBoolean("isMapped") ) );
            }
            
            rs.close();
            
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
    	
    	request.setAttribute( "entries", entries );
    	//request.setAttribute( "entriesF", entriesF );
    	
    	request.getRequestDispatcher( "/WEB-INF/Display.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	doGet( request, response );
    }

}