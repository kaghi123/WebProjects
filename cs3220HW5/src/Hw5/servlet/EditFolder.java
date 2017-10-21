package Hw5.servlet;

import java.io.IOException;
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
			String name = request.getParameter( "name" );
			
			
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			
			request.getRequestDispatcher( "/WEB-INF/EditFolder.jsp" ).forward( request,
					response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	
			Integer id = Integer.valueOf( request.getParameter( "id" ) );
			
			Integer accId = Integer.valueOf( request.getParameter( "accId" ));

			File1 entry = getEntry( id );

	        entry.setName( request.getParameter( "folderName" ) );

	        response.sendRedirect( "ViewFolder?id=" + entry.getId() + "&accId=" + accId  );
	}

}
