package Hw5.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewFolder")
public class ViewFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewFolder() {
        super();
    }
    
    @SuppressWarnings("unchecked")
	private File1 getEntry(Integer id){
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );

		for( File1 entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Integer id = Integer.valueOf( request.getParameter( "id" ) );
		 Integer accId = Integer.valueOf( request.getParameter( "accId" ) );
		 
		 request.setAttribute("id", id);
		 request.setAttribute("accId", accId);
		 
		 File1 entry1 = getEntry( id );
		 Integer mainId = entry1.getId();
		 request.setAttribute("mainId", mainId);
        
		 request.getRequestDispatcher( "/WEB-INF/ViewFolder.jsp" ).forward( request,
		         response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
