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

@WebServlet("/CreateFolder")
public class CreateFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int idSeed = 100;
	
    public CreateFolder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf( request.getParameter( "id" ));
		
		Integer acId = Integer.valueOf( request.getParameter( "accId" ) );
			
		request.setAttribute("id", id);
		
		request.setAttribute("acId", acId);
		 
		request.getRequestDispatcher( "/WEB-INF/CreateFolder.jsp" ).forward( request,
					response );
		
	}
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter( "folderName" );
		Integer parentid = Integer.valueOf( request.getParameter( "id" ));
		
		Integer accId = Integer.valueOf( request.getParameter( "accId" ));
			 
		
		//File1 entry = new File1(accId, name, name, accId, name, accId, false, accId);
		
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
	    //entries.add( entry );
	    
	    Connection c = null;
    	try
        {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu24";
            String username = "cs3220stu24";
            String password = "LsEokQ5j";
            
            String sql = "insert into file1 (id, name, type, size, date, parentId, isFolder, accId) values (?, ?, ?, ?, ?, ?, ?, ?)";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt(1, idSeed++);
            pstmt.setString( 2, name );
            pstmt.setString( 3, null );
            pstmt.setInt(4, 0);
            pstmt.setString(5, null);
            pstmt.setInt(6, parentid);
            pstmt.setBoolean(7, true);
            pstmt.setInt(8, accId);
            
            
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
	        
	        if(parentid == 1){
	        	response.sendRedirect( "FileManager?accId=" + accId );
	        }
	        else{
	        	response.sendRedirect( "ViewFolder?id=" + parentid + "&accId=" + accId );
	        }
		
		
		
	}

}
