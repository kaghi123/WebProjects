package d.servlet;

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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Upload")
public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    public Upload()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // Redirect the user to the upload form
        response.sendRedirect( "Upload.html" );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	 if (!ServletFileUpload.isMultipartContent(request)) {
             // if not, we stop here
             PrintWriter writer = response.getWriter();
             writer.println("Error: Form must has enctype=multipart/form-data.");
             writer.flush();
             return;
         }
  
         // configures upload settings
         DiskFileItemFactory factory = new DiskFileItemFactory();
         // sets memory threshold - beyond which files are stored in disk
         factory.setSizeThreshold(MEMORY_THRESHOLD);
         // sets temporary location to store files
         factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
  
         ServletFileUpload upload = new ServletFileUpload(factory);
          
         // sets maximum size of upload file
         upload.setFileSizeMax(MAX_FILE_SIZE);
          
         // sets maximum size of request (include file + form data)
         upload.setSizeMax(MAX_REQUEST_SIZE);
  
         // constructs the directory path to store upload file
         // this path is relative to application's directory
         String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );
          
         int count = 0;
  
         try {
             // parses the request's content to extract file data
             @SuppressWarnings("unchecked")
             List<FileItem> formItems = upload.parseRequest(request);
  
             if (formItems != null && formItems.size() > 0) {
                 // iterates over form's fields
                 for (FileItem item : formItems) {
                     // processes only fields that are not form fields
                     if (!item.isFormField()) {
                    
                	 String fileName = (new File( item.getName() )).getName();
                     File file = new File( fileDir, fileName );
                     item.write( file );
                     ++count;
                }
                 }
             }
         }
         catch (Exception e) {
           throw new ServletException("Cannot parse multipart request.", e);
        }

        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        out.println( "<html><head><title>Upload</title></head><body>" );
        out.println( "<p>" + count + " file(s) uploaded to " + fileDir );
        out.println( "</body></html>" );
    }

}