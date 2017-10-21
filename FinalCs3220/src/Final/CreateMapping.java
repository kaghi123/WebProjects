package Final;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateMapping")
public class CreateMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateMapping() {
        super();
    }

    @SuppressWarnings("unchecked")
	protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
    	List<Course> entries = (List<Course>) getServletContext().getAttribute("entries" );
    	
    	//request.setAttribute( "entries", entries );
    	
        request.getRequestDispatcher( "/WEB-INF/CreateMapping.jsp" )
            .forward( request, response );
    }

    @SuppressWarnings("unchecked")
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	

    	 response.sendRedirect( "Display" );
    }

}