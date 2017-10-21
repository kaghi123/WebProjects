package lab9.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ListFiles")
public class ListFiles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListFiles() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>File Manager</title>" );
        out.println( "<script language='text/javascript' src='functions.js'></script>" );
        out.println( "<script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>" );
        out.println( "</head><body>" );
        
        
        
        out.println( " <script> function UploadForm() { "
        		+ "$('#UploadForm').toggle();"
        		+ " } </script>" );
        
        
        
        out.println("<a href='javascript:UploadForm()'>Upload File<a></p>");
        
        out.println("<form id='UploadForm' action='ListFiles' method='post'entype='multipart/form-data'/>");
        out.println("<p><input type='hidden' name='fileH'/>");
        out.println("<input type='file' name='file'/>");
        out.println("<input type='submit' name='submit' value='Upload File'/>");
        out.println( "</p></form>");

        
        out.println( "<script> document.getElementById('UploadForm').style.display = 'none'; </script>" );
        
        
        out.println( "</body></html>" );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute( "javax.servlet.context.tempdir" );
        factory.setRepository( repository );

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload( factory );

        // Count how many files are uploaded
        int count = 0;
        // The directory we want to save the uploaded files to.
        String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );

        // Parse the request
        try
        {
            List<FileItem> items = upload.parseRequest(request);
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
                    String fileName = (new File( item.getName() )).getName();
                    File file = new File( fileDir, fileName );
                    item.write( file );
                    ++count;
                }
            }

        }
        catch( Exception e )
        {
            throw new IOException( e );
        }

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Upload</title></head><body>" );
        out.println( "<p>" + count + " file(s) uploaded to " + fileDir );
        out.println( "</body></html>" );
    }
}
