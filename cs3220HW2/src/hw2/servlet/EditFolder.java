package hw2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditFolder")
public class EditFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditFolder() {
        super();
    }
    
    @SuppressWarnings("unchecked")
    private File1 getEntry( Integer id )
    {
        List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );

        for( File1 entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Integer id = Integer.valueOf( request.getParameter( "id" ) );
			File1 entry = getEntry( id );

	        
	        response.setContentType( "text/html" );
	        PrintWriter out = response.getWriter();
	        out.println( "<html><head><title>Edit Folder</title></head><body>" );

	        out.println( "<form action='EditFolder' method='post'>" );
	        out.println( "<p><input type='text' name='folderName' value='" + entry.getName() + "'/>" );
	        out.println( "<input type='hidden' name='id' value='" + entry.getId() + "' />" );
	        out.println( "<input type='submit' name='save' value='Save' />" );
	        out.println( "</p></form>" );

	        out.println( "</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
			Integer id = Integer.valueOf( request.getParameter( "id" ) );

			File1 entry = getEntry( id );

	        entry.setName( request.getParameter( "folderName" ) );

	        response.sendRedirect( "ViewFolder?id=" + entry.getId() );
	}

}
