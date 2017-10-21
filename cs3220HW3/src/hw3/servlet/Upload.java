package hw3.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Integer idSeed = 500;
	String fileName = "";
	String fileType = "";
	long size = 0;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("MM.dd.yyyy hh:mm:ss a");
       
    public Upload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher( "/WEB-INF/Upload.jsp" ).forward( request,
		         response );
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig()
            .getServletContext();
        File repository = (File) servletContext
            .getAttribute( "javax.servlet.context.tempdir" );
        factory.setRepository( repository );

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload( factory );

        // The directory we want to save the uploaded files to.
        String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );

        // Parse the request
        try
        {
            List<FileItem> items = upload.parseRequest( request );
            for( FileItem item : items )
            {
                // If the item is not a form field - meaning it's an uploaded
                // file, we save it to the target dir
                if( !item.isFormField() )
                {
                    // item.getName() will return the full path of the uploaded
                    // file, e.g. "C:/My Documents/files/test.txt", but we only
                    // want the file name part, which is why we first create a
                    // File object, then use File.getName() to get the file
                    // name.
                    fileName = (new File( item.getName() )).getName();
                    File file = new File( fileDir, fileName );
                    item.write( file );
                    size = file.length();
                    Integer parentid = 0;
            		
           		 
           			Integer id = Integer.valueOf( request.getParameter( "id" ));

           			parentid = id;
   				 	
                    File1 entry = new File1(idSeed, fileName, fileType, size, ft.format(date), parentid, false);
                    
                    List<File1> entries = (List<File1>) getServletContext().getAttribute("entries" );
            	    entries.add( entry );
            	    
            	    if(entry.getParentId() == 1){
        	        	response.sendRedirect( "FileManager" );
        	        }
        	        else{
        	        	response.sendRedirect( "ViewFolder?id=" + entry.getParentId() );
        	        }
                }
            }

        }
        catch( Exception e )
        {
          //  throw new IOException( e ); 
        	System.out.println("NOT WORKING");
        }
	}

}
