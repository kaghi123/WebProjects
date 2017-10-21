package hw1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
	private Folder getEntry(Integer id){
		List<Folder> entries = (List<Folder>) getServletContext().getAttribute("entries" );

		for( Folder entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Folder> entries = (List<Folder>) getServletContext().getAttribute("entries" );
		
		 Integer id = Integer.valueOf( request.getParameter( "id" ) );
	     Folder entry1 = getEntry( id );
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>View Folder</title></head><body>" );
     
        
        
		out.println("<p>" + entry1.getName() + " [ <a href='CreateFolder?id=" + entry1.getId() + "' >New Folder<a> | "
				+ "<a href='EditFolder?id=" + entry1.getId() + "'>Edit Folder<a> | "
						+ "<a href='DeleteFolder?id=" + entry1.getId() + "'>Delete Folder<a> ]");
		
		if(entry1.getParentId() == null){
        	out.println("<li><a href='FileManager'> \\ ..</a></li>");
        }
    	else{
    		out.println("<li><a href='ViewFolder?id=" + entry1.getParentId() + "'> \\ ..</a></li>");
    	}
		

        out.println( "<ul id='title'>" );
        
        for( Folder entry  : entries ) 
        {
        	
         
        	if(entry1.getId() == entry.getParentId())
        	out.println( "<li><a href='ViewFolder?id=" + entry.getId() + "'> \\ "+ entry.getName() +"</a></li>" );
        }
        out.println( "</ul>" );
        out.println( "</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
