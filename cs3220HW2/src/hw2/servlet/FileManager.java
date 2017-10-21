package hw2.servlet;

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
		
		List<File1> entries = new ArrayList<File1>();
		
		entries.add( new File1(1, "My Files", null, 0, null, null, true ));
		entries.add( new File1(2, "Documents", null, 0, null, null, true ));
		entries.add( new File1(3, "Temp", null, 0, null, null, true ));

		getServletContext().setAttribute( "entries", entries );
	}

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>File Manager</title></head><body>" );
     
		out.println("<p>[<a href='CreateFolder?id=" + null + "'>New Folder<a> |"
		+ "<a href='Upload'>Upload</a>]</p>");
		

		 out.println( "<table border='1' cellpadding='2'>" );
     	out.println( "<tr>" );
     		out.println( "<th>Name</th><th>Date</th><th>Size</th><th>Operations</th>" );
     	out.println( "</tr>" );
        
        for( File1 entry  : entries ) 
        {
        	if(entry.getParentId() == null){
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