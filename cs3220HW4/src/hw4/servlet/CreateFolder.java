package hw4.servlet;

import java.io.IOException;
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
			 
		
		File1 entry = new File1( idSeed++, name, null, 0, null, parentid, true, accId );
		
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
	    entries.add( entry );
	        
	        if(entry.getParentId() == 1){
	        	response.sendRedirect( "FileManager?accId=" + accId );
	        }
	        else{
	        	response.sendRedirect( "ViewFolder?id=" + entry.getParentId() + "&accId=" + accId );
	        }
		
		
		
	}

}
