package hw1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileManager")
public class FileManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
       
    public FileManager() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		List<Folder> entries = new ArrayList<Folder>();
		
		entries.add( new Folder(1, "My Files", null));
		entries.add( new Folder(2, "Documents", null));
		entries.add( new Folder(3, "Temp", null));

		getServletContext().setAttribute( "entries", entries );
	}

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Folder> entries = (List<Folder>) getServletContext().getAttribute("entries" );
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>File Manager</title></head><body>" );
     
		out.println("<p><a href='CreateFolder?id=" + null + "'>New Folder<a>");
		

        out.println( "<ul id='title'>" );
        
        for( Folder entry  : entries ) 
        {
        	if(entry.getParentId() == null){
        		out.println( "<li><a href='ViewFolder?id=" + entry.getId() + "'> \\ "+ entry.getName() +"</a></li>" );
        	}
         
        }
        out.println( "</ul>" );
        out.println( "</body></html>" );
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
	}

}