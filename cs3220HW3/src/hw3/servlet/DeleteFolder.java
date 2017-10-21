package hw3.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFolder")
public class DeleteFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFolder() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Integer id = Integer.valueOf( request.getParameter( "id" ) );
		 
	        List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
	        
	        
	        for( File1 entry : entries )
	            if( entry.getId().equals( id ) )
	            {
	                entries.remove( entry );
	                break;
	            }

	        response.sendRedirect( "FileManager" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
