package hw2.servlet;

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
	private File1 getEntry(Integer id){
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );

		for( File1 entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
		
		 Integer id = Integer.valueOf( request.getParameter( "id" ) );
		 File1 entry1 = getEntry( id );
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>View Folder</title></head><body>" );
     
        
        
		
		
		if(entry1.getParentId() == null){
			out.println("<p><a href='FileManager'> ..\\</a>" + entry1.getName() + " "
					+ "[ <a href='CreateFolder?id=" + entry1.getId() + "'>New Folder</a> | "
					+ "<a href='Upload'>Upload</a>]</p>");
        }
    	else{
    		out.println("<p><a href='ViewFolder?id=" + entry1.getParentId() + "'> ..\\</a>" + entry1.getName() + " "
					+ "[ <a href='CreateFolder?id=" + entry1.getId() + "'>New Folder</a> | "
					+ "<a href='Upload'>Upload</a>]</p>");	
    	}
		

        for( File1 entry  : entries ) {
        	
        	if(entry1.getId() == entry.getParentId()){
        		out.println( "<tr>" );
        		out.println( "<td><a href='ViewFolder?id=" + entry.getId() + "'>"+ entry.getName() +"</a></td>"
        				+ "<td></td>"
        				+ "<td></td>"
        				+ "<td><a href='EditFolder?id=" + entry.getId() + "'>Rename</a> |"
        						+ " <a href='DeleteFolder?id=" + entry.getId() + "'>Delete</a></td>" );
        	out.println( "</tr>" );
        	}
        		
    	}
        out.println( "</table>" );
        out.println( "</body></html>" );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
