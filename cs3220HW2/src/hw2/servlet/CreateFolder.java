package hw2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
    
   @SuppressWarnings("unchecked")
	private File1 getEntry(Integer id){
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );

		for( File1 entry : entries )
            if( entry.getId().equals( id ) ) return entry;

        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			  
			  response.setContentType( "text/html" );
		        PrintWriter out = response.getWriter();
		        out.println( "<html><head><title>Create Folder</title></head><body>" );
				
		        out.println( "<form id='newFolder' action='CreateFolder' method='post'>" );
		        out.println( "<p><input type='text' name='folderName' />" );
		        out.println( "<input type='hidden' name='id'/>" );
		        out.println( "<input type='submit' name='submit' value='Create Folder' />" );
		        out.println( "</body></html>" );
		        out.println( "</p></form>");
		 }
	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer parentid = 0;
		
		 try{
			 Integer id = Integer.valueOf( request.getParameter( "id" ));

			 if(id != null){
				 File1 entry1 = getEntry( id );
				 parentid = entry1.getId();
			 }
			 
		  }catch(NumberFormatException ex){
			  parentid = null;
		 }
		
		String name = request.getParameter( "folderName" );
		
		
		File1 entry = new File1( idSeed++, name, null, 0, null, parentid, true );
		
		List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
	    entries.add( entry );
	        
	        if(entry.getParentId() == null){
	        	response.sendRedirect( "FileManager" );
	        }
	        else{
	        	response.sendRedirect( "ViewFolder?id=" + entry.getParentId() );
	        }
		
	}

}
