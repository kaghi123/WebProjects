package hw3.servlet;

import java.io.IOException;
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
		
		entries.add( new File1(1, "Parent", null, 0, null, null, true ));
		entries.add( new File1(2, "My Files", null, 0, null, 1, true ));
		entries.add( new File1(3, "Documents", null, 0, null, 1, true ));
		entries.add( new File1(4, "Temp", null, 0, null, 1, true ));

		getServletContext().setAttribute( "entries", entries );
	}

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
		
		int counter = 0;
		
		for( File1 entry  : entries ) {
			
			entry = entries.get(counter);
			
			
			Integer id = entry.getId();
			String name = entry.getName();
			String type = entry.getType();
	        Long size = entry.getSize();
	        String date = entry.getDate();
	        Integer parentId = entry.getParentId();
	        Boolean isFolder = entry.getIsFolder();
			
			request.setAttribute("id", id);
			request.setAttribute( "name", name );
			request.setAttribute( "type", type  );
			request.setAttribute( "size", size );
			request.setAttribute( "date", date );
			request.setAttribute( "parentId", parentId  );
			request.setAttribute( "isFolder", isFolder );
			
			
		}
        
		request.getRequestDispatcher( "/WEB-INF/FileManager.jsp" ).forward( request,
		         response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
	}

}